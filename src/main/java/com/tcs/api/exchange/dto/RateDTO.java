package com.tcs.api.exchange.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateDTO {
	
	@Range(min = 1, max = 3,message = "Ingrese una moneda origen válida.")
	private int origenCurrency;
	
	@Range(min = 1, max = 3,message = "Ingrese una moneda origen válida.")
	private int destinationCurrency;
	
	@Positive(message = "Ingrese un tipo de cambio válido")
	private double exchangeRate;

}
