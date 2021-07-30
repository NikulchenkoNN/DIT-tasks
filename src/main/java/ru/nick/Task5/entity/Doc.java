package ru.nick.Task5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "docs")
@Entity
public class Doc {
    @Id
    @Setter @Getter
    private Long id;

    @Column(name = "name")
    @Setter @Getter
    private String name;

    @Column(name = "barcode")
    @Setter @Getter
    private Long barcode;

    @ManyToOne
    @JoinColumn(name = "box_id", nullable = false)
    @JsonIgnore
    @Setter @Getter
    private Box box;

    public Doc(Long id, String name, Long barcode) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode=" + barcode +
                '}';
    }

    public Doc() {
    }
}
