package com.entreprise.exception;

public class EquipeCompleteException extends RuntimeException {
	 public EquipeCompleteException() {
	        super("équipe complète (capacité : 4)");
	    }

}
