package com.tcs.api.exchange.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.api.exchange.controller.commons.ResponseREST;
import com.tcs.api.exchange.controller.generic.GenericController;
import com.tcs.api.exchange.dto.ExchangeDTO;
import com.tcs.api.exchange.service.ExchangeService;
import com.tcs.api.exchange.service.ServiceException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/exchanges")
public class ExchangeController extends GenericController{
	
	
	@Autowired
	private ExchangeService exchangeService;
	
	
	@PostMapping("/currency-converter")
	public ResponseEntity<ResponseREST> currencyExchange(@RequestBody @Validated ExchangeDTO exchangeDTO 
			,BindingResult result){
		
		if (result.hasErrors()) {
			return super.getBadRequest(result);
		}
		
		try {
			ExchangeDTO exchange = exchangeService.exchangeCurrency(exchangeDTO);
			if(Objects.nonNull(exchange)) {
				return super.getOKRegistroRequest(exchange);
			}
			return super.getBadRequest("Error al realizar conversión");
		} catch (ServiceException e) {
			log.error(e.getMessage());
			return super.getErrorRequest();
		}
	}  

	

}
