package github.denisspec989.azsservice.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@DynamicUpdate
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(unique = true)
    private String name;

    private Long size;
    private byte[] fileBytes;
}
