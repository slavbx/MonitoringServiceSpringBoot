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
public class Meter implements Comparable<Meter> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meters_id_seq_gen")
    @SequenceGenerator(name = "meters_id_seq_gen", sequenceName = "meters_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;            //идентификатор записи
    @Column
    private Integer heat;       //показания отопления
    @Column
    private Integer cold;       //показания холодной воды
    @Column
    private Integer hot;        //показания горячей воды
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "user_id")
    private User user;          //принадлежность к пользователю
    @Column
    private LocalDate date;     //дата подачи

    public Meter(Long id, Integer heat, Integer cold, Integer hot, User user, LocalDate date) {
        this.id = id;
        this.heat = heat;
        this.cold = cold;
        this.hot = hot;
        this.user = user;
        this.date = date;
    }

    public Meter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Пользователь: " + this.getUser().getName() + " " + "| Отопл: " + this.getHeat()
                + " " + "| ХВС: " + this.getCold() + " " + "| ГВС: " + this.getHot() + "| Дата: " + this.getDate();
    }

    @Override
    public int compareTo(Meter r) {
        if (this.getDate().isAfter(r.getDate())) {
            return 1;
        } else if (this.getDate().isBefore(r.getDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}
