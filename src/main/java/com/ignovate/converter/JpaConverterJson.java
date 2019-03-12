package com.ignovate.converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<Object, String> {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Object meta) {
		try {
			return meta != null ? objectMapper.writeValueAsString(meta) : null;
		} catch (JsonProcessingException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Object convertToEntityAttribute(String dbData) {
		try {
			return dbData != null ? objectMapper.readValue(dbData, Object.class) : null;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}