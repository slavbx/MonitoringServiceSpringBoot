package com.slavbx.monserv.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "meter_types")
public class MeterType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meter_types_id_seq_gen")
    @SequenceGenerator(name = "meter_types_id_seq_gen", sequenceName = "meter_types_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;            //идентификатор типа
    @Column
    private String name;        //имя типа показания счётчика

}
