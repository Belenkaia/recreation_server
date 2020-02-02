package su.nsk.comptech.recreation.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import su.nsk.comptech.recreation.api.dto.DataPredictionRequest;
import su.nsk.comptech.recreation.api.dto.DataPredictionResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class PredictionService {

    //тут должен быть репозиторий, от которого получаем последние данные

    public DataPredictionResponse getDataPredication() throws RestClientException {
        //ищем строку в базе
        //данные записываем в DataPredictionRequest
        Map<Integer, Integer> classrooms = new HashMap<>();
        DataPredictionRequest request = DataPredictionRequest.builder()
                .zoneId(3107)
                .currPeopleCount(2)
                .currTimestamp("2020-02-02 \n 13:00:00")
                .predictTimestamp("2020-02-02 \n 13:15:00")
                .build();

       // DataDeviceRequest request = new DataDeviceRequest(1, 22222, 333333);
    //отправляем с помощью клиента и получаем ответ
        final RestTemplate restTemplate = new RestTemplate();
        URI url = null;
        try {
            //6543
            url = new URI("http://192.168.1.80:6543/get_occupied_prediction");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        assert url != null;
        final DataPredictionResponse jsonResponse = restTemplate.postForObject(url, request, DataPredictionResponse.class);
        assert jsonResponse != null;
        System.out.println(jsonResponse.toString());

        // PredictionClient predictionClient = null;
        // DataPredictionResponse response = predictionClient.getDataPrediction(request);
        //полученный ответ выводим
        //return response;
        return null;
    }
}
