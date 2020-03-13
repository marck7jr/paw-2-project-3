package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.ic.web2.javatacado.DAO.RoleDAO;
import br.ufmt.ic.web2.javatacado.Models.Role;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleDAO roleDAO;

    @GetMapping
    public String onGet(Model model){
        model.addAttribute("roleNew", new Role());
        model.addAttribute("roleList", roleDAO.findAll());

        return "role";
    }

    @PostMapping("/save")
    public String onSave(@ModelAttribute Role role){
        roleDAO.save(role);

        return "redirect:/role";
    }

    @GetMapping("/edit/{id}")
    public String onPut(@ModelAttribute("id") long id, Model model){
        onGet(model);
        model.addAttribute("roleNew", roleDAO.findById(id).get());

        return "role";
    }

    @GetMapping("/delete/{id}")
    public String onDelete(@ModelAttribute("id") long id){
        roleDAO.deleteById(id);

        return "redirect:/role";
    }
}