package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.dto.DataDeviceRequest;
import su.nsk.comptech.recreation.api.entities.CameraActualData;
import su.nsk.comptech.recreation.api.entities.CameraDataArchive;
import su.nsk.comptech.recreation.api.entities.SocketActualData;
import su.nsk.comptech.recreation.api.entities.SocketDataArchive;
import su.nsk.comptech.recreation.api.repositories.CameraActualDataRepository;
import su.nsk.comptech.recreation.api.repositories.CameraDataArchiveRepository;
import su.nsk.comptech.recreation.api.repositories.SocketActualDataRepository;
import su.nsk.comptech.recreation.api.repositories.SocketDataArchiveRepository;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final SocketActualDataRepository socketActualDataRepository;
    @Autowired
    private final CameraActualDataRepository cameraActualDataRepository;
    @Autowired
    private final SocketDataArchiveRepository socketDataArchiveRepository;
    @Autowired
    private final CameraDataArchiveRepository cameraDataArchiveRepository;

    public void add(DataDeviceRequest request) {
        if (request.getDeviceId() == 1) {
            addSocketData(request);
        }
        if(request.getDeviceId() == 0) {
            addCameraData(request);
        }
    }

    private void addSocketData(DataDeviceRequest request) {
        SocketActualData actualData = new SocketActualData(request.getPlaceId(), request.getCount(), new Date());
        Optional<SocketActualData> foundData = socketActualDataRepository.findById(actualData.getPlaceId());
        if(foundData.isPresent()){
            SocketDataArchive dataArchive = new SocketDataArchive();
            dataArchive.setPlaceId(foundData.get().getPlaceId());
            dataArchive.setCount(foundData.get().getCount());
            dataArchive.setCurrTimestamp(foundData.get().getCurrTimestamp());
            socketDataArchiveRepository.save(dataArchive);
        }
        //обновить актуальные данные
        //попробую сначала просто сохранить, если не сработает, то придется писать запрос
        socketActualDataRepository.save(actualData);
    }

    private void addCameraData(DataDeviceRequest request){
        CameraActualData actualData = new CameraActualData(request.getPlaceId(), request.getCount(), new Date());
        Optional<CameraActualData> foundData = cameraActualDataRepository.findById(actualData.getPlaceId());
        if(foundData.isPresent()){
            CameraDataArchive dataArchive = new CameraDataArchive();
            dataArchive.setPlaceId(foundData.get().getPlaceId());
            dataArchive.setCount(foundData.get().getCount());
            dataArchive.setCurrTimestamp(foundData.get().getCurrTimestamp());
            cameraDataArchiveRepository.save(dataArchive);
        }
        cameraActualDataRepository.save(actualData);
    }
}