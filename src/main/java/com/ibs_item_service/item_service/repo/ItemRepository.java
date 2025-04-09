package com.ibs_item_service.item_service.repo;

import com.ibs_item_service.item_service.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}