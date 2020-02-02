package su.nsk.comptech.recreation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class DataDeviceRequest implements Serializable {
    private int deviceId;
    private int placeId;
    private int count;
}
