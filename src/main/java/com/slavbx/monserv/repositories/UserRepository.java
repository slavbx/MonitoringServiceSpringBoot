package com.slavbx.monserv.repositories;

import com.slavbx.monserv.models.Record;
import com.slavbx.monserv.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(@NonNull Long id);
    Optional<User> findByName(String name);
}