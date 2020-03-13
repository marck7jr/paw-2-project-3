package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.ic.web2.javatacado.DAO.SubsidiaryDAO;
import br.ufmt.ic.web2.javatacado.Models.Subsidiary;

@Controller
@RequestMapping("/subsidiary")
public class SubsidiaryController {

    @Autowired
    private SubsidiaryDAO subsidiaryDAO;

    @GetMapping
    public String onGet(Model model) {
        model.addAttribute("subsidiaryNew", new Subsidiary());
        model.addAttribute("subsidiaryList", subsidiaryDAO.findAll());

        return "subsidiary";
    }

    @PostMapping("/save")
    public String onPost(@ModelAttribute("subsidiaryNew") Subsidiary subsidiary){
        subsidiaryDAO.save(subsidiary);

        return "redirect:/subsidiary";
    }

    @GetMapping("/edit/{id}")
    public String onPut(@ModelAttribute("id") long id, Model model){
        onGet(model);
        model.addAttribute("subsidiaryNew", subsidiaryDAO.findById(id).get());

        return "subsidiary";
    }

    @GetMapping("/delete/{id}")
    public String onDelete(@ModelAttribute("id") long id){
        subsidiaryDAO.deleteById(id);

        return "redirect:/subsidiary";
    }
}