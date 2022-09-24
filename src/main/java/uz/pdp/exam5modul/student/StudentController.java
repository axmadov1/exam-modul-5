package uz.pdp.exam5modul.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.exam5modul.faculty.Faculty;
import uz.pdp.exam5modul.faculty.FacultyDao;
import uz.pdp.exam5modul.university.University;
import uz.pdp.exam5modul.university.UniversityDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")

public class StudentController {

    private final StudentDao studentDao;
    private final FacultyDao facultyDao;
    private final UniversityDao universityDao;


    @PostMapping
    public String addStudent(StudentDto studentDto){
        studentDao.addNewStudent(studentDto);
        return "redirect:/students";
    }

    @PostMapping("/edit")
    public String editStudent(StudentDto studentDto){
        studentDao.editStudent(studentDto);
        return "redirect:/students";
    }


    @GetMapping()
    public String getAllStudentsfromdb(Model model){
        List<StudentDto> allStudents = studentDao.getAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "view-students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        studentDao.delete(id);
        return "redirect:/students";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        List<StudentDto> studentById = studentDao.getStudentById(id);
        model.addAttribute("student", studentById);
        List<Faculty> facultyList = facultyDao.getAllFacultiesfromDb();
        List<University> universityList = universityDao.getAllUniversityFromDb();
        model.addAttribute("facultyList", facultyList);
        model.addAttribute("universityList", universityList);
        return "edit-student";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        List<Faculty> facultyList = facultyDao.getAllFacultiesfromDb();
        List<University> universityList = universityDao.getAllUniversityFromDb();
        model.addAttribute("facultyList", facultyList);
        model.addAttribute("universityList", universityList);
        return "add-student";
    }

}
