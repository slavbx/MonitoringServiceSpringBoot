package com.slavbx.monserv.services;

import com.slavbx.monserv.models.Record;
import com.slavbx.monserv.models.User;
import com.slavbx.monserv.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordService {
    RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    public void init() {
        //Record record1 = new Record(1L, 111,11,11,1L, LocalDate.parse("2023-11-12"));
        //Record record2 = new Record(2L, 222,22,22,1L, LocalDate.parse("2023-12-15"));
        //Record record3 = new Record(3L, 333,33,33,1L, LocalDate.parse("2024-01-05"));
        //save(record1);
        //save(record2);
        //save(record3);
    }

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public Record findActualByUserId(Long userId) { //Получить актуальную запись для текущего пользователя
        List<Record> list = recordRepository.findByUserId(userId);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public List<Record> findActualAllUsers() {
        List<Record> list = recordRepository.findAll();
        //list.sort(Comparator.reverseOrder());
        Map<Long, List<Record>> groupedRecords = list.stream().collect(Collectors.groupingBy(r -> r.getUser().getId()));
        //groupedRecords.forEach((k, v) -> v.sort(Comparator.reverseOrder()));
        return groupedRecords.values().stream().map(l -> l.get(0)).collect(Collectors.toList());
    }

    public List<Record> findByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    public void save(Record record) {
        recordRepository.save(record);
    }

    public Optional<Record> findById(Long aLong) {
        return recordRepository.findById(aLong);
    }




}
