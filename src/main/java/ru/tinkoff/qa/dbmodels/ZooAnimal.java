package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "zoo_animal")
public class ZooAnimal {
    @Column(name = "zoo_id")
    int zooId;
    @Column(name = "animal_id")
    int animalId;
    @Column(name = "time_apperance")
    Date timeApperance;
    @Column(name = "workman")
    int workman;

    public int getZooId() {
        return zooId;
    }

    public void setZooId(int zooId) {
        this.zooId = zooId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public Date getTimeApperance() {
        return timeApperance;
    }

    public void setTimeApperance(Date timeApperance) {
        this.timeApperance = timeApperance;
    }

    public int getWorkman() {
        return workman;
    }

    public void setWorkman(int workman) {
        this.workman = workman;
    }
}
