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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<Meter> records;   //Список показаний счётчиков


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
        this.records = new ArrayList<>();
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

    public List<Meter> getRecords() {
        return records;
    }

    public void setRecords(List<Meter> records) {
        this.records = records;
    }

    public void addRecord(Meter record) {
        records.add(record);
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

