package ru.sultanyarov.authserver.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;
import ru.sultanyarov.authserver.enums.SexEnum;

@Converter(autoApply = true)
public class SexEnumConverter implements AttributeConverter<SexEnum, String> {
    @Override
    public String convertToDatabaseColumn(SexEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public SexEnum convertToEntityAttribute(String dbData) {
        if (StringUtils.isEmpty(dbData)) {
            return null;
        }

        return SexEnum.of(dbData);
    }
}
