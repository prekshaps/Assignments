package com.backend.userdata.Repository;

import org.springframework.stereotype.Repository;

import com.backend.userdata.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;



@Repository
public interface UserRepository extends CosmosRepository<User, Long> {

}
