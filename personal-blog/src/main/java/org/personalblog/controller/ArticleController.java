package org.personalblog.controller;

import org.personalblog.model.dto.ArticleDto;
import org.personalblog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("article", new ArticleDto());
        // Si necesitas pasar datos a la vista index.html
        return "index";   }


    @PostMapping("/admin/new")
    public String addArticle(@ModelAttribute("article") ArticleDto articleDto, Model model) {
        articleService.addArticle(articleDto);
        return "redirect:/home"; // Redirige para evitar reenvíos del formulario
    }

}
