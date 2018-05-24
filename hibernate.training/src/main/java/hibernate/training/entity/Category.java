package hibernate.training.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private Integer id;
	private String name;
	
	private Set<Product> products = new HashSet<Product>();
	
	// helper to ease the bidirectional association
	public void addProduct(Product product){
		this.products.add(product);
		product.setCategory(this);
	}

	public Category() {
	}

	public Category(String name) {
		this.name = name;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
