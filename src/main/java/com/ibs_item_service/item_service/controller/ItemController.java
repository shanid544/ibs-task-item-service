package com.ibs_item_service.item_service.controller;

import com.ibs_item_service.item_service.dto.response.ItemList;
import com.ibs_item_service.item_service.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ibs_item_service.item_service.entity.Item;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @PostMapping("/list")
    public ItemList getItemsByIds(@RequestBody List<Long> ids) {
        return new ItemList(itemService.getItemsByIds(ids));
    }
}