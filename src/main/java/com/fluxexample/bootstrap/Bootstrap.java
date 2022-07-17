package com.fluxexample.bootstrap;

import com.fluxexample.domain.Category;
import com.fluxexample.domain.Vendor;
import com.fluxexample.repositories.CategoryRepository;
import com.fluxexample.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final VendorRepository vendorRepository;
    private final CategoryRepository categoryRepository;

    public Bootstrap(VendorRepository vendorRepository, CategoryRepository categoryRepository) {
        this.vendorRepository = vendorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {
            System.out.println("Loading data to bootstrap");

            categoryRepository.save(Category.builder()
                    .description("First Category").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Second Category").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Third Category").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Fourth Category").build()).block();

            System.out.println("Loaded categories: " + categoryRepository.count().block());
        }


        if (vendorRepository.count().block() == 0) {
            vendorRepository.save(Vendor.builder()
                    .firstName("Vahobjon")
                    .lastName("Tolibov").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jakie")
                    .lastName("Chan").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jan Cloud")
                    .lastName("Vann Dam").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
        }
    }
}
