package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Movement
{
    @GeneratedValue
    @Id
    private long id;

    private String cartracker;
    private Boolean active;

    public Movement(String cartracker)
    {
        this.cartracker = cartracker;
    }
}
