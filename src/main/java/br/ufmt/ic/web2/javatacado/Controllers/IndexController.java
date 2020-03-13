package br.ufmt.ic.web2.javatacado.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping
    public String onGet(Model model){
        return "index.html";
    }
}