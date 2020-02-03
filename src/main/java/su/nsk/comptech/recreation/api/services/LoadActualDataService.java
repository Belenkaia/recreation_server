package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.Drawer.DrawerArea;
import su.nsk.comptech.recreation.api.entities.CameraData;
import su.nsk.comptech.recreation.api.entities.SocketData;
import su.nsk.comptech.recreation.api.repositories.CameraRepository;
import su.nsk.comptech.recreation.api.repositories.SocketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadActualDataService {

    @Autowired
    private final SocketRepository socketRepository;
    @Autowired
    private final CameraRepository cameraRepository;

    public void loadActualData(List<DrawerArea> areas) {
        List<SocketData> socketDataList = socketRepository.actualizeData();

        for (SocketData rec : socketDataList) {
            for (DrawerArea area : areas) {
                if (rec.getPlaceId() == Integer.parseInt(area.getAreaName())) {
                    area.setPercentage(rec.getCountSocket()*25); // TODO: allow to add >4 sockets
                }
            }
        }

        List<CameraData> cameraDataList = cameraRepository.actualizeData();

        for (CameraData rec : cameraDataList) {
            for (DrawerArea area : areas) {
                if (rec.getPlaceId() == Integer.parseInt(area.getAreaName())) {
                    int personFound = rec.getCount();
                    if (personFound > 10)
                        area.setPercentage(100);
                    else
                        area.setPercentage(personFound*10); // TODO: allow > 10 persons
                }
            }
        }
    }
}
