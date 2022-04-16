package com.epam.esm.task.controller;

import com.epam.esm.task.dto.impl.GiftCertificateDto;
import com.epam.esm.task.exception.ServiceException;
import com.epam.esm.task.service.impl.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/gifts")
@Validated
@Profile("prod")
public class GiftCertificateController {

    private final GiftCertificateService service;

    @Autowired
    public GiftCertificateController(GiftCertificateService service) {
        this.service = service;
    }

    @GetMapping
    public List<GiftCertificateDto> getAllGiftCertificate() throws ServiceException {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addGiftCertificate(@Valid @RequestBody GiftCertificateDto entity) throws ServiceException {
        service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGiftCertificate(@PathVariable @Min(1) long id) throws ServiceException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateGiftCertificate(@PathVariable("id") @Min(1) long id,
                                              @Valid @RequestBody GiftCertificateDto entity) throws ServiceException {
        service.update(entity,id);
        return ResponseEntity.status(HttpStatus.CREATED).body("updated");
    }

    @GetMapping("/{id}")
    public GiftCertificateDto getGiftCertificate(@PathVariable("id") @Min(1) long id) throws ServiceException {
        return service.findById(id);
    }

    @GetMapping("/filter")
    public List<GiftCertificateDto> getByFilter(@RequestParam Map<String,String> param) {
        return service.findByParam(param);
    }
}
