package com.devsuperior_cli.dscommerce_cli.services.exceptions;

public class ResourceNotFoundException  extends RuntimeException {
	
   public ResourceNotFoundException(String msg) {
	super(msg);
   }

}