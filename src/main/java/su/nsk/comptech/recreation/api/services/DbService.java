package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.dto.DataRequest;
import su.nsk.comptech.recreation.api.entities.SocketData;

@Service
@RequiredArgsConstructor
public class DbService {

    //private final SocketRepository repository;

    public int add(DataRequest request) {
        SocketData socketData = new SocketData();
        socketData.setDeviceId(request.getDeviceId());
        socketData.setPlaceId(request.getPlaceId());
        socketData.setCountPerson(request.getCountPerson());
        //repository.save(socket);
        return request.getPlaceId();
    }
}
