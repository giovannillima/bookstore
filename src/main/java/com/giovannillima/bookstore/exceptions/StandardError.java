package com.giovannillima.bookstore.exceptions;

public class StandardError {

	private Long timestamp;
	private Integer status;
	private String mensagem;

	public StandardError() {
		super();
	}

	public StandardError(Long timestamp, Integer status, String mensagem) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.mensagem = mensagem;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
