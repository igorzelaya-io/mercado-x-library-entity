package hn.alturaforge.mercadox.library.entity.ports.incoming;

import hn.alturaforge.mercadox.library.entity.response.dto.ItemDto;
import hn.alturaforge.mercadox.library.entity.model.core.Inventory;
import hn.alturaforge.mercadox.library.entity.model.core.Item;

import java.util.List;

public interface ItemUseCase {

    ItemDto createItem(ItemDto itemDto);

    Item updateItem(Item item);

    List<ItemDto> getItems();

    Item getItemDetails(String itemId);

    void deleteItem(String id);

    boolean isInStock(String itemId, int quantity);

    Inventory getItemInventory(String itemId);

}
