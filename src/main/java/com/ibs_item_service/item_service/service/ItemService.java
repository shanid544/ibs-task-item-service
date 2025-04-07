package com.ibs_item_service.item_service.service;

import com.ibs_item_service.item_service.dto.response.ItemDetails;
import com.ibs_item_service.item_service.entity.Item;
import com.ibs_item_service.item_service.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<ItemDetails> getItemsByIds(List<Long> ids) {
        List<Item> items = itemRepository.findAllById(ids);
        return items.stream().map(item -> new ItemDetails(item.getId(), item.getName(), item.getDescription(), item.getUnitPrice())).toList();
    }
}