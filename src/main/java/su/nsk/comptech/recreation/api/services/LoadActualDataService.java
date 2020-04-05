package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.Drawer.DrawerArea;
import su.nsk.comptech.recreation.api.entities.CameraActualData;
import su.nsk.comptech.recreation.api.entities.SocketActualData;
import su.nsk.comptech.recreation.api.repositories.CameraActualDataRepository;
import su.nsk.comptech.recreation.api.repositories.SocketActualDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadActualDataService {

    @Autowired
    private final SocketActualDataRepository socketRepository;
    @Autowired
    private final CameraActualDataRepository cameraRepository;

    public void loadActualData(List<DrawerArea> areas) {
        Iterable<SocketActualData> iterableSocket = socketRepository.findAll();
        for (SocketActualData actualData : iterableSocket) {
            for (DrawerArea area : areas) {
                if (actualData.getPlaceId() == Integer.parseInt(area.getAreaName())) {
                    area.setPercentage(actualData.getCount() * 25); // TODO: allow to add >4 sockets
                }
            }
        }

        Iterable<CameraActualData> iterableCamera = cameraRepository.findAll();
        for(CameraActualData actualData: iterableCamera){
            for (DrawerArea area : areas) {
                if (actualData.getPlaceId() == Integer.parseInt(area.getAreaName())) {
                    int personFound = actualData.getCount();
                    if (personFound > 10)
                        area.setPercentage(100);
                    else
                        area.setPercentage(personFound*10); // TODO: allow > 10 persons
                }
            }
        }
    }
}
