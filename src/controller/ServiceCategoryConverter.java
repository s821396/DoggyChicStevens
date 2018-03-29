package controller;

import javax.persistence.AttributeConverter;

public class ServiceCategoryConverter implements AttributeConverter<String, Integer>{
	
	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String convertToEntityAttribute(Integer dbData) {
		// TODO Auto-generated method stub
		return null;
	}
}
