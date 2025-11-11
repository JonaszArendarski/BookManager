package ksi.spring.Serivces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.spring.model.Publisher;
import ksi.spring.repositories.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository repository;
	public <S extends Publisher> S save(S entity) {
		return repository.save(entity);
	}
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	public Optional<Publisher> findById(Integer id) {
		return repository.findById(id);
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	public PublisherService() {
		super();
	}
	
	

}
