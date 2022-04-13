package com.epam.esm.task.controller;

import com.epam.esm.task.dto.impl.GiftCertificateDto;
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
    public List<GiftCertificateDto> getGiftCertificate() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity addGiftCertificate(@RequestBody GiftCertificateDto entity) {
        service.save(entity);
        return ResponseEntity.ok("Server is working");
//        try{
//
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
//        }
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

    @PatchMapping("/{id}")
    public ResponseEntity updateGiftCertificate(@PathVariable("id") long id,
                                                @RequestBody GiftCertificateDto entity) {
        service.update(entity,id);
        return ResponseEntity.ok("Server is working");
//        try{
//
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Server is not working 404 bad request");
//        }
    }

}
