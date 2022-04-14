package com.epam.esm.task.controller;

import com.epam.esm.task.dto.impl.TagDto;
import com.epam.esm.task.exception.ServiceException;
import com.epam.esm.task.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public List<TagDto> getTags() throws ServiceException {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addTag(@RequestBody TagDto entity) throws ServiceException {
        service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable long id) throws ServiceException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }
    @GetMapping("/{id}")
    public TagDto getByIdTag(@PathVariable long id) throws ServiceException {
        return service.findById(id);
    }
}
