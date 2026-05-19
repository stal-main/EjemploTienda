package logica;

import java.io.Serializable;

public class OrderLine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static int consecutive = 0;
	
	private int lineNumber;
	
	private Products product;
	
	private int amount;
	
	public OrderLine(Products product, int amount) {
		
		consecutive++;
		
		this.lineNumber = consecutive;
		this.product = product;
		
		this.amount = amount;
	}
	
	public int getLineNumber() {
		
		return lineNumber;
	}
	
	public Products getProduct() {
		
		return product;
	}
	
	public int getAmount() {
		
		return amount;
	}
	
	public void updateLine(Products product, int amount) {
		
		this.product = product;
		
		this.amount = amount;
	}

	public double getLineCost() {
		
		return product.getPrice() * amount;
	}

}
