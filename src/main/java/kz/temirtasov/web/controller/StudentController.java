package kz.temirtasov.web.controller;

import kz.temirtasov.model.Student;
import kz.temirtasov.repository.EJBStudentRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StudentController {

    private List<Student> students;

    @Inject
    private EJBStudentRepository repository;

    public EJBStudentRepository getRepository() {
        return repository;
    }

    @PostConstruct
    public void init() {
        this.students = repository.getAll();
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void create(Student student) {
        repository.save(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
