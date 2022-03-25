package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.requests.CategoryRequest;
import com.richieoscar.shopaholic.dto.requests.CreateCategoryRequest;
import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.exceptions.CategoryAlreadyExistException;
import com.richieoscar.shopaholic.exceptions.CategoryNotFoundException;
import com.richieoscar.shopaholic.exceptions.ItemNotFoundException;
import com.richieoscar.shopaholic.repositories.CategoryRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/addToCategory")
    public Category addToCategory(@RequestBody CategoryRequest request) {
        Optional<Item> itemOptional = itemRepository.findById(request.getItemId());
        if (!itemOptional.isPresent()) {
            throw new ItemNotFoundException();
        }
        Optional<Category> categoryOptional = categoryRepository.findByName(request.getCategoryName());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.addItem(itemOptional.get());
            return categoryRepository.save(category);
        } else throw new CategoryNotFoundException();
    }

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getCategoryName());
        Optional<Category> optionalCategory = categoryRepository.findByName(request.getCategoryName());
        if (optionalCategory.isPresent()) {
            throw new CategoryAlreadyExistException();
        } else {
            return categoryRepository.save(category);
        }
    }
}
