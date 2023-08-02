package hyfi.hyfi_backend.domain.repository;

import hyfi.hyfi_backend.domain.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CalendarRepository {

    private final EntityManager em;

    public void save(Calendar calendar) {
        em.persist(calendar);
    }

    public Optional<Calendar> findOne(Long calendaridx) {
        return Optional.ofNullable(em.find(Calendar.class, calendaridx));
    }

    public List<Calendar> findByUserIdx(Long userIdx) {
        return em.createQuery("select c from Calendar c where c.userIdx = :userIdx", Calendar.class)
                .setParameter("userIdx", userIdx)
                .getResultList();
    }


    public List<Calendar> findAll(){
        return em.createQuery("select c from Calendar c", Calendar.class)
                .getResultList();
    }

}
