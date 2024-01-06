package az.developia.nov30.productregister.model;

import java.time.LocalDate;

public class Product {
	private Integer id;
	private String name;
	private String category;
	private Integer quantity;
	private Integer price;
	private LocalDate arrivalDate;
	private String status;
	private String imagePath;
	
	

	
	public Product() {

	}

	public Product(String name, String category, Integer quantity, Integer price, LocalDate arrivalDate,
			String status, String imagePath) {
		
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.arrivalDate = arrivalDate;
		this.status = status;
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity + ", price="
				+ price + ", arrivalDate=" + arrivalDate + ", status=" + status + ", imagePath=" + imagePath + "]";
	}
	
	

}
