package com.tcs.api.exchange.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "details")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailsEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int cod_origin;
	
	@Column
	private int cod_destination;
	
	@Column
	private double exch_rate;

}
