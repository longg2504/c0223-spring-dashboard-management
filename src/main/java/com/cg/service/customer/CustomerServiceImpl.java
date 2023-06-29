package com.cg.service.customer;

import com.cg.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{

    public static List<Customer> customers = new ArrayList<Customer>();
    public static Long maxId = 1L;

    static {
        customers.add(new Customer(maxId++, "Nguyễn Giang Phương Long","longg2504@gmail.com",
                "0784689119","2/2 Kiệt 61 Đặng Văn Ngữ,TP Huế" ));
        customers.add(new Customer(maxId++, "Nguyễn Hồ Hải","hai2500@gmail.com" ,
                "0123456789","22 Ngự Bình , Tp huế"));
        customers.add(new Customer(maxId++, "Lê Thị Thanh Thanh","thanhltt0904@gmail.com",
                "0123456789","22 Tân Thanh , TP Gia Lai"));
        customers.add(new Customer(maxId++, "Lý Quỳnh Trân", "tranly2705@gmail.com",
                "0123456789","22 Núi Thành , TP Quảng Nam"));
    }


    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(Long id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customer.setId(maxId);
        customers.add(customer);
        maxId++;
    }

    @Override
    public void update(Customer customer) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(customer.getId())) {
                index = i;
            }
        }

        if (index > -1) {
            customers.set(index, customer);
        }
    }


}
