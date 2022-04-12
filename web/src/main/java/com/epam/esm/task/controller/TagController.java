package com.epam.esm.task.controller;


import com.epam.esm.task.entity.impl.Tag;
import com.epam.esm.task.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tagDtos")
public class TagController {

    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tag> getTags() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity addTag(@RequestBody Tag entity) {
        try{
            service.save(entity);
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTag(@PathVariable long id) {
        try{
            service.delete(id);
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
        }
    }
    @GetMapping("/{id}")
    public Tag getByIdTag(@PathVariable long id) {
        return service.findById(id);
    }
}
