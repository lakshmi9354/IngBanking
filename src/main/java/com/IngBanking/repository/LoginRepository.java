package com.IngBanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngBanking.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
	public User findByUserIdAndPassword(Long userId, String password);

}
