package su.nsk.comptech.recreation.api.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class DataRequest implements Serializable {
    int idDevice;
    int idPlace;
    int countPerson;
}
