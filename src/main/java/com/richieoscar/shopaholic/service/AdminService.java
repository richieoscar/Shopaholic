package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.exceptions.ItemAlreadyExistException;
import com.richieoscar.shopaholic.exceptions.ItemNotFoundException;
import com.richieoscar.shopaholic.repositories.CategoryRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService {

    private ItemRepository repository;
    private CategoryRepository categoryRepository;

    public Item addItem(Item item) {
        Optional<Item> itemOptional = repository.findByName(item.getName());
        if (itemOptional.isPresent()) {
            throw new ItemAlreadyExistException();
        }
        else return repository.save(item);
    }

    public String removeItemById(Long itemId) {
        Optional<Item> optionalItem = repository.findById(itemId);
        if (optionalItem.isPresent()) {
            repository.delete(optionalItem.get());
            return "Item Deleted";
        } else throw new ItemNotFoundException();
    }

    public Item findItemByName(String name) {
        Optional<Item> optionalItem = repository.findByName(name);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else throw new ItemNotFoundException();
    }

}
