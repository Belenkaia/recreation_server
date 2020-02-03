package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.dto.DataDeviceRequest;
import su.nsk.comptech.recreation.api.entities.CameraData;
import su.nsk.comptech.recreation.api.entities.SocketData;
import su.nsk.comptech.recreation.api.repositories.CameraRepository;
import su.nsk.comptech.recreation.api.repositories.SocketRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final SocketRepository socketRepository;
    @Autowired
    private final CameraRepository cameraRepository;

    public void add(DataDeviceRequest request) {
        if (request.getDeviceId() == 1) {
            addSocketData(request);
        }
        if(request.getDeviceId() == 0) {
            addCameraData(request);
        }
    }

    private void addSocketData(DataDeviceRequest request) {
        SocketData socketData = new SocketData();
        socketData.setPlaceId(request.getPlaceId());
        socketData.setCountSocket(request.getCount());
        socketData.setCurrTimestamp(new Date());
        socketRepository.save(socketData);
    }

    private void addCameraData(DataDeviceRequest request){
        CameraData cameraData = new CameraData();
        cameraData.setPlaceId(request.getPlaceId());
        cameraData.setCount(request.getCount());
        cameraData.setCurrTimestamp(new Date());
        cameraRepository.save(cameraData);
    }
}