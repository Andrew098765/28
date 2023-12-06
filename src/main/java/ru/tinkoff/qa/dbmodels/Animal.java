package ru.tinkoff.qa.dbmodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "\"type\"", referencedColumnName = "id")
    private Types type;

    @ManyToOne
    @JoinColumn(name = "sex", referencedColumnName = "id")
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "place", referencedColumnName = "id")
    private Places place;

    public Animal() {
    }

    public Animal(Integer id, String name, Integer age, Types type, Sex sex, Places place) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.sex = sex;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", sex=" + sex +
                ", place=" + place +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Places getPlace() {
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

}
