package com.mymusic56.demo.management;

import com.mymusic56.demo.entity.Customer;
import com.mymusic56.demo.entity.User;
import com.mymusic56.demo.repository.CustomerJapRepository;
import com.mymusic56.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagementImpl {
    private final UserRepository userRepository;
    private final CustomerJapRepository customerJapRepository;

    @Autowired
    public UserManagementImpl(UserRepository userRepository, CustomerJapRepository customerJapRepository){
        this.userRepository = userRepository;
        this.customerJapRepository = customerJapRepository;
    }

    @Transactional
    public void saveUserAndCustomer(String firstNmae, String lastName, String email) throws Exception{
        User user = new User();
        user.setName(firstNmae + lastName);
        user.setEmail(email);
        userRepository.save(user);
        boolean a= true;
        if (a) {
            throw new Exception("测试异常");
        }

        Customer customer = new Customer(firstNmae, lastName, email);
        customerJapRepository.save(customer);
    }
}
