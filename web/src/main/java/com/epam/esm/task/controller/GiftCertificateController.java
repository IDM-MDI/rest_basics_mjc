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


/**
 *
 */
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

    /**
     * @return
     * @throws ServiceException
     */
    @GetMapping
    public List<GiftCertificateDto> getAllGiftCertificate() throws ServiceException {
        return service.findAll();
    }

    /**
     * @param entity
     * @return
     * @throws ServiceException
     */
    @PostMapping
    public ResponseEntity<String> addGiftCertificate(@Valid @RequestBody GiftCertificateDto entity) throws ServiceException {
        service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGiftCertificate(@PathVariable @Min(1) long id) throws ServiceException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }

    /**
     * @param id
     * @param entity
     * @return
     * @throws ServiceException
     */
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateGiftCertificate(@PathVariable("id") @Min(1) long id,
                                              @Valid @RequestBody GiftCertificateDto entity) throws ServiceException {
        service.update(entity,id);
        return ResponseEntity.status(HttpStatus.CREATED).body("updated");
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     */
    @GetMapping("/{id}")
    public GiftCertificateDto getGiftCertificate(@PathVariable("id") @Min(1) long id) throws ServiceException {
        return service.findById(id);
    }

    /**
     * @param param
     * @return
     */
    @GetMapping("/filter")
    public List<GiftCertificateDto> getByFilter(@RequestParam Map<String,String> param) {
        return service.findByParam(param);
    }
}
