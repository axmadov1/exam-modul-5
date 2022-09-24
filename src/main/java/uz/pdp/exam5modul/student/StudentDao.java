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
        String sql = "delete from users where id=" + id;
        jdbcTemplate.update(sql);
    }
}
