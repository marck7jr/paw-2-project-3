package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.ic.web2.javatacado.DAO.AccountDAO;
import br.ufmt.ic.web2.javatacado.Models.Account;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @GetMapping
    public String onGet(Model model){
        model.addAttribute("accountNew", new Account());
        model.addAttribute("accountList", accountDAO.findAll());

        return "account";
    }

    @PostMapping("/save")
    public String onPost(@ModelAttribute("accountNew") Account account){
        accountDAO.save(account);

        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String onPut(@ModelAttribute("id") long id, Model model){
        onGet(model);
        model.addAttribute("accountNew", accountDAO.findById(id).get());

        return "account";
    }

    @GetMapping("/delete/{id}")
    public String onDelete(@ModelAttribute("id") long id){
        accountDAO.deleteById(id);

        return "redirect:/account";
    }
}