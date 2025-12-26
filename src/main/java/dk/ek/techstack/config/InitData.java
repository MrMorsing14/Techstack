package dk.ek.techstack.config;

import dk.ek.techstack.model.Category;
import dk.ek.techstack.model.Product;
import dk.ek.techstack.repository.CategoryRepository;
import dk.ek.techstack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0) {
            return;
        }

        Category electronics = new Category(null, "Electronics");
        Category books = new Category(null, "Books");

        categoryRepository.saveAll(List.of(electronics, books));

        Product laptop = new Product(null, "IPhone 17 Pro Max", 8200.00);
        Product book = new Product(null, "Linux pocket guide", 239.99);

        productRepository.saveAll(List.of(laptop, book));
    }

}
