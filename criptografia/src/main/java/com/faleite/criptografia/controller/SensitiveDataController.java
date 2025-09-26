package com.faleite.criptografia.controller;

import com.faleite.criptografia.model.SensitiveData;
import com.faleite.criptografia.service.SensitiveDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensitive-data")
public class SensitiveDataController {

    private final SensitiveDataService sensitiveDataService;

    public SensitiveDataController(SensitiveDataService sensitiveDataService) {
        this.sensitiveDataService = sensitiveDataService;
    }

    /*@GetMapping
    public List<SensitiveData> findAll(){
        return sensitiveDataService.findAll();
    }*/
    @GetMapping
    public ResponseEntity<List<SensitiveData>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(sensitiveDataService.findAll());
    }

    /*@PostMapping
    public SensitiveData create(@RequestBody SensitiveData data){
        return sensitiveDataService.save(data);
    }*/
    @PostMapping
    public ResponseEntity<SensitiveData> create(@RequestBody SensitiveData data){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sensitiveDataService.save(data));
    }

    /*@DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id){
        sensitiveDataService.deleteById(id);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id){
        sensitiveDataService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
