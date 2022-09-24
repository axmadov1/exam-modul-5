package uz.pdp.exam5modul.student;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor

public class StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public List<StudentDto> getAllStudents() {
        String sql = "select s.id, s.name, s.surname, s.course, u.name, f.name  " +
                "from student s join university u on u.id = s.\"universityId\" " +
                "join faculty f on f.id = s.\"facultyId\";";

        return jdbcTemplate.query(sql, (rs, row) ->
                StudentDto.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .surname(rs.getString(3))
                        .course(rs.getInt(4))
                        .universityName(rs.getString(5))
                        .facultyName(rs.getString(6)).build()
                );
    }

    public void delete(int id) {
        String sql = "delete from student where id=" + id;
        jdbcTemplate.update(sql);
    }

    public void addNewStudent(StudentDto studentDto) {
        String sql = "insert into student(name, surname, course, \"facultyId\", \"universityId\") " +
                "VALUES ('"+studentDto.getName()+"', '"+studentDto.getSurname()+"', "+studentDto.getCourse()+", "+studentDto.getFacultyId()+", "+studentDto.getUniversityId()+")";

        jdbcTemplate.update(sql);
    }

    public List<StudentDto> getStudentById(int id) {
        String sql = "select s.id, s.name, s.surname, s.course, u.id, u.name, f.id, f.name from student s\n" +
                "    join faculty f on f.id = s.\"facultyId\"\n" +
                "    join university u on u.id = s.\"universityId\" where s.id=" + id;

        return jdbcTemplate.query(sql, (rs, row) ->
                StudentDto.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .surname(rs.getString(3))
                        .course(rs.getInt(4))
                        .universityId(rs.getInt(5))
                        .universityName(rs.getString(6))
                        .facultyId(rs.getInt(7))
                        .facultyName(rs.getString(8)).build());
    }

    public void editStudent(StudentDto studentDto) {
        String sql = "update student set name=?, surname=?, course=?, \"universityId\"=?, \"facultyId\"=? where id=?";
        jdbcTemplate.update(sql, studentDto.getName(), studentDto.getSurname(),
                studentDto.getCourse(), studentDto.getUniversityId(),
                studentDto.getFacultyId(), studentDto.getId());
    }
}
