package com.faleite.criptografia.repository;

import com.faleite.criptografia.model.SensitiveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensitiveDataRepository extends JpaRepository<SensitiveData, Long> {
}
