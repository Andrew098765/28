package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.beans.ConstructorProperties;

@Entity
@Table(name = "places")
public class Places {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "row")
    Integer row;
    @Column(name = "placeNum")
    Integer placeNum;
    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(Integer placeNum) {
        this.placeNum = placeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
