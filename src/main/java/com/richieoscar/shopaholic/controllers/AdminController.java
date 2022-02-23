package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.ItemRequest;
import com.richieoscar.shopaholic.dto.response.ItemResponse;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.entities.Manufacturer;
import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody ItemRequest request) {
        return ResponseEntity.ok(adminService.addItem(request.getItem()));
    }




}
