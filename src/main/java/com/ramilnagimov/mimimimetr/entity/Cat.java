package com.ramilnagimov.mimimimetr.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cats")
public class Cat implements Comparable<Cat>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cats_name")
    private String cats_name;

    @Column(name = "score")
    private String score;

    public Cat() {
    }

    public Cat(int id, String cats_name, String score) {
        this.id = id;
        this.cats_name = cats_name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCats_name() {
        return cats_name;
    }

    public void setCats_name(String cats_name) {
        this.cats_name = cats_name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int compareTo(Cat cat) {
        return score.compareTo(cat.getScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

