package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 관리하는 객체
@Table // 엔티티와 매핑할 테이블 지정
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(name = "name")
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
