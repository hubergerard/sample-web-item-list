package fr.codewise.samplewebitemlist.services;

import fr.codewise.samplewebitemlist.dto.CreateItemDto;
import fr.codewise.samplewebitemlist.entities.Item;
import fr.codewise.samplewebitemlist.mappers.ItemMapper;
import fr.codewise.samplewebitemlist.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public void createItem(CreateItemDto dto) {
        itemRepository.save(itemMapper.mapCreateItemDtoToEntity(dto));
    }

}
