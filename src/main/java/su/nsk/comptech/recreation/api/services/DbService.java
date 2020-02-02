package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.dto.DataDeviceRequest;
import su.nsk.comptech.recreation.api.entities.SocketData;
import su.nsk.comptech.recreation.api.repositories.SocketRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final SocketRepository repository;

    public void add(DataDeviceRequest request) {
        if (request.getDeviceId() == 0) {
            addSocketData(request);
        }
        if(request.getDeviceId() == 1) {
            addCameraData(request);
        }
    }

    private void addSocketData(DataDeviceRequest request) {
        SocketData socketData = new SocketData();
        socketData.setPlaceId(request.getPlaceId());
        socketData.setCountSocket(request.getCount());
        socketData.setCurrTimestamp(new Date());
        repository.save(socketData);
    }

    private void addCameraData(DataDeviceRequest request){
        System.out.println("DATAREQUEST");
        System.out.println(request.getDeviceId());
        System.out.println(request.getPlaceId());
        System.out.println(request.getCount());
    }
}