package org.personalblog.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleDto {

    private int id;
    private String title;
    private String date;
    private long content;
}
