package ksi.spring.model;

import org.hibernate.annotations.NamedNativeQuery;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

@NamedNativeQuery(name = "Books.findAllByTitleNativeSQL",
query = "SELECT * FROM books.books ORDER BY title ",
resultClass = Books.class)


public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idb;
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "publisher_idp")
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn(name = "category_idc")
	private Category category;
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getIdb() {
		return idb;
	}
	
	
	
	
	public void setIdb(int idb) {
		this.idb = idb;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Books(int idb, String title, Publisher publisher, Category category) {
		super();
		this.idb = idb;
		this.title = title;
		this.publisher = publisher;
		this.category = category;
	}
	public Books() {
		// TODO Auto-generated constructor stub
	}

}
