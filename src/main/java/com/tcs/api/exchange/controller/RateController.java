package com.tcs.api.exchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.api.exchange.Entity.RateEntity;
import com.tcs.api.exchange.controller.commons.ResponseREST;
import com.tcs.api.exchange.controller.generic.GenericController;
import com.tcs.api.exchange.dto.RateDTO;
import com.tcs.api.exchange.service.RateService;
import com.tcs.api.exchange.service.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rates")
public class RateController extends GenericController{
	
	@Autowired
	private RateService rateService;
	
	@GetMapping("/list")
	public ResponseEntity<ResponseREST> findAll() throws Exception{
		
		try {
			List<RateEntity> lst= rateService.listAll();
			if(lst.isEmpty()) {
				return super.getNotFoundRequest();
			}
			
			return super.getOKConsultaRequest(lst);
		} catch (ServiceException e) {
			log.error(e.getMessage());
			return super.getErrorRequest();
		}
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ResponseREST> currencyExchange(@RequestBody @Validated RateDTO rateDTO 
			,BindingResult result){
		
		if (result.hasErrors()) {
			return super.getBadRequest(result);
		}
		
		try {
			if(rateService.updateRate(rateDTO)==1) {
				return super.getOKRegistroRequest(1);
			}
			return super.getBadRequest("Error al actualizar el tipo de cambio");
		} catch (ServiceException e) {
			log.error(e.getMessage());
			return super.getErrorRequest();
		}
	} 

}
