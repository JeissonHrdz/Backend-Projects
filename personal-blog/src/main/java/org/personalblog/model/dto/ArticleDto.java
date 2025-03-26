package org.personalblog.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleDto {

    private String id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Date cannot be empty")
    private String date;

    @NotBlank(message = "Content cannot be empty")
    private String content;
}
