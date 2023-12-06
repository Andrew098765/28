package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.*;

@Entity()
@Table(name = "zoo")
public class Zoo implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "\"name\"")
    private String name;

    public Zoo() {
    }

    public Zoo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
