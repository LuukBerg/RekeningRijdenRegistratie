package rekeningrijden.fr.rekeningrijdersregistratie.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Data
@NoArgsConstructor
public class StepDTO
{
    private double lat;
    private double lon;
    @JsonFormat(shape = Shape.NUMBER)
    private Date timestamp;
    private String trackerId;

    private StepDTO(Step step)
    {
        lat = step.getX();
        lon = step.getY();
        timestamp = step.getTimestamp();
        trackerId = step.getTrackerId();
    }

    public static List<StepDTO> transform(List<Step> steps)
    {
        List<StepDTO> result = new ArrayList<>(steps.size());
        for (Step step : steps){
            result.add(new StepDTO(step));
        }
        return result;
    }
}
