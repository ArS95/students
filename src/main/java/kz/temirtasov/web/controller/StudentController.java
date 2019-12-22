package kz.temirtasov.web.controller;

import kz.temirtasov.model.Student;
import kz.temirtasov.service.StudentService;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Component
@Named
@SessionScoped
public class StudentController implements Serializable {

    private List<Student> students;
    private Student tempStudent;

    @Autowired
    private  StudentService service;

    @PostConstruct
    public void init() {
        this.students = service.getAll();
    }

    public String delete(int id) {
        service.delete(id);
        init();
        return "";
    }

    public void create(Student student) {
        this.service.save(student);
    }

    public void update(Student student) {
        service.update(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void onRowEdit(RowEditEvent event) {
        Student student = (Student) event.getObject();
        String action;
        if (student.getId() == null) {
            this.create(student);
            tempStudent = null;
            action = "Added";
            init();
        } else {
            this.update(student);
            action = "Updated";
        }
        printMessage("Student " + action, student.getId());
    }

    public void onRowCancel(RowEditEvent event) {
        printMessage("Update Cancelled ", ((Student) event.getObject()).getId());
    }

    public void addStudent() {
        tempStudent = new Student(null, "Enter the Name...", "Enter the Faculty...");
        this.students.add(tempStudent);
    }

    private void printMessage(String message, Integer id) {
        FacesMessage msg = new FacesMessage(message, id == null ? "" : id.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
