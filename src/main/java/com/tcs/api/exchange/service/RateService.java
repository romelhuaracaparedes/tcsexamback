package com.tcs.api.exchange.service;

import java.util.List;

import com.tcs.api.exchange.Entity.RateEntity;
import com.tcs.api.exchange.dto.RateDTO;

public interface RateService {
	
	List<RateEntity> listAll() throws ServiceException;
	int updateRate(RateDTO rateDTO) throws ServiceException;

}
