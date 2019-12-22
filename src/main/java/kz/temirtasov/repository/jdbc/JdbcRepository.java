package kz.temirtasov.repository.jdbc;

import kz.temirtasov.model.Student;
import kz.temirtasov.repository.StudentRepository;
import kz.temirtasov.repository.jdbc.sql.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class JdbcRepository implements StudentRepository {

    private final SqlHelper sqlHelper;
    private static final Logger LOG = Logger.getLogger(JdbcRepository.class.getName());
    private final String INSERT = "INSERT INTO students (full_name,faculty) VALUES (?,?)";
    private final String UPDATE = "UPDATE students SET full_name = ?, faculty = ? WHERE id=?";
    private final String DELETE = "DELETE FROM students WHERE id = ?";
    private final String GET = "SELECT * FROM students WHERE id = ?";
    private final String GETALL = "SELECT * FROM students ORDER BY id";

    public JdbcRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        sqlHelper = new SqlHelper("jdbc:postgresql://localhost:5432/students", "user", "password");
    }

    @Override
    public Student save(Student student) {
        return sqlHelper.execute(st -> {
            st.setString(1, student.getFullName());
            st.setString(2, student.getFaculty());
            st.execute();
            return null;
        }, INSERT);
    }

    @Override
    public Student update(Student student) {
        return sqlHelper.execute(st -> {
            st.setString(1, student.getFullName());
            st.setString(2, student.getFaculty());
            st.setInt(3, student.getId());
            st.executeUpdate();
            return null;
        }, UPDATE);
    }

    @Override
    public boolean delete(int id) {
        return sqlHelper.execute(st -> {
            st.setInt(1, id);
            return st.executeUpdate() > 0;
        }, DELETE);
    }

    @Override
    public Student get(int id) {
        return sqlHelper.execute(st -> {
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            if (!resultSet.next()) {
                LOG.warning("Student " + id + " not exist");
                return null;
            }
            return new Student(id, resultSet.getString("full_name"), resultSet.getString("faculty"));
        }, GET);
    }

    @Override
    public List<Student> getAll() {
        return sqlHelper.execute(st -> {
            ResultSet resultSet = st.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getString("faculty")));
            }
            return studentList;
        }, GETALL);
    }
}
