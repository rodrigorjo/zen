package com.example.zen.repository;

import com.example.zen.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query("select customer from Customer customer where customer.firstName = :name")
    List<Customer> findCustomerByFirstName(@Param("name") String name);

}
