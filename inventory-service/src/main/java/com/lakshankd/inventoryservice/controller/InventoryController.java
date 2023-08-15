package com.lakshankd.inventoryservice.controller;

import com.lakshankd.inventoryservice.dto.InventoryResponse;
import com.lakshankd.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone_13,iphone_13_red  --> if used Path Variables.
    // http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone_13_red --> if used Request Mapping.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
