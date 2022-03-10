package com.tcs.api.exchange.dto;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDTO {
	
	@Positive(message = "El monto debe de ser un número positivo")
	private double amount;
	
	@Positive(message = "Ingrese una moneda origen válida")
	private int origenCurrency;
	
	@Positive(message = "Ingrese una moneda destino válida")
	private int destinationCurrency;
	
	private double changeAmount;
	
	private double exchangeRate;
}