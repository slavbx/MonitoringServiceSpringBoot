package com.slavbx.monserv.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

/**
 * Запись показаний счетчиков, передаваемая пользователем
 */
@Entity
@Table(name="records")
public class Record implements Comparable<Record> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;            //идентификатор записи
    @Column
    private Integer heat;       //показания отопления
    @Column
    private Integer cold;       //показания холодной воды
    @Column
    private Integer hot;        //показания горячей воды
    @Transient
    private String userName;    //имя пользователя
    @Column
    private LocalDate date;     //дата подачи

    public Record(Integer heat, Integer cold, Integer hot, String userName, LocalDate date) {
        //this.id = id;
        this.heat = heat;
        this.cold = cold;
        this.hot = hot;
        this.userName = userName;
        this.date = date;
    }

    public Record() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public Integer getCold() {
        return cold;
    }

    public void setCold(Integer cold) {
        this.cold = cold;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Пользователь: " + this.getUserName() + " | Дата: " + this.getDate() + " " + "| Отопл: " + this.getHeat()
                + " " + "| ХВС: " + this.getCold() + " " + "| ГВС: " + this.getHot();
    }

    @Override
    public int compareTo(Record r) {
        if (this.getDate().isAfter(r.getDate())) {
            return 1;
        } else if (this.getDate().isBefore(r.getDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}
