package logica;

public class Products {
	
	private int code;
	
	private String name;
	
	private float stock;
	
	private String unit;
	
	private double price;
	
	public Products(String name, int stock, String unit, double price) {
		
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
	
	public void updateProduct(String name) {
		
		
	}

}
