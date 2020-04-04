package su.nsk.comptech.recreation.api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class SocketDataArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private long placeId;
    @NonNull
    private int count;
    @NonNull
    private Date currTimestamp;
}
