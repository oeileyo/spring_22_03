package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {
    private final NewsService newsService;

    @Autowired
    public RestApiController(NewsService newsService){
        this.newsService = newsService;
    }

    @PostMapping(value = "/api/news")
    public ResponseEntity<?> create(@RequestBody News news){
        newsService.create(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/news")
    public ResponseEntity<List<News>> findAll(){
        final List<News> newsList = newsService.findAll();

        return newsList != null && !newsList.isEmpty()
                ? new ResponseEntity<>(newsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/news/{id}")
    public ResponseEntity<News> find(@PathVariable(name="id") Long id){
        final News news = newsService.find(id);

        return news != null
                ? new ResponseEntity<>(news, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        newsService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
