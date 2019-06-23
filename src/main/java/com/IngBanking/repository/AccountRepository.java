package com.IngBanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.IngBanking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(value = "select a.*"
			+ " from user u,account a where a.user_id=u.user_id and u.user_id=:userId",nativeQuery = true)
	public List<Account> findByUserId(@Param("userId") Long userId);
}
