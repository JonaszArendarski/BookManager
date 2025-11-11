package ksi.spring.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ksi.spring.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category , Integer> {
	
}
