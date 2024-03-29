package com.slavbx.monserv.services;

import com.slavbx.monserv.models.MeterData;
import com.slavbx.monserv.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeterService {
    RecordRepository recordRepository;

    @Autowired
    public MeterService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @PostConstruct
    public void init() {
//        if (findByUserId(1L).isEmpty()) {
//            User user = new User(1L, User.Level.USER, "slav", "123");
//            save(new Record(1L, 111,11,11, user, LocalDate.parse("2023-11-12")));
//            save(new Record(2L, 222,22,22, user, LocalDate.parse("2023-12-15")));
//            save(new Record(3L, 333,33,33, user, LocalDate.parse("2024-01-05")));
//        }
    }

    public List<MeterData> findAll() {
        return recordRepository.findAll();
    }

    public MeterData findActualByUserId(Long userId) { //Получить актуальную запись для текущего пользователя
        List<MeterData> list = recordRepository.findByUserId(userId);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public List<MeterData> findActualAllUsers() {
        List<MeterData> list = recordRepository.findAll();
        //list.sort(Comparator.reverseOrder());
        Map<Long, List<MeterData>> groupedRecords = list.stream().collect(Collectors.groupingBy(r -> r.getUser().getId()));
        //groupedRecords.forEach((k, v) -> v.sort(Comparator.reverseOrder()));
        return groupedRecords.values().stream().map(l -> l.get(0)).collect(Collectors.toList());
    }

    public List<MeterData> findByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    public void save(MeterData record) {
        recordRepository.save(record);
    }

    public Optional<MeterData> findById(Long aLong) {
        return recordRepository.findById(aLong);
    }




}
