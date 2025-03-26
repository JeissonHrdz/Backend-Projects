package org.personalblog.model.entity;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Article {


    private String id;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Date cannot be empty")
    private String date;

    @NotEmpty(message = "Content cannot be empty")
    private String content;

}
