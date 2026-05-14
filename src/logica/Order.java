package logica;

import java.time.LocalDateTime;

public class Order {
	
	private int number;
	
	private LocalDateTime date;
	
	private String status;
	
	public Order() {
		
		this.number = number;
		
		date = LocalDateTime.now();
		
		this.status = status;
		
	}
	
	public int getNumber() {
		
		return number;
	}
	
	public LocalDateTime getDate() {
		
		return date;
	}
	
	public String getStatus() {
		
		return status;
	}
	
	public void changeStatus(String newStatus) {
		
		
	}

}
