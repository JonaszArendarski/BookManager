package ksi.spring.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idp;
	private String name;
	private String address;
	
	
	@OneToMany(mappedBy = "publisher")
	private List<Books> books;
	
	
	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public Integer getIdp() {
		return idp;
	}


	public void setIdp(Integer idp) {
		this.idp = idp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Publisher(Integer idp, String name, String address, List<Books> books) {
		super();
		this.idp = idp;
		this.name = name;
		this.address = address;
		this.books = books;
	}


	public Publisher() {
		// TODO Auto-generated constructor stub
	}

}
