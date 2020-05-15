package com.nusacamp.app.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstName;
	private String lastName;
	
	@Override
	public void initialize(final FieldMatch ConstraintAnnotation) {
		firstName = ConstraintAnnotation.first();
		lastName = ConstraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value,final ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils.getProperty(value, firstName);
			final Object secondObj = BeanUtils.getProperty(value, lastName);
			
			return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj); 
		}catch (final Exception ignore) {
			return true;
		}
	}

	

}
