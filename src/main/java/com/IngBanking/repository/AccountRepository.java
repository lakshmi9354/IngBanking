package com.IngBanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngBanking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
