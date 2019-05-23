package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StepDTO {

    private double lat;
    private double lon;
    private Date timestamp;
    private String trackerId;

    public static List<StepDTO> transform(List<Step> steps){
        List<StepDTO> dtos = new ArrayList<>();
        for (Step step : steps){
            dtos.add(new StepDTO(step.getX(),step.getY(),step.getTimestamp(),step.getTrackerId()));
        }
        return dtos;
    }

}
