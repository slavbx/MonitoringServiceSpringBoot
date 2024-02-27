package com.slavbx.monserv.services;

import com.slavbx.monserv.models.Record;
import com.slavbx.monserv.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RecordService {
    RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
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
        Map<Long, List<Record>> groupedRecords = list.stream().collect(Collectors.groupingBy(Record::getUserId));
        //groupedRecords.forEach((k, v) -> v.sort(Comparator.reverseOrder()));
        return groupedRecords.values().stream().map(l -> l.get(0)).collect(Collectors.toList());
    }

    public List<Record> findByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    public <S extends Record> S save(S entity) {
        return recordRepository.save(entity);
    }

    public Optional<Record> findById(Long aLong) {
        return recordRepository.findById(aLong);
    }




}
