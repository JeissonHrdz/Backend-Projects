package org.personalblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JsonUtil {




    static Logger logger = Logger.getLogger(JsonUtil.class.getName());

    public static List<Article> readJson(String FILE_PATH) {
        ObjectMapper mapper = new ObjectMapper();
        List<Article> articles = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                articles = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Article.class));
            }
        } catch (IOException e) {
            logger.info("Error al leer el archivo JSON: " + e.getMessage());
        }
        return articles;
    }

    public static void saveJson(String FILE_PATH, List<Article> articles) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            mapper.writeValue(new File(FILE_PATH), articles);
        } catch (IOException e) {
            logger.info("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }


}
