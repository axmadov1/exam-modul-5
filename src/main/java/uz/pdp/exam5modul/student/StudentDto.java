package uz.pdp.exam5modul.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private Integer course;
    private String facultyName;
    private String universityName;
}
