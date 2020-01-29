package su.nsk.comptech.recreation.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.nsk.comptech.recreation.api.dto.DataRequest;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping(value = "/recreation/api/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataController {

    @PostMapping
    @ResponseBody
    public void add(@NotNull @RequestBody DataRequest request) {
        //
    }
}
