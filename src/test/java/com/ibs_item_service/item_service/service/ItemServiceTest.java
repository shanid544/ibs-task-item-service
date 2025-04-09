package com.ibs_item_service.item_service.service;

import com.ibs_item_service.item_service.dto.response.ItemDetails;
import com.ibs_item_service.item_service.entity.Item;
import com.ibs_item_service.item_service.repo.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getItemById_shouldReturnItem() {
        Item mockItem = new Item(1L, "Test Item", "Test Description", 19.99);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(mockItem));

        Optional<Item> result = itemService.getItemById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Item", result.get().getName());
        verify(itemRepository, times(1)).findById(1L);
    }

    @Test
    void getItemsByIds_shouldReturnItemDetailsList() {
        Item item1 = new Item(1L, "Mouse", "Wireless Mouse", 25.99);
        Item item2 = new Item(2L, "Keyboard", "Mechanical Keyboard", 49.99);

        when(itemRepository.findAllById(List.of(1L, 2L))).thenReturn(List.of(item1, item2));

        List<ItemDetails> result = itemService.getItemsByIds(List.of(1L, 2L));

        assertEquals(2, result.size());
        assertEquals("Mouse", result.get(0).getName());
        assertEquals("Keyboard", result.get(1).getName());
        verify(itemRepository, times(1)).findAllById(List.of(1L, 2L));
    }
}
