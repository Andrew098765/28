package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "zoo_animal")
public class ZooAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "zoo_id", referencedColumnName = "id")
    private Zoo zooId;

    @ManyToOne
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animalId;
    @Column(name = "time_apperance")
    private Date timeApperance;

    @ManyToOne
    @JoinColumn(name = "workman", referencedColumnName = "id")
    private Workman workman;

    public Zoo getZooId() {
        return zooId;
    }

    public void setZooId(Zoo zooId) {
        this.zooId = zooId;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Date getTimeApperance() {
        return timeApperance;
    }

    public void setTimeApperance(Date timeApperance) {
        this.timeApperance = timeApperance;
    }

    public Workman getWorkman() {
        return workman;
    }

    public void setWorkman(Workman workman) {
        this.workman = workman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
