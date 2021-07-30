package ru.nick.Task5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "boxes")
@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long id;

    @Column(name = "name")
    @Setter @Getter
    private String name;

    @Column(name = "barcode")
    @Setter @Getter
    private Long barcode;

    @OneToMany(mappedBy = "box")
    @Setter @Getter
    private List<Doc> docList;

    public void setDoc(Doc doc) {
        doc.setBox(this);
        docList.add(doc);
    }

    public Box(Long id, String name, Long barcode, List<Doc> docList) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.docList = docList;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode=" + barcode +
                ", docList=" + docList +
                '}';
    }

    public Box() {
    }
}
