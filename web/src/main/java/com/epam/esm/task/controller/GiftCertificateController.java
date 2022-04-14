package com.epam.esm.task.controller;

import com.epam.esm.task.dto.impl.GiftCertificateDto;
import com.epam.esm.task.entity.impl.GiftCertificate;
import com.epam.esm.task.exception.ServiceException;
import com.epam.esm.task.service.impl.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/gifts")
public class GiftCertificateController {

    private final GiftCertificateService service;

    @Autowired
    public GiftCertificateController(GiftCertificateService service) {
        this.service = service;
    }

    @GetMapping
    public List<GiftCertificateDto> getGiftCertificate() throws ServiceException {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addGiftCertificate(@RequestBody GiftCertificateDto entity) throws ServiceException {
        service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGiftCertificate(@PathVariable long id) throws ServiceException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateGiftCertificate(@PathVariable("id") long id,
                                                @RequestBody GiftCertificateDto entity) throws ServiceException {
        service.update(entity,id);
        return ResponseEntity.status(HttpStatus.CREATED).body("updated");
    }

    @GetMapping("/filter")
    public List<GiftCertificateDto> getByFilter(@RequestParam Map<String,String> param) {
        return service.findByParam(param);
    }
}
