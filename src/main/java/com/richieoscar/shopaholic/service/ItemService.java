package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.exceptions.CategoryNotFoundException;
import com.richieoscar.shopaholic.exceptions.ItemNotFoundException;
import com.richieoscar.shopaholic.repositories.CategoryRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public Item getItemByName(String name) {
        Optional<Item> optionalItem = itemRepository.findByName(name);
        return optionalItem.orElseThrow(() -> new ItemNotFoundException());
    }

    public Item getItemById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.orElseThrow(() -> new ItemNotFoundException());
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public List<Item> findItemsByCategory(Long id) {
        Optional<Category> categoryName = categoryRepository.findById(id);
        if (categoryName.isPresent()) {
            return categoryName.get().getItems();
        } else throw new CategoryNotFoundException();

    }

    public List<Item> findItemsByName(String name) {
        return itemRepository.findAllByName(name);
    }

    public List<Item> findItemsByManufacturer(String name) {
        List<Item> allByManufacturer_name = itemRepository.findAllByManufacturerManufacturerName(name);
        return  allByManufacturer_name;


    }
}
