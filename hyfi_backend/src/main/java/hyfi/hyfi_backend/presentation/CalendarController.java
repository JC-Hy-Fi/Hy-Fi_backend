package hyfi.hyfi_backend.presentation;

import hyfi.hyfi_backend.application.CalendarService;
import hyfi.hyfi_backend.application.dto.CalendarUpdateRequestDto;
import hyfi.hyfi_backend.domain.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    //캘린더 저장
    @PostMapping("/join")
    public Long join(@RequestBody Calendar calendar) {
        Long calendarIdx = calendarService.join(calendar);
        return calendarIdx;
    }

    //캘린더 전체 정보 조회
    @GetMapping("/all")
    public List<Calendar> getCalendarList() {
        return calendarService.findCalendars();
    }

    //사용자별 캘린더 목록 조회
    @GetMapping("/findbyUser/{userIdx}")
    public List<Calendar> getCalendarByUserIdx(@PathVariable Long userIdx) {
        return calendarService.findByUserIdx(userIdx);
    }

    //캘린더 단건 조회
    @GetMapping("/findbyCalendar/{calendarIdx}")
    public Optional<Calendar> getCalendarByIdx(@PathVariable Long calendarIdx) {
        return calendarService.findOne(calendarIdx);
    }

    //캘린더 정보 업데이트
    @PutMapping("/{calendarIdx}/edit")
    public Calendar update(@PathVariable Long calendarIdx, @RequestBody CalendarUpdateRequestDto calendarUpdateRequestDto) {
        return calendarService.update(calendarIdx, calendarUpdateRequestDto);
    }

    //캘린더 정보 삭제
    @DeleteMapping("{calendarIdx}/delete")
    public Calendar delete(@PathVariable Long calendarIdx) {
        return calendarService.delete(calendarIdx);
    }
}
