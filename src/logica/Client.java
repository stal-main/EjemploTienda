package logica;

import java.util.Map;

public class Client {
	
	private String id;
	
	private String name;
	
	private String email;
	
	public Client(String id, String name, String email) {
		
		this.id = id;
		
		this.name = name;
		
		this.email = email;
	}
	
	public String getId() {
		
		return id;
	}
	
	public String getName() {
		
		return name;
	}

	public String getEmail() {
	
		return email;
	}	
	
	public void updateClient(String name, String email) {
		
	}
	
	public double RemainingTotal() {
		
		
	}
	
	public Map<Integer, String> getOrders() {
		
	}
	
	public Map<Integer, String> getOrdersByStatus(String status) {
		
	}
	
	public void addOrder() {
	
	}
	
	public void deleteOrder(int number) {
		
	}
}
