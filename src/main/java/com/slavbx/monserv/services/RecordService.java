package com.slavbx.monserv.services;

import com.slavbx.monserv.models.Record;
import com.slavbx.monserv.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public <S extends Record> S save(S entity) {
        return recordRepository.save(entity);
    }

    public Optional<Record> findById(Long aLong) {
        return recordRepository.findById(aLong);
    }
}
