package mymusic56.com.demo.repository;

import mymusic56.com.demo.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //通过方法名查询, 可参考5.3.2Query Creation
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
    List<Customer> findByFirstNameEndingWith(String fistName);
    Customer findById(long id);
}
