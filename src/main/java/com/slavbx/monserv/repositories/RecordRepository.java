package com.slavbx.monserv.repositories;

import com.slavbx.monserv.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);
    //Record findByUserIdOrderByDateDesc(Long userId); //Найти по userId и отсортировать в порядке убывания
}

