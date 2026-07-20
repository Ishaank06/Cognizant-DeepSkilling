package com.cognizant.inventory.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InventoryController {
    @GetMapping("/inventory")
    public String getInventory() { return "Inventory data"; }
}
