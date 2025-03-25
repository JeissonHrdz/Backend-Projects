package org.personalblog.model.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Article {


    private int id;
    private String title;
    private String date;
    private long content;

}
