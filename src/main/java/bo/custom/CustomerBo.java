package bo.custom;

import bo.SuperBo;
import dao.custom.CustomerDao;
import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo  extends SuperBo {

    boolean saveCustomer (CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean getAllCustomer(CustomerDto dto);
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException;
}
