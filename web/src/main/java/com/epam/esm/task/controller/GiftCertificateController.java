package com.epam.esm.task.controller;

import com.epam.esm.task.entity.impl.GiftCertificate;
import com.epam.esm.task.service.impl.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/gifts")
public class GiftCertificateController {

    private final GiftCertificateService service;

    @Autowired
    public GiftCertificateController(GiftCertificateService service) {
        this.service = service;
    }

    @GetMapping
    public List<GiftCertificate> getGiftCertificate() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity addGiftCertificate(@RequestBody GiftCertificate entity) {
        try{
            service.save(entity);
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGiftCertificate(@PathVariable long id) {
        try{
            service.delete(id);
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateGiftCertificate(@PathVariable("id") long id,
                                                @RequestBody GiftCertificate entity) {
        try{
            service.update(entity);
            return ResponseEntity.ok("Server is working");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
        }
    }

}
