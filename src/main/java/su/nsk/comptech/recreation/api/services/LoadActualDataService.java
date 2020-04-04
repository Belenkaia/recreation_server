package su.nsk.comptech.recreation.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.nsk.comptech.recreation.api.Drawer.DrawerArea;
import su.nsk.comptech.recreation.api.entities.CameraDataArchive;
import su.nsk.comptech.recreation.api.entities.SocketDataArchive;
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
        List<SocketDataArchive> socketDataList = socketRepository.actualizeData();

        for (SocketDataArchive rec : socketDataList) {
            for (DrawerArea area : areas) {
                if (rec.getPlaceId() == Integer.parseInt(area.getAreaName())) {
                    area.setPercentage(rec.getCount()*25); // TODO: allow to add >4 sockets
                }
            }
        }

        List<CameraDataArchive> cameraDataList = cameraRepository.actualizeData();

        for (CameraDataArchive rec : cameraDataList) {
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
