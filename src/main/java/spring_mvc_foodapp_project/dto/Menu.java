package spring_mvc_foodapp_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.omg.PortableInterceptor.USER_EXCEPTION;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "menu")
	private List<FoodProducts> foodProducts;
	
	@OneToOne
	@JoinColumn
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FoodProducts> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProducts> foodProducts) {
		this.foodProducts = foodProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
