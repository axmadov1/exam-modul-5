package uz.pdp.exam5modul.university;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.exam5modul.university.University;

import java.util.List;

@Component
@RequiredArgsConstructor

public class UniversityDao {

    private final JdbcTemplate jdbcTemplate;

    public List<University> getAllUniversityFromDb() {
        String sql = "select u.id, u.name from university u";
        return jdbcTemplate.query(sql, (rs, row) ->
                University.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build());
    }

    public void delete(int id) {
        String sql = "delete from university where id=" + id;
        jdbcTemplate.update(sql);
    }

    public void addNewUniversity(University university) {
        String sql = "insert into university(name) VALUES ('"+university.getName()+"')";
        jdbcTemplate.update(sql);
    }

    public List<University> getUniversityById(int id) {
        String sql = "select f.id, f.name from university f where f.id=" + id;

        return jdbcTemplate.query(sql, (rs, row) ->
                University.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build());
    }

    public void editUniversity(University university) {
        String sql = "update university set name=? where id=?";
        jdbcTemplate.update(sql, university.getName(), university.getId());
    }
}
