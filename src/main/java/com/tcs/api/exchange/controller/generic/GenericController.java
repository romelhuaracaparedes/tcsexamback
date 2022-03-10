package com.tcs.api.exchange.controller.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.tcs.api.exchange.controller.commons.ResponseEstado;
import com.tcs.api.exchange.controller.commons.ResponseREST;
import com.tcs.api.exchange.controller.constants.ResponseContants;
import com.tcs.api.exchange.controller.enums.ResponseEnums;



public abstract class GenericController {
	
	@Value("${api.version}")
	private String apiVersion;
	
	@Value("${api.author}")
	private String author;

	protected String formatMapMessage(BindingResult result) {
		List<Map<String, String>> errors = 
				result.getFieldErrors().stream().map(err -> 
					{
						Map<String, String> error = new HashMap<>();
						error.put(err.getField(), err.getDefaultMessage());
						return error;
		}
		
	).collect(Collectors.toList());
		return errors.toString();
	}
	
	protected List<Map<String, String>> formatMapMessageList(BindingResult result) {
		List<Map<String, String>> errors = 
				result.getFieldErrors().stream().map(err -> 
					{
						Map<String, String> error = new HashMap<>();
						error.put(err.getField(), err.getDefaultMessage());
						return error;
		}
		
	).collect(Collectors.toList());
		return errors;
	}
	protected List<String> formatMapMessageText(BindingResult result) {
		List<String> errorMessages = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
		    String msg = error.getDefaultMessage();
		    errorMessages.add(msg);
		   }
		return errorMessages;
	}
	
	protected ResponseEntity<ResponseREST> getBadRequest(BindingResult result){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.ALERTA)
						.mensaje(ResponseContants.MSG_REG_ALERTA)
						.estado(HttpStatus.BAD_REQUEST.value())
						.error(HttpStatus.BAD_REQUEST.name())
						.detalle(this.formatMapMessageText(result))
						.build())
				.build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getBadRequest(String detalle){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.ALERTA)
						.mensaje(ResponseContants.MSG_AlER_GENE)
						.estado(HttpStatus.BAD_REQUEST.value())
						.error(HttpStatus.BAD_REQUEST.name())
						.detalle(detalle)
						.build())
				.build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getBadIdRequest(){
		return this.getBadRequest(ResponseContants.ID_ALERTA);
	}
	
	protected ResponseEntity<ResponseREST> getNotFoundRequest(){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.ALERTA)
						.mensaje(ResponseContants.MSG_CONS_SIN_CONT)
						.estado(HttpStatus.NOT_FOUND.value())
						.error(HttpStatus.NOT_FOUND.name())
						.build())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getCreatedRequest(Object obj){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.EXITO)
						.mensaje(ResponseContants.MSG_REG_EXITO)
						.estado(HttpStatus.OK.value())
						.error(HttpStatus.OK.name())
						.build())
				.resultado(obj)
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getOKRegistroRequest(Object obj){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.EXITO)
						.mensaje(ResponseContants.MSG_REG_EXITO)
						.estado(HttpStatus.OK.value())
						.error(HttpStatus.OK.name())
						.build())
					.resultado(obj)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getOKConsultaRequest(Object obj){
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.EXITO)
						.mensaje(ResponseContants.MSG_CONS_EXITO)
						.estado(HttpStatus.OK.value())
						.error(HttpStatus.OK.name())
						.build())
				.resultado(obj)
				.build();
		return ResponseEntity.ok(res);
	}

	public ResponseEntity<ResponseREST> getErrorRequest() {
		ResponseREST res= 	ResponseREST.builder()
				.author(author)
				.apiVersion(apiVersion)
				.estado(
						ResponseEstado.builder()
						.codigo(ResponseEnums.ERROR)
						.mensaje(ResponseContants.MSG_ERR_GENE)
						.estado(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.error(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.build())
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
}