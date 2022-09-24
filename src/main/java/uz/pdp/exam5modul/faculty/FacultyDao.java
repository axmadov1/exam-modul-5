package uz.pdp.exam5modul.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.exam5modul.faculty.Faculty;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FacultyDao {

    private final JdbcTemplate jdbcTemplate;


    public List<Faculty> getAllFacultiesfromDb() {
        String sql = "select f.id, f.name from faculty f";
        return jdbcTemplate.query(sql, (rs, row) ->
                Faculty.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build());
    }


    public void delete(int id) {
        String sql = "delete from faculty where id=" + id;
        jdbcTemplate.update(sql);
    }

    public void addNewFaculty(Faculty faculty) {
        String sql = "insert into faculty(name) VALUES ('"+faculty.getName()+"')";
        jdbcTemplate.update(sql);
    }

    public List<Faculty> getFacultyById(int id) {
        String sql = "select f.id, f.name from faculty f where f.id=" + id;

        return jdbcTemplate.query(sql, (rs, row) ->
                Faculty.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build());
    }

    public void editFaculty(Faculty faculty) {
        String sql = "update faculty set name=? where id=?";
        jdbcTemplate.update(sql, faculty.getName(), faculty.getId());
    }
}
