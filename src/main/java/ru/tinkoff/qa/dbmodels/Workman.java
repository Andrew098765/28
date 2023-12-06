package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.*;

@Entity
@Table(name = "workman")
public class Workman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "position", referencedColumnName = "id")
    private Positions position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }
}
