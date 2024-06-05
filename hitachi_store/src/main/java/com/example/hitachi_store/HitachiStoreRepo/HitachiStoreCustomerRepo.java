package com.example.hitachi_store.HitachiStoreRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.hitachi_store.entity.HitachiStoreCustomer;

@EnableJpaRepositories
@Repository

public interface HitachiStoreCustomerRepo extends JpaRepository<HitachiStoreCustomer, Integer>{
}
