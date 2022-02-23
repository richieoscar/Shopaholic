package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.ItemRequest;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.service.ItemService;
import com.richieoscar.shopaholic.utils.AppHelper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@AllArgsConstructor
public class ItemController {

    private ItemService service;

    @GetMapping("/itemById/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) {
        return new ResponseEntity<Item>(service.getItemById(id), AppHelper.addHeader(), HttpStatus.OK);
    }

    @GetMapping("/itemByName/{name}")
    public ResponseEntity<Item> getItemByName(@PathVariable("name") String name) {
        return new ResponseEntity<Item>(service.getItemByName(name), AppHelper.addHeader(), HttpStatus.OK);
    }

    @GetMapping("/itemsByCategory/{category}")
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable("category") Long category) {
        return new ResponseEntity<List<Item>>((List<Item>) service.findItemsByCategory(category), AppHelper.addHeader(), HttpStatus.OK);
    }

    @GetMapping("/itemsByManufacturer/{manufacurer}")
    public ResponseEntity<List<Item>> getItemsByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        return new ResponseEntity<List<Item>>((List<Item>) service.findItemsByManufacturer(manufacturer), AppHelper.addHeader(), HttpStatus.OK);
    }


}
