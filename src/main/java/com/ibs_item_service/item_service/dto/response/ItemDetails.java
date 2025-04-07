package com.ibs_item_service.item_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {
    private Long id;
    private String name;
    private String description;
    private Double unitPrice;
}
