package com.faleite.criptografia.service;

import com.faleite.criptografia.model.SensitiveData;
import com.faleite.criptografia.repository.SensitiveDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensitiveDataService {

    private final SensitiveDataRepository sensitiveDataRepository;

    public SensitiveDataService(SensitiveDataRepository sensitiveDataRepository) {
        this.sensitiveDataRepository = sensitiveDataRepository;
    }

    public List<SensitiveData> findAll(){
        return sensitiveDataRepository.findAll();
    }

    public SensitiveData save(SensitiveData data) {
        return sensitiveDataRepository.save(data);
    }

    public void deleteById(Long id){
        if (!sensitiveDataRepository.existsById(id)){
            return;
        }
        sensitiveDataRepository.deleteById(id);
    }
}
