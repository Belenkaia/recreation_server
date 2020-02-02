package su.nsk.comptech.recreation.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import su.nsk.comptech.recreation.api.dto.DataDeviceRequest;
import su.nsk.comptech.recreation.api.services.DbService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/recreation/api/data/device", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
@ToString
public class DevicesController {

    private final DbService dbService;

    @PostMapping
    @ResponseBody
    public void setDataDevice(@NotNull @RequestBody DataDeviceRequest request) {
        dbService.add(request);
    }
}
