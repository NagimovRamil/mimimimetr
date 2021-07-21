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

    @Column(name = "image", columnDefinition = "blob")
    private byte[] image;

    public Cat() {
    }

    public Long getId() {
        return id;
    }

    public String getCats_name() {
        return cats_name;
    }

    public byte[] getImage() {
        return image;
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

