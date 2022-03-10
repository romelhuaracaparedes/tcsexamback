package com.tcs.api.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.api.exchange.Entity.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Integer>{

}
