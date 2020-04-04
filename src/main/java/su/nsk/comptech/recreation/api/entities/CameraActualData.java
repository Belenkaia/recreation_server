package su.nsk.comptech.recreation.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CameraActualData {
    @Id
    @NonNull
    private long placeId;
    @NonNull
    private int count;
    @NonNull
    private Date currTimestamp;
}
