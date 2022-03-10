package com.tcs.api.exchange.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcs.api.exchange.Entity.DetailsEntity;

@Repository
public interface DetailsRepository extends JpaRepository<DetailsEntity, Integer>{
	
	@Query("Select d from DetailsEntity d where d.cod_origin= :cod_origin and d.cod_destination= :cod_destination")
	DetailsEntity findByDetailsEntity(@Param("cod_origin") int cod_origin,
			@Param("cod_destination") int cod_destination);
	
	@Modifying
	@Query("update DetailsEntity d set d.exch_rate = :exch_rate where d.cod_origin= :cod_origin and d.cod_destination= :cod_destination")
	int updateRate(@Param("exch_rate") double exch_rate
			,@Param("cod_origin") int cod_origin
			,@Param("cod_destination") int cod_destination);
}
