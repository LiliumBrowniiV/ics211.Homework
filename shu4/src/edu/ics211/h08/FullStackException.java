package edu.ics211.h08;

@SuppressWarnings("serial")
public class FullStackException extends RuntimeException{
	@SuppressWarnings("unused")
	private static final long serialVersionID = 1L;
	public FullStackException() {
	}
	public FullStackException(String mess) {
		super(mess);
	}
}
