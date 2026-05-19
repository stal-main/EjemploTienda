package logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static int consecutive = 0;
	
	private int number;
	
	private LocalDateTime date;
	
	private String status;
	
	private Client client;
	
	private Map<Integer, OrderLine> lines;
	
	public Order(Client client) {
		
		consecutive++;
		
		this.number = consecutive;
		
		this.date = LocalDateTime.now();
		
		this.status = "Initiated";
		
		this.client = client;
		
		this.lines = new HashMap<>();
		
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
	
	public Client getClient() {
		
		return client;
	}
	
	public void changeStatus(String newStatus) {
		
		this.status = newStatus;
	}
	
	public double getAmount() {
		
		double total = 0;
		
		for (OrderLine line : lines.values()) {
			
			total += line.getLineCost();
		}
		
		return total;
	}
	
	public double getTaxAmount() {
		
		return getAmount() * 0.13;
	}
	
	public double getTotalAmount() {
		
		return getAmount() + getTaxAmount();
	}
	
	public Map<Integer, String> getLines() {
		
        Map<Integer, String> result = new HashMap<>();
        
        for (OrderLine line : lines.values()) {
        	
            result.put(line.getLineNumber(), line.getProduct().getName() + " x" + line.getAmount());      
        }
        
        return result;
    }
	
	public void addLine(OrderLine line) {
		
		lines.put(line.getLineNumber(), line);
	}
	
	public void updateLine(int lineNumber, Products product, int amount) {
		
		OrderLine line = lines.get(lineNumber);
		
		if (line != null) {
			
			line.updateLine(product, amount);
		}
	}
	
	public void deleteLine(int lineNumber) {
		
		lines.remove(lineNumber);
	}

}
