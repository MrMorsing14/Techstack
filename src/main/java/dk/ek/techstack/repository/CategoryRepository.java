package dk.ek.techstack.repository;

import dk.ek.techstack.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
