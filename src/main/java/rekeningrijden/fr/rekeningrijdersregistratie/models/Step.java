package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
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
    @Transient
    private String trackerId;

    public Step(double x, double y, Date timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }
}
