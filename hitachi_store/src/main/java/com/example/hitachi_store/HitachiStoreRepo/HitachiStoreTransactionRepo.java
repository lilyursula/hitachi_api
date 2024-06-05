package com.example.hitachi_store.HitachiStoreRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.hitachi_store.entity.HitachiStoreTransaction;

@EnableJpaRepositories
@Repository

public interface HitachiStoreTransactionRepo extends JpaRepository<HitachiStoreTransaction, Integer>{

}
