package uz.pdp.exam5modul.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.exam5modul.faculty.FacultyDao;
import uz.pdp.exam5modul.faculty.Faculty;
import uz.pdp.exam5modul.university.University;
import uz.pdp.exam5modul.university.UniversityDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/faculty")

public class FacultyController {

    private final FacultyDao facultyDao;


    @PostMapping
    public String addFaculty(Faculty faculty){
        facultyDao.addNewFaculty(faculty);
        return "redirect:/faculty";
    }

    @PostMapping("/edit")
    public String editFaculty(Faculty faculty){
        facultyDao.editFaculty(faculty);
        return "redirect:/faculty";
    }


    @GetMapping()
    public String getAllFacultysfromdb(Model model){
        List<Faculty> allFacultys = facultyDao.getAllFacultiesfromDb();
        model.addAttribute("allFacultys", allFacultys);
        return "view-faculty";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        facultyDao.delete(id);
        return "redirect:/faculty";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        List<Faculty> facultyById = facultyDao.getFacultyById(id);
        model.addAttribute("faculty", facultyById);
        return "edit-faculty";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        return "add-faculty";
    }

}
