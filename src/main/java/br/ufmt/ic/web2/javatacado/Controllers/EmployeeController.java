package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.ic.web2.javatacado.DAO.AccountDAO;
import br.ufmt.ic.web2.javatacado.DAO.EmployeeDAO;
import br.ufmt.ic.web2.javatacado.DAO.RoleDAO;
import br.ufmt.ic.web2.javatacado.DAO.SubsidiaryDAO;
import br.ufmt.ic.web2.javatacado.Models.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private SubsidiaryDAO subsidiaryDAO;

    @GetMapping
    public String onGet(Model model){
        model.addAttribute("employeeNew", new Employee());
        model.addAttribute("employeeList", employeeDAO.findAll());
        model.addAttribute("accountList", accountDAO.findAll());
        model.addAttribute("roleList", roleDAO.findAll());
        model.addAttribute("subsidiaryList", subsidiaryDAO.findAll());

        return "employee";
    }

    @PostMapping("/save")
    public String onPost(@ModelAttribute("employeeNew") Employee employee){
        employeeDAO.save(employee);

        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String onPut(@ModelAttribute("id") long id, Model model){
        onGet(model);
        model.addAttribute("employeeNew", employeeDAO.findById(id).get());

        return "employee";
    }

    @GetMapping("/delete/{id}")
    public String onPut(@ModelAttribute("id") long id){
        employeeDAO.deleteById(id);

        return "redirect:/employee";
    }
}