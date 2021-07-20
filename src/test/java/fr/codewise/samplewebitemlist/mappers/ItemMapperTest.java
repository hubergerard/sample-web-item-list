package fr.codewise.samplewebitemlist.mappers;

import fr.codewise.samplewebitemlist.dto.CreateItemDto;
import fr.codewise.samplewebitemlist.entities.Item;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemMapperTest {

    @InjectMocks
    ItemMapper itemMapper;

    @Test
    public void test_mapCreateItemDtoToEntity_inAnyCase_ShouldMapTheCorrectValues() {
        CreateItemDto createItemDto = new CreateItemDto();
        createItemDto.setQuantity("17");
        createItemDto.setName("Sopalin");

        Item item = itemMapper.mapCreateItemDtoToEntity(createItemDto);

        assertThat(item).isExactlyInstanceOf(Item.class);
        assertThat(item)
                .returns(createItemDto.getQuantity(), Item::getQuantity)
                .returns(createItemDto.getName(), Item::getName);
    }
}
