package su.nsk.comptech.recreation.api.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class DataPredictionResponse implements Serializable {
    private int zoneId;
    private int predictedPeopleCount;
    private int predictionProbability;
}
