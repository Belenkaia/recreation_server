package su.nsk.comptech.recreation.api.repositories;

import org.springframework.data.repository.CrudRepository;
import su.nsk.comptech.recreation.api.entities.CameraData;

public interface CameraRepository extends CrudRepository<CameraData, Long> {
}
