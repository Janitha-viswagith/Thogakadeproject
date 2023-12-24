package bo.custom.impl;

import bo.custom.ItemBO;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
//
//        return ItemDao.save(new customer(
//                dto.getId(),
//                dto.getName(),
//                dto.getAddress(),
//                dto.getSalary()
//        ));

        return false;
    }

    @Override
    public boolean getAllItem(ItemDto dto) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<ItemDto> allItem() throws SQLException, ClassNotFoundException {
        return null;
    }
}
