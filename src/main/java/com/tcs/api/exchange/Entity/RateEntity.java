package com.tcs.api.exchange.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "rate")
@AllArgsConstructor
@NoArgsConstructor
public class RateEntity {
	
	@Id
    private int id;
    private String code;


}
