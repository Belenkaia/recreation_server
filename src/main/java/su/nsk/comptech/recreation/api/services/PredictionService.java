package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.entities.SocketData;
import su.nsk.comptech.recreation.api.repositories.CameraRepository;
import su.nsk.comptech.recreation.api.repositories.SocketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {

    @Autowired
    private final SocketRepository socketRepository;
    @Autowired
    private final CameraRepository cameraRepository;

    public List<SocketData> getDataPredication(List<Integer> placesId) {
        //List<DataPredictionRequest> request = new ArrayList<>(); //надо достать данные из базы и заполнить массив

        /*final RestTemplate restTemplate = new RestTemplate();
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
        System.out.println(jsonResponse.toString());*/

       /* List<SocketData> socketDataList = new ArrayList<>();
        for(Integer id: placesId){
           //socketDataList.add(socketRepository.actualizeData(id));
        }
        for(SocketData elem: socketDataList){
            System.out.println(elem.toString());
        }
        return socketDataList;*/
       return null;
    }
}
