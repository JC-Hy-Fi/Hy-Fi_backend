package hyfi.hyfi_backend.application.dto;

import hyfi.hyfi_backend.domain.ScheduleType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CalendarUpdateRequestDto {
    private String title;
    private String memo;
    private LocalDate start;
    private LocalDate end;
    private ScheduleType type;
}
