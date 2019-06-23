package com.IngBanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngBanking.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
//@Query("select u from User u where u.accountId =:accountId and u.password=:password")
	public User findByUserIdAndPassword(Long userId, String password);

}
