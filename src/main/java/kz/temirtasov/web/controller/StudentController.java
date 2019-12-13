package kz.temirtasov.web.controller;

import kz.temirtasov.model.Student;
import kz.temirtasov.repository.StudentRepository;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class StudentController  {

    @Inject
    private StudentRepository repository;

    public void delete(int id) {
        repository.delete(id);
    }

    public void create(Student student) {
        repository.save(student);
    }

    public Student get(int id) {
        return repository.get(id);
    }

    public List<Student> getAll() {
        return repository.getAll();
    }

}
