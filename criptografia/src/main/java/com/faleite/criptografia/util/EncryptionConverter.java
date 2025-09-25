package com.faleite.criptografia.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EncryptionConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        return EncryptionUtil.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return EncryptionUtil.decrypt(s);
    }
}
