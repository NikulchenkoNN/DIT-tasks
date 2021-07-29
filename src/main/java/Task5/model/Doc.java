package Task5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "DOCS")
@Entity
public class Doc {
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

    @ManyToOne
    @JoinColumn(name = "BOX_ID", nullable = false)
    private Box box;
}
