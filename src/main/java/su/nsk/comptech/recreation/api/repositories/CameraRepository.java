package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import su.nsk.comptech.recreation.api.entities.CameraData;

import java.util.List;

public interface CameraRepository extends CrudRepository<CameraData, Long> {
    @Query(value = "select ** from CameraData where cast(placeId as text) like '4%' " +
            "And id in (Select max(id) from CameraData Group by placeId) " +
            "order by placeId, currTimestamp desc",
            nativeQuery = true)
    List<CameraData> actualizeData();
}
