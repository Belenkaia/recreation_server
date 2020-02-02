package su.nsk.comptech.recreation.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class DataPredictionRequest implements Serializable {
    private int zoneId;//Id зоны
    private int currPeopleCount;
    private String currTimestamp;
    private String predictTimestamp;
}
