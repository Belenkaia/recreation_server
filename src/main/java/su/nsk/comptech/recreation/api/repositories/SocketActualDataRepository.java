package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import su.nsk.comptech.recreation.api.entities.SocketActualData;
import su.nsk.comptech.recreation.api.entities.SocketDataArchive;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocketActualDataRepository extends CrudRepository<SocketActualData,Long> {

    @Query(value = "select ** from SocketData where cast(placeId as text) like '4%' " +
            "And id in (Select max(id) from SocketData Group by placeId) " +
            "order by placeId, currTimestamp desc",
    nativeQuery = true)
    List<SocketDataArchive> actualizeData();
}
