package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import su.nsk.comptech.recreation.api.entities.SocketActualData;

@Repository
public interface SocketActualDataRepository extends CrudRepository<SocketActualData,Long> {
}
