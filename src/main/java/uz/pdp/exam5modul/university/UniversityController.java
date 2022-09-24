package uz.pdp.exam5modul.university;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.exam5modul.university.University;
import uz.pdp.exam5modul.university.UniversityDao;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/university")

public class UniversityController {
    private final UniversityDao universityDao;


    @PostMapping
    public String addUniversity(University university){
        universityDao.addNewUniversity(university);
        return "redirect:/university";
    }

    @PostMapping("/edit")
    public String editUniversity(University university){
        universityDao.editUniversity(university);
        return "redirect:/university";
    }


    @GetMapping()
    public String getAllUniversitysfromdb(Model model){
        List<University> allUniversitys = universityDao.getAllUniversityFromDb();
        model.addAttribute("allUniversitys", allUniversitys);
        return "view-university";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        universityDao.delete(id);
        return "redirect:/university";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        List<University> universityById = universityDao.getUniversityById(id);
        model.addAttribute("university", universityById);
        return "edit-university";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        return "add-university";
    }
}
