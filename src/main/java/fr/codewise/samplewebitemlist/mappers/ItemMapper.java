package fr.codewise.samplewebitemlist.mappers;

import fr.codewise.samplewebitemlist.dto.CreateItemDto;
import fr.codewise.samplewebitemlist.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapCreateItemDtoToEntity(CreateItemDto dto){
        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        return item;
    }
}
