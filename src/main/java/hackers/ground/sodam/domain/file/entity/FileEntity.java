package hackers.ground.sodam.domain.file.entity;

import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_file")
@DynamicUpdate
@AllArgsConstructor
public class FileEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_url")
    private String fileUrl;

//    @ManyToOne
//    @JoinColumn(name = "board_id")
//    private BoardEntity board;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "member_id")
    private UserEntity member;

}
