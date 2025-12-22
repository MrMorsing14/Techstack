package dk.ek.techstack.controller;


import dk.ek.techstack.model.Category;
import dk.ek.techstack.model.Product;
import dk.ek.techstack.repository.CategoryRepository;
import dk.ek.techstack.service.CategoryService;
import dk.ek.techstack.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Category> delete(Category category) {
        return categoryService.delete(category);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }
}
