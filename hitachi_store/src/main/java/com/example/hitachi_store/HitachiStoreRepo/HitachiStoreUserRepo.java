package com.example.hitachi_store.HitachiStoreRepo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.hitachi_store.entity.HitachiStoreUser;

@EnableJpaRepositories
@Repository

public interface HitachiStoreUserRepo extends JpaRepository<HitachiStoreUser, Integer>{

        Optional<HitachiStoreUser> findByEmail(String email);
        Optional<HitachiStoreUser> findByUsername(String username);
}
