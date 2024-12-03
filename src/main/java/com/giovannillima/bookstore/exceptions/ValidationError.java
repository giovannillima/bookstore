package com.giovannillima.bookstore.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String mensagem) {
		super(timestamp, status, mensagem);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
	

	public void addErros(String fielName, String message) {
		this.erros.add(new FieldMessage(fielName, message));
	}
	
	
	
	

}
