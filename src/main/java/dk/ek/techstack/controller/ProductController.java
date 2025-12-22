package dk.ek.techstack.controller;

import dk.ek.techstack.model.Product;
import dk.ek.techstack.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Product> delete(Product product) {
        return productService.delete(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


}
