package com.avatar.bank.Avatar_Bank.repository;


import com.avatar.bank.Avatar_Bank.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


    @Query("select c from Customer c where c.firstName = :firstName and c.lastName = :lastName")
    Optional<Customer> findEmployeeByFirstNameAndLastName(
            @Param("firstName") String firstName, @Param("lastName") String lastName);
}
