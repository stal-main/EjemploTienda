package logica;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String email;
	
	private Map<Integer, Order> orders;
	
	public Client(String id, String name, String email) {
		
		this.id = id;
		
		this.name = name;
		
		this.email = email;
		
		this.orders = new HashMap<>();
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
		
		this.name = name;
		
		this.email = email;
	}
	
	public double getTotalPending() {
		
		double total = 0;
		
		for (Order o : orders.values()) {
			
			if ("Pending".equalsIgnoreCase(o.getStatus())) {
				
				total += o.getTotalAmount();
			}
		}
		
		return total;
	}
	
	public Map<Integer, String> getOrders() {
		
		Map<Integer, String> result = new HashMap<>();
		
		for (Order o : orders.values()) {
			
			result.put(o.getNumber(), o.getStatus());
		}
		
		return result;
	}
	
	public Map<Integer, String> getOrdersByStatus(String status) {
		Map<Integer, String> result = new HashMap<>();
		
		for (Order o : orders.values()) {
			
			if (o.getStatus().equalsIgnoreCase(status)) {
				
				result.put(o.getNumber(), o.getStatus());
			}
		}
		
		return result;
	}
	
	public void addOrder(Order order) {
		
		orders.put(order.getNumber(), order);
	}
	
	public void deleteOrder(int number) {
		
		orders.remove(number);
	}
}
