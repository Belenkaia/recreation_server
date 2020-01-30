package ru.comptech.recreation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class DataRequest implements Serializable {
    private int idDevice;
    private int idPlace;
    private int countPerson;
}
