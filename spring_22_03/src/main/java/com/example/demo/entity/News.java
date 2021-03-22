package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Data
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String creation_date;
    private String change_date;
    private String text;
    private String category;
}
