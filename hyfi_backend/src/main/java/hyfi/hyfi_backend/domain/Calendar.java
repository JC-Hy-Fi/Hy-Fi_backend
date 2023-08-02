package hyfi.hyfi_backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table
@Getter
@Setter
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="calendar_idx")
    private Long calenderIdx;

    /**
     * 사용자에서 OnetoMany 설정해주기
     */
//    @JsonIgnore
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name="user_idx")
    @Column(name="user_idx")
    private Long userIdx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String memo;

    @Column(nullable = false)
    private LocalDate start;

    @Column(nullable = false)
    private LocalDate end;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleType type;
}
