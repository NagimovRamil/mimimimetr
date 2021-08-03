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
    private String catsName;

    @Column(name = "score")
    private Integer score;

    @Column(name = "image", columnDefinition = "blob")
    private byte[] image;

    public Cat() {
    }

    public Long getId() {
        return id;
    }

    public String getCatsName() {
        return catsName;
    }

    public byte[] getImage() {
        return image;
    }

    public Integer getScore() {
        return score;
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
                Objects.equals(catsName, cat.catsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catsName);
    }
}

