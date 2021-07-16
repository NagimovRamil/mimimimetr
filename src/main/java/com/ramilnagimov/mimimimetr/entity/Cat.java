package com.ramilnagimov.mimimimetr.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cats")
public class Cat implements Comparable<Cat> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cats_name")
    private String cats_name;

    @Column(name = "score")
    private Integer score;

    public Cat() {
    }

    public Cat(Long id, String cats_name, int score) {
        this.id = id;
        this.cats_name = cats_name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCats_name() {
        return cats_name;
    }

    public void setCats_name(String cats_name) {
        this.cats_name = cats_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Cat cat) {
        return score.compareTo(cat.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id.equals(cat.id) &&
                Objects.equals(cats_name, cat.cats_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cats_name);
    }
}

