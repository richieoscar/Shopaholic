package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.dto.ItemRequest;
import com.richieoscar.shopaholic.dto.response.ItemResponse;
import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.entities.Manufacturer;
import com.richieoscar.shopaholic.exceptions.EmailAlreadyExistException;
import com.richieoscar.shopaholic.exceptions.ItemAlreadyExistException;
import com.richieoscar.shopaholic.exceptions.ItemNotFoundException;
import com.richieoscar.shopaholic.repositories.CategoryRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import com.richieoscar.shopaholic.repositories.ManufactureRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService {

    private ItemRepository repository;
    private CategoryRepository categoryRepository;
    private ManufactureRepository manufactureRepository;

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
