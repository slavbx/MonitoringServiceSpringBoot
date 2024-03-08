package com.slavbx.monserv.models;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDate;

/**
 * Запись показаний счетчиков, передаваемая пользователем
 */
@Entity
@Table(name = "meters")
public class MeterData implements Comparable<MeterData> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meters_id_seq_gen")
    @SequenceGenerator(name = "meters_id_seq_gen", sequenceName = "meters_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;            //идентификатор записи
    @Column
    private Integer value;       //показания счётчика
    @ManyToOne(fetch = FetchType.LAZY) //@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "user_id")
    private User user;          //принадлежность к пользователю
    @OneToOne
    @JoinColumn(name = "type_id")
    private MeterType type;        //тип счётчика
    @Column
    private LocalDate date;     //дата подачи

    public MeterData(Long id, Integer value, User user, MeterType type, LocalDate date) {
        this.id = id;
        this.value = value;
        this.user = user;
        this.type = type;
        this.date = date;
    }

    public MeterData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MeterType getType() {
        return type;
    }

    public void setType(MeterType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    @Override
//    public String toString() {
//        return "Пользователь: " + this.getUser().getName() + " " + "| Отопл: " + this.getHeat()
//                + " " + "| ХВС: " + this.getCold() + " " + "| ГВС: " + this.getHot() + "| Дата: " + this.getDate();
//    }

    @Override
    public int compareTo(MeterData r) {
        if (this.getDate().isAfter(r.getDate())) {
            return 1;
        } else if (this.getDate().isBefore(r.getDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}
