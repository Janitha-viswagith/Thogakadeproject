package bo.custom;

import bo.SuperBo;
import dto.CustomerDto;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBo {

    boolean saveItem (ItemDto dto) throws SQLException, ClassNotFoundException;
    boolean getAllItem(ItemDto  dto);
    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDto  dto) throws SQLException, ClassNotFoundException;
    List<ItemDto> allItem() throws SQLException, ClassNotFoundException;
}
