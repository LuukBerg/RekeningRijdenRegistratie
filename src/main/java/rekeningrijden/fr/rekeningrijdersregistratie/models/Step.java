package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Step {

    @GeneratedValue
    @Id
    private long id;
    private double x;
    private double y;
    private Date timestamp;
    private String trackerId;
    @ManyToOne
    @JoinColumn(name = "movementid")
    private Movement movement;

    public Step(double x, double y, Date timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }
}
