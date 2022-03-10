package com.tcs.api.exchange.service;

import com.tcs.api.exchange.dto.ExchangeDTO;

public interface ExchangeService {
	
	ExchangeDTO exchangeCurrency(ExchangeDTO exchange) throws ServiceException;

}
