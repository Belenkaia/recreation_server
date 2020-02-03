package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import su.nsk.comptech.recreation.api.entities.SocketData;

import java.util.List;

@Repository
public interface SocketRepository extends CrudRepository<SocketData,Long> {

    @Query(value = "select ** from SocketData where cast(placeId as text) like '4%' " +
            "And id in (Select max(id) from SocketData Group by placeId) " +
            "order by placeId, currTimestamp desc",
    nativeQuery = true)
    List<SocketData> actualizeData();
}
