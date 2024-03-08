package com.slavbx.monserv.repositories;

import com.slavbx.monserv.models.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecordRepository extends JpaRepository<MeterData, Long> {
    List<MeterData> findByUserId(Long userId);
    //Record findByUserIdOrderByDateDesc(Long userId); //Найти по userId и отсортировать в порядке убывания


}

