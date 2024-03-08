package com.slavbx.monserv.models;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

/**
 * Профиль пользователя, содержащий список с переданными показаниями счётчиков
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq_gen")
    @SequenceGenerator(name = "users_id_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;                //Идентификатор пользователя
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;            //Уровень доступа пользователя
    @Column
    private String name;            //Имя пользователя
    @Column
    private String password;        //Пароль
    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<MeterData> meterDatas;   //Список показаний счётчиков


    public enum Level {
        USER, ADMIN
    }

    public User() {
    }

    public User(Long id, Level level, String name, String password) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.password = password;
        this.meterDatas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MeterData> getMeterDatas() {
        return meterDatas;
    }

    public void setMeterDatas(List<MeterData> records) {
        this.meterDatas = records;
    }

    public void addRecord(MeterData record) {
        meterDatas.add(record);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User other = (User) obj;
        return other.getName().equals(this.getName());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

