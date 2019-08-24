package com.cdleaf.dao.repository;

import com.cdleaf.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="account")
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);

    Account save(Account account);


    @Query("SELECT a FROM Account a WHERE a.userName=:name")
    Account findAccountByUserName(@Param("name") String name);



}
