package Task5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "BOXES")
@Entity
public class Box {
    @Id
    @Column(name = "ID")
    @Setter @Getter
    private Long id;

    @Column(name = "NAME")
    @Setter @Getter
    private String name;

    @Column(name = "CODE")
    @Setter @Getter
    private Long code;

    @OneToMany(mappedBy = "boxes")
    @Setter @Getter
    private List<Doc> docList;
}
