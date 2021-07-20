package fr.codewise.samplewebitemlist.services;

import fr.codewise.samplewebitemlist.dto.CreateItemDto;
import fr.codewise.samplewebitemlist.entities.Item;
import fr.codewise.samplewebitemlist.mappers.ItemMapper;
import fr.codewise.samplewebitemlist.repositories.ItemRepository;
import fr.codewise.samplewebitemlist.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    @Mock
    ItemMapper itemMapper;

    @Test
    public void test_createItem_inAnyCase_shouldCallRepository() {
        CreateItemDto dto = new CreateItemDto();
        dto.setName("Lait");
        dto.setQuantity("4L");

        Item returnedItem = new Item();
        returnedItem.setName("Lait");
        returnedItem.setQuantity("4L");

        when(itemMapper.mapCreateItemDtoToEntity(any(CreateItemDto.class)))
                .thenReturn(returnedItem);

        itemService.createItem(dto);

        ArgumentCaptor<Item> captor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(any(Item.class));
    }

    @Test
    public void test_deleteItemById_inAnyCase_shouldCallRepository() {
        Long id = 6L;
        itemService.deleteItemById(id);
        verify(itemRepository).deleteById(id);
    }
}
