package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Movement {
    @GeneratedValue
    @Id
    private long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Step> steps;
    private String cartracker;
    private Boolean active;

    public Movement(String cartracker) {
        this.cartracker = cartracker;
        steps = new ArrayList<>();
    }


}
