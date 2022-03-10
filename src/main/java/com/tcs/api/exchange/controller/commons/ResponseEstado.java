package com.tcs.api.exchange.controller.commons;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tcs.api.exchange.controller.enums.ResponseEnums;

import lombok.Builder;
import lombok.Data;



@JsonPropertyOrder({"codigo", "mensaje","detalle","estado", "error", "fechaHora" })
@Data
@Builder
public class ResponseEstado {
	
	@Builder.Default
	private Date 			fechaHora= new Date(); //"2021-02-14T18:10:49.440+00:00"
	private Integer 		estado; //"status": 500
	private String 			error; // "error": "Internal Server Error"
	private ResponseEnums	codigo;
	private Object 			mensaje; // "message": "No message available"
	@JsonInclude(Include.NON_NULL)
	private Object 			detalle;
	//private String ruta; //"path": "/talleres/v1/100"
	
}
