package org.personalblog.controller;

import jakarta.validation.Valid;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;
import org.personalblog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<?> addArticle(@Valid @ModelAttribute("article") ArticleDto articleDto, BindingResult result,Model model) {
        if (result.hasErrors()){ // Si hay errores
            Map<String, String> errors = new HashMap<>(); // Creamos un HashMap para almacenar los errores
            result.getFieldErrors().forEach(error ->{ // Recorremos los errores y los añadimos al HashMap
               errors.put(error.getField(), error.getDefaultMessage()); // Añadimos el campo y el mensaje de error
            });

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", "error",
                            "errors", errors
                    ));
        }

        articleService.addArticle(articleDto);
        model.addAttribute("articles", articleService.getAllArticles());

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "valid form"
        ));//
    }

    @GetMapping("/article/{id}")
    @ResponseBody
    public ResponseEntity<?> getArticle(@PathVariable String id, Model model) {
        Article article = articleService.getArticleById(id);
        return ResponseEntity.ok(article);
    }
}
