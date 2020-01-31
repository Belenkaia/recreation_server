package su.nsk.comptech.recreation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class DataRequest implements Serializable {
    private int deviceId;
    private int placeId;
    private int countPerson;

}
