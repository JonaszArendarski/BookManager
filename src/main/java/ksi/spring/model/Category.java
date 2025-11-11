package ksi.spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idc;
	private String description;
	
	
	@OneToMany
	@JoinColumn(name = "category_idc")
	List<Books> books;
	
	
	public Integer getIdc() {
		return idc;
	}


	public void setIdc(Integer idc) {
		this.idc = idc;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}


	public Category(Integer idc, String description, List<Books> books) {
		super();
		this.idc = idc;
		this.description = description;
		this.books = books;
	}


	public Category() {
		// TODO Auto-generated constructor stub
	}

}
