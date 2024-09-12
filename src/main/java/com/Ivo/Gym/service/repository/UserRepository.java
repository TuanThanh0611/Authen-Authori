package com.Ivo.Gym.service.repository;

import com.Ivo.Gym.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public boolean existsByUserName(String userName);
}
