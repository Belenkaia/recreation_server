package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import su.nsk.comptech.recreation.api.entities.CameraActualData;
import su.nsk.comptech.recreation.api.entities.CameraDataArchive;

import java.util.List;
import java.util.Optional;

public interface CameraActualDataRepository extends CrudRepository<CameraActualData, Long> {
    @Query(value = "select ** from CameraData where cast(placeId as text) like '4%' " +
            "And id in (Select max(id) from CameraData Group by placeId) " +
            "order by placeId, currTimestamp desc",
            nativeQuery = true)
    List<CameraDataArchive> actualizeData();
}
