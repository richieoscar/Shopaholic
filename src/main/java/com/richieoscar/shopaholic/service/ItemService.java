package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.exceptions.ItemNotFoundException;
import com.richieoscar.shopaholic.repositories.CategoryRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository repository;
    private CategoryRepository categoryRepository;

    public Item getItemByName(String name) {
        Optional<Item> optionalItem = repository.findByName(name);
        return optionalItem.orElseThrow(() -> new ItemNotFoundException());
    }

    public Item getItemById(Long id) {
        Optional<Item> optionalItem = repository.findById(id);
        return optionalItem.orElseThrow(() -> new ItemNotFoundException());
    }

    public List<Item> getItems() {
        return repository.findAll();
    }

    public List<Item> findItemsByCategory(Long category) {
        Optional<Category> categoryName = categoryRepository.findById(category);
        if (categoryName.isPresent()) {
            return categoryName.get().getItems();
        } else return Collections.emptyList();

    }

    public List<Item> findItemsByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Item> findItemsByManufacturer(String name) {
        return repository.findAllByManufacturer_Name(name);
    }
}
