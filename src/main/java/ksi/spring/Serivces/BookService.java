package ksi.spring.Serivces;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.spring.model.Books;
import ksi.spring.repositories.BooksRepository;

@Service
public class BookService {

	
	@Autowired
	private BooksRepository repository;
	
	public BookService() {
		super();
	}

	public <S extends Books> S save(S entity) {
		return repository.save(entity);
	}

	public List<Books> findAll() {
		return repository.findByOrderByIdbDesc();
	}

	public Optional<Books> findById(Integer id) {
		return repository.findById(id);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public List<Books> findByOrderByTitleAsc() {
		return repository.findByOrderByTitleAsc();
	}
	public List<Books> findAllByTitleNativeSQL() {
		return repository.findAllByTitleNativeSQL();
	}

}
