package co.edu.udea.api.persistence.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HERO")
public class HeroEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private Integer id;
    private String name;

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
