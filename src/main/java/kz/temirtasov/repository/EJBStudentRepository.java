package kz.temirtasov.repository;

import kz.temirtasov.model.Student;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;


public class EJBStudentRepository {

//    @PersistenceUnit(unitName = "studentsUnit")
    private EntityManager em;


    @PostConstruct
    protected void getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentsUnit");
        em = emf.createEntityManager();
    }
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