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
	
	public Map<Integer, String> getClientOrders(String id) {
		
		Client c = clients.get(id);
		
		if (c == null) {
			
			return null;
		}
		
		return c.getOrders();
	}
	
	public Map<Integer, String> getInitiateOrder(String id) {
		
		Client c = clients.get(id);
		
		if (c == null) {
			
			return null;
		}
		
		return c.getOrdersByStatus("Initiated");
		
	}
	
	public Map<Integer, String> getPendingOrders(String id) {
		
		Client c = clients.get(id);
		
		if (c == null) {
			
			return null;
		}
		
		return c.getOrdersByStatus("Pending");
	}
	
	public Map<Integer, String> getCompletedOrders(String id) {
		
		Client c = clients.get(id);
		
		if (c == null) {
			
			return null;
		}
		
		return c.getOrdersByStatus("Completed");
	}
	
	public void createClient(String id, String name, String email) {
		
		Client c = new Client(id, name, email);
		
		clients.put(id, c);
	}
	
	public void updateClient(String id, String name, String email) {
		
		Client c = clients.get(id);
		
		if (c != null) {
			
			c.updateClient(name, email);
		}
	}
	
	public void deleteClient(String id) {
		
		Client c = clients.get(id);
		
		if (c != null) {
			
			Map<Integer, String> clientOrders = c.getOrders();
			
			if (clientOrders != null) {
				
				for (int orderNumber : clientOrders.keySet()) {
					
					orders.remove(orderNumber);
				}
			}
			
			clients.remove(id);
		}
	}

	
}
