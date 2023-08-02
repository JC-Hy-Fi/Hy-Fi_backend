package hyfi.hyfi_backend.application;

import hyfi.hyfi_backend.application.dto.CalendarUpdateRequestDto;
import hyfi.hyfi_backend.domain.Calendar;
import hyfi.hyfi_backend.domain.repository.CalendarRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;

    @Transactional
    public Long join(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar.getUserIdx();
    }

    /**
     */
    public List<Calendar> findCalendar() {
        return calendarRepository.findAll();
    }

    public Calendar findOne(Long calendarIdx) {
        return calendarRepository.findOne(calendarIdx);
    }

    public List<Calendar> findByUserIdx(Long userIdx) {
        return calendarRepository.findByUserIdx(userIdx);
    }

    @Transactional
    public void update(Long id, CalendarUpdateRequestDto requestDto) {
        Calendar calendar = calendarRepository.findOne(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 캘린더 정보가 존재하지 않습니다."));
        calendarRepository.up
    }
}