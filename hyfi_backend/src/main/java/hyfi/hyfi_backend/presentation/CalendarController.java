package hyfi.hyfi_backend.presentation;

import hyfi.hyfi_backend.application.CalendarService;
import hyfi.hyfi_backend.application.dto.CalendarUpdateRequestDto;
import hyfi.hyfi_backend.domain.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping("/join")
    public Long join(@RequestBody Calendar calendar) {
        Long calendarIdx = calendarService.join(calendar);
        return calendarIdx;
    }

    @GetMapping("/all")
    public List<Calendar> getCalendarList() {
        return calendarService.findCalendar();
    }

    //사용자별 캘린더 목록 조회
    @GetMapping("/{userIdx}")
    public List<Calendar> getCalendarByUserIdx(@PathVariable Long userIdx) {
        return calendarService.findByUserIdx(userIdx);
    }

    //캘린더 단건 조회
    @GetMapping("/{calendarIdx}")
    public Calendar getCalendarByIdx(@PathVariable Long calendarIdx) {
        return calendarService.findOne(calendarIdx);
    }

    //캘린더 정보 업데이트
    @PutMapping("/{calendarIdx}")
    public Long update(@PathVariable Long calendarIdx, @RequestBody CalendarUpdateRequestDto calendarUpdateRequestDto) {
        return calendarService.update(calendarIdx, calendarUpdateRequestDto);
    }
}
