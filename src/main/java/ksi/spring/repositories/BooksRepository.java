package ksi.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ksi.spring.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books , Integer> {
	 List<Books> findByOrderByIdbDesc();
	 List<Books> findByOrderByTitleAsc();
	 List<Books> findByOrderByPublisherNameDesc();
	 List<Books> findByOrderByPublisherNameAscTitleAsc();
	 
	 List<Books> findAllByTitleNativeSQL();
 	
}
