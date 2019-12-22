package kz.temirtasov.repository.datajpa;

import kz.temirtasov.model.Student;
import kz.temirtasov.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DataJpaStudentRepository implements StudentRepository{

    private static final Sort SORT_ID = Sort.by(Sort.Direction.ASC, "id");

    @Autowired
    private CrudDataJpaRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return save(student);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Student get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll(SORT_ID);
    }
}
