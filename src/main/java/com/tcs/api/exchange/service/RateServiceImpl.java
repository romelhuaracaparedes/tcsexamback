package com.tcs.api.exchange.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.api.exchange.Entity.RateEntity;
import com.tcs.api.exchange.dto.RateDTO;
import com.tcs.api.exchange.repository.DetailsRepository;
import com.tcs.api.exchange.repository.RateRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RateServiceImpl implements RateService{

	
	@Autowired
	private RateRepository rateRepository;
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	@Override
	public List<RateEntity> listAll() throws ServiceException {
		try {
			return rateRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e);
			
		}
	}

	@Transactional
	@Override
	public int updateRate(RateDTO rateDTO) throws ServiceException {
		try {
			return detailsRepository.updateRate(rateDTO.getExchangeRate()
					,rateDTO.getOrigenCurrency()
					,rateDTO.getDestinationCurrency());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e);
			
		}
	}

}
