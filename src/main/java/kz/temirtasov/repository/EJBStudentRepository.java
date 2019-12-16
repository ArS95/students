package kz.temirtasov.repository;

import kz.temirtasov.model.Student;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class EJBStudentRepository {

    @PersistenceContext(unitName = "studentsUnit")
    private EntityManager em;

    @Transactional
    public Student save(Student student) {
        if (student.isNew()) {
            em.persist(student);
            return student;
        } else {
            return em.merge(student);
        }
    }

    public Student get(int id) {
        return em.find(Student.class, id);
    }

    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Student.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    public List<Student> getAll() {
        List<Student> resultList = em.createNamedQuery(Student.ALL_SORTED, Student.class).getResultList();
        return resultList;
    }
}