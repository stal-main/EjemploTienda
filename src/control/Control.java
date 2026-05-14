package control;

import logica.Client;
import logica.Order;
import logica.OrderLine;
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
	
	public Map<Integer, String> getProducts() {
		
		Map<Integer, String> result = new HashMap<>();
		
		for (Products p : products.values()) {
			
			result.put(p.getCode(), p.getName());
		}
		
		return result;
		
	}
	
	public String getProduct(int code) {
		
		Products p = products.get(code);
		
		if (p == null) {
			
			return null;
		}
		
		return "Code: " + p.getCode() + " Name: " + p.getName() + " Stock: " + p.getStock() + " Unit: " + p.getUnit() + " Price: " + p.getPrice();
	}
	
	public void createProduct(String name, int stock, String unit, double price) {
		
        Products p = new Products(name, stock, unit, price);
        
        products.put(p.getCode(), p);
    }
	
	public void updateProduct(int code, String name, int stock, String unit, double price) {
		
		Products p = products.get(code);
		
		if (p != null) {
			
			p.updateProduct(name, stock, unit, price);
		}
	}
	
	public void deleteProduct(int code) {
		
        products.remove(code);
    }
	
	public Map<Integer, String> getOrders() {
		
        Map<Integer, String> result = new HashMap<>();
        
        for (Order o : orders.values()) {
        	
            result.put(o.getNumber(), o.getStatus());
        }
        
        return result;
    }
	
	public double getTotalPendingAmount() {
		
	    double total = 0;
	    
	    for (Order o : orders.values()) {
	    	
	        if ("Pending".equalsIgnoreCase(o.getStatus())) {
	        	
	            total += o.getTotalAmount();
	        }
	    }
	    
	    return total;
	}
	
	public int createOrder(String clientId) {
		
		Client c = clients.get(clientId);
		
		if (c == null) {
			
			return -1;
		}
		
		Order o = new Order(c);
		
		orders.put(o.getNumber(), o);
		
		c.addOrder(o);
		
		return o.getNumber();
	}
	
	public String getOrder(int number) {
		
		Order o = orders.get(number);
		
		if (o == null) {
			
			return null;
		}
		
		return "Order #" + o.getNumber() + " Date: " + o.getDate() + " Status: " + o.getStatus() + " Total: " + o.getTotalAmount();
 	}
	
	public String deleteOrder(int number) {
		
        Order o = orders.remove(number);
        
        if (o == null) return "Order not found.";
        
        o.getClient().deleteOrder(number);
        
        return "Order #" + number + " deleted.";
    }
	
	public Map<Integer, String> getOrderLines(int number) {
		
        Order o = orders.get(number);
        
        if (o == null) return null;
        
        return o.getLines();
    }
	
	public void setOrderPending(int number) {
		
        Order o = orders.get(number);
        
        if (o != null) {
        	
            o.changeStatus("Pending");
        }
    }
	
	public void setOrderCompleted(int number) {
		
        Order o = orders.get(number);
        
        if (o != null) {
        	
            o.changeStatus("Completed");
        }
    }
	
	public void addOrderLine(int orderNumber, int productCode, int amount) {
		
        Order o = orders.get(orderNumber);
        
        Products p = products.get(productCode);
        
        if (o == null || p == null) {
        	
        	return;
        }
        
        OrderLine line = new OrderLine(p, amount);
        
        o.addLine(line);
    }
	
	public void updateOrderLine(int orderNumber, int lineNumber, int productCode, int quantity) {
		
        Order o = orders.get(orderNumber);
        
        Products p = products.get(productCode);
        
        if (o == null || p == null) {
        	
        	return;
        }
        
        o.updateLine(lineNumber, p, quantity);
        
    }
	
	public void deleteOrderLine(int orderNumber, int lineNumber) {
		
        Order o = orders.get(orderNumber);
        
        if (o != null) {
        	
            o.deleteLine(lineNumber);
        }
    }
	
}
