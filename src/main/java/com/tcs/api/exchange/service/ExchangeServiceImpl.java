package com.tcs.api.exchange.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.api.exchange.Entity.DetailsEntity;
import com.tcs.api.exchange.dto.ExchangeDTO;
import com.tcs.api.exchange.repository.DetailsRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService{
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	
	@Override
	public ExchangeDTO exchangeCurrency(ExchangeDTO exchange) throws ServiceException {
		try {
			
			DetailsEntity detail = detailsRepository.findByDetailsEntity(exchange.getOrigenCurrency()
					, exchange.getDestinationCurrency());
			
			exchange.setChangeAmount(exchange.getAmount()*detail.getExch_rate());
			exchange.setExchangeRate(detail.getExch_rate());
			
			log.info("Aqui el detalle que se busca"+detail.toString());
			return exchange;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e);
			
		}
	}

	
	

}
