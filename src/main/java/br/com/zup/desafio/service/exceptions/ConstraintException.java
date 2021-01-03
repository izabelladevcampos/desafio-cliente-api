package br.com.zup.desafio.service.exceptions;

public class ConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConstraintException(String msg) {
		super(msg);
	}

}
