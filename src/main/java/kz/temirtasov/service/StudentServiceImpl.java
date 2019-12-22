package kz.temirtasov.service;

import kz.temirtasov.model.Student;
import kz.temirtasov.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.update(student);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Student get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Student> getAll() {
        return repository.getAll();
    }
}
