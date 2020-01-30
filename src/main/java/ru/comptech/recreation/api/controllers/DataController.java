package ru.comptech.recreation.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.comptech.recreation.api.dto.DataRequest;
import ru.comptech.recreation.api.services.DbService;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping(value = "/recreation/api/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class DataController {

    //@Autowired
    private final DbService dbService;

    @PostMapping
    @ResponseBody
    public Integer add(@NotNull @RequestBody DataRequest request) {
        return dbService.add(request);
    }
}
