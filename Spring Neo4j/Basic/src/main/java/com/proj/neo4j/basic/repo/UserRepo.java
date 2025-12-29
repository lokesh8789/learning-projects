package com.proj.neo4j.basic.repo;

import com.proj.neo4j.basic.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepo extends Neo4jRepository<User,Long> {
    User findByUserId(Long userId);
}
