package control;

import logica.Client;
import logica.Order;
import logica.Products;

import java.util.Map;
import java.util.HashMap;


public class Control {
	
	private Map<String, Client> clients;
	private Map<Integer, Products> products;
	private Map<Integer, Order> orders;
	
	public Control() {
		
		clients = new HashMap<>();
		
		products = new HashMap<>();
		
		orders = new HashMap<>();
		
	}
	
	public Map<String, String> getClients() {
		
		Map<String, String> result = new HashMap<>();
		
		for (Client c : clients.values()) {
			
			result.put(c.getId(), c.getName());
		}
		
		return result;
	}
	
	public String getClient(String id) {
		
		Client c = clients.get(id);
		
		if (c == null) {
			
			return null;
		}
		
		return "ID: " + c.getId() + " Name: " + c.getName() + " Email: " + c.getEmail();
	}

	
}
