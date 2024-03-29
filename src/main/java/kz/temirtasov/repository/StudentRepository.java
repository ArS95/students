package kz.temirtasov.repository;


import kz.temirtasov.model.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);

    Student update(Student student);

    // false if not found
    boolean delete(int id);

    // null if not found
    Student get(int id);

    List<Student> getAll();
}
