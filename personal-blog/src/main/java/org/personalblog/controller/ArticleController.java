package org.personalblog.controller;

import jakarta.validation.Valid;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("article", new ArticleDto());
        model.addAttribute("articles", articleService.getAllArticles());
        return "index";
    }


    @PostMapping("/admin/new")
    @ResponseBody
    public ResponseEntity<?> addArticle(@Valid @ModelAttribute("article") ArticleDto articleDto, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            articleService.addArticle(articleDto);
            model.addAttribute("articles", articleService.getAllArticles());
        }
        return ResponseEntity.ok().body(Map.of(
                "status", "success",
                "message", "Datos procesados correctamente",
                "data", "success"
        ));
    }
}
