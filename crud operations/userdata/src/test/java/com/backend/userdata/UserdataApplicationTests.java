package com.backend.userdata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.azure.data.cosmos.PartitionKey;
import com.backend.userdata.Repository.UserRepository;
import com.backend.userdata.model.User;

import org.springframework.beans.factory.annotation.Autowired;



@SpringBootTest
class UserdataApplicationTests {

	@Autowired
    UserRepository userRepository;

    @Test
    public void givenUserIsCreated_whenCallFindById_thenUserIsFound() {
        User user = new User();
        user.setId(1);
        user.setFirstName("tony");
        user.setLastName("jony");
        user.setEmailId("tony@gmail.com");

        userRepository.save(user);
        User retrievedData = userRepository.findById((long) 1, new PartitionKey(null))
            .orElse(null);

    }

}
