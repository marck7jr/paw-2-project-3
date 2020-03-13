package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.ic.web2.javatacado.DAO.ClockInControlDAO;
import br.ufmt.ic.web2.javatacado.DAO.EmployeeDAO;
import br.ufmt.ic.web2.javatacado.Models.ClockInControl;

@Controller
@RequestMapping("/clockincontrol")
public class ClockInControlController {

    @Autowired
    private ClockInControlDAO clockInControlDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping
    public String onGet(Model model) {
        model.addAttribute("clockInControlNew", new ClockInControl());
        model.addAttribute("clockInControlList", clockInControlDAO.findAll());
        model.addAttribute("employeeList", employeeDAO.findAll());

        return "clockincontrol";
    }

    @PostMapping("/save")
    public String onPost(@ModelAttribute("clockInControlNew") ClockInControl clockInControl){
        clockInControlDAO.save(clockInControl);

        return "redirect:/clockincontrol";
    }

    @GetMapping("/edit/{id}")
    public String onPut(@ModelAttribute("id") long id, Model model){
        onGet(model);
        model.addAttribute("clockInControlNew", clockInControlDAO.findById(id).get());

        return "clockincontrol";
    }

    @GetMapping("/delete/{id}")
    public String onDelete(@ModelAttribute("id") long id){
        clockInControlDAO.deleteById(id);

        return "redirect:/clockincontrol";
    }
}