package kz.temirtasov.repository;

import kz.temirtasov.model.Student;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class JpaStudentRepository implements StudentRepository {

    @PersistenceContext(unitName = "students")
    private EntityManager em;

    @Override
    @Transactional
    public Student save(Student student) {
        if (student.isNew()) {
            em.persist(student);
            return student;
        } else {
            return em.merge(student);
        }
    }

    @Override
    public Student get(int id) {
        return em.find(Student.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Student.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Student> getAll() {
        List<Student> resultList = em.createNamedQuery(Student.ALL_SORTED, Student.class).getResultList();
        return resultList;
    }
}