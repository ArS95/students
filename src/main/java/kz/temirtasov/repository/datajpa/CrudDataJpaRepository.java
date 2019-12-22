package kz.temirtasov.repository.datajpa;

import kz.temirtasov.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudDataJpaRepository extends JpaRepository<Student, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.id=:id")
    int delete(@Param("id") int id);
}
