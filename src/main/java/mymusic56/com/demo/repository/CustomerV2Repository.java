package mymusic56.com.demo.repository;

import mymusic56.com.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.print.Pageable;
import java.util.List;

public interface CustomerV2Repository extends JpaRepository<Customer, Long> {
    //Like查询
    @Query(value = "select id,firstName,lastName from customer where fistName like %?1", nativeQuery = true)
    List<Customer> findByFNameEndsWith(String fistName);

//    @Query("select id,firstName,lastName from customer where  firstName =?1")
//    Customer findByfName(String firstName);

//    Native Queries
//    @Query(value = "SELECT id,firstName,lastName FROM customer WHERE lastName = ?1", nativeQuery = true)
//    Customer findByLName(String lastName);

//    分页查询
//    @Query(value = "SELECT id,firstName,lastName FROM customer WHERE lastName = ?1",
//            countQuery = "SELECT count(*) FROM lastName WHERE lastName = ?1",
//            nativeQuery = true)
//    Page<Customer> findByLastname(String lastName, Pageable pageable);
}
