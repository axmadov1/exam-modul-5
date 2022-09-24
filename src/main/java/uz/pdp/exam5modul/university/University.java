package uz.pdp.exam5modul.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class University {

    private Integer id;
    private String name;
    private String description;

}
