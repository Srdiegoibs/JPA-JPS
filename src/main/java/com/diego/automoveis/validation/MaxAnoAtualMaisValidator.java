/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.automoveis.validation;

import java.text.MessageFormat;
import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author diego
 * Created on : Aug 24, 2020, 6:17:38 PM
 */
public class MaxAnoAtualMaisValidator implements ConstraintValidator<MaxAnoAtualMais, Integer> {
	public int maxValue;
	
	@Override
	public void initialize(MaxAnoAtualMais annotation) {
		int anosAdicionais = annotation.value();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		maxValue = anoAtual + anosAdicionais;
	}
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		if (value > maxValue) {
			String template = context.getDefaultConstraintMessageTemplate();
			
			String message = MessageFormat.format(template, maxValue);
			
			context.buildConstraintViolationWithTemplate(message)
					.addConstraintViolation()
					.disableDefaultConstraintViolation();
			
			return false;
		}
		return true;
	}
}
