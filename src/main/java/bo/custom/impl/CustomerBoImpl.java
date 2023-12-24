package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DaoFactory;
import dao.Util.DaoType;
import dao.custom.CustomerDao;
import dto.CustomerDto;
import entity.customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

 private   CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {

        return customerDao.update(new customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }
    @Override
    public boolean getAllCustomer(CustomerDto dto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException {
       List<customer> entityList= customerDao.getAll();
       List<CustomerDto> list=new ArrayList<>();
       for (customer Customer:entityList ){
           list.add(new CustomerDto(

                   Customer.getId(),
                   Customer.getName(),
                   Customer.getAddress(),
                   Customer.getSalary()
           ));

       }
        return list;
    }
}
