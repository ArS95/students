package kz.temirtasov.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = Student.DELETE, query = "DELETE FROM Student s WHERE s.id=:id"),
        @NamedQuery(name = Student.ALL_SORTED, query = "SELECT s FROM Student s ORDER BY s.id")
})
@Entity
@Table(name = "students")
public class Student {

    public static final String DELETE = "Student.delete";
    public static final String ALL_SORTED = "Student.getAllSorted";

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "full_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String fullName;

    @Column(name = "faculty", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String faculty;

    public Student() {
    }

    public Student(Student s) {
        this(s.getId(), s.getFullName(), s.getFaculty());
    }

    public Student(Integer id, String fullName, String faculty) {
        this.id = id;
        this.fullName = fullName;
        this.faculty = faculty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
