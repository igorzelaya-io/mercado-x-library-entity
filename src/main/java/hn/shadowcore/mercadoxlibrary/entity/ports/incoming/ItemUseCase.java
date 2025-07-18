package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.core.Item;
import hn.shadowcore.mercadoxlibrary.entity.response.dto.ItemDto;

import java.util.List;

public interface ItemUseCase {

    ItemDto createItem(ItemDto itemDto);

    List<ItemDto> getItems();

    Item getItemDetails(String itemId);

    void deleteItem(String id);

    boolean isInStock(String itemId, int quantity);

}
