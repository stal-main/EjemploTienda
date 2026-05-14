package logica;

public class Products {
	
	private static int consecutive = 0;
	
	private int code;
	
	private String name;
	
	private int stock;
	
	private String unit;
	
	private double price;
	
	public Products(String name, int stock, String unit, double price) {
		
		consecutive++;
		
		this.code = consecutive;
		
		this.name = name;
		
		this.stock = stock;
		
		this.unit = unit;
		
		this.price = price;
		
	}
	
	public int getCode() {
		
		return code;
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getStock() {
		
		return stock;
	}
	
	public String getUnit() {
		
		return unit;
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public void updateProduct(String name, String stock, int unit, double price) {
		
		
	}
	
	public void updateProduct(String name, int stock, String unit, double price) {
		
		this.name = name;
		
		this.stock = stock;
		
		this.unit = unit;
		
		this.price = price;
	}

}
