package rekeningrijden.fr.rekeningrijdersregistratie.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;

import java.util.Date;
import java.util.List;

public interface IStepRepository extends PagingAndSortingRepository<Step, Long>
{
    @Query("SELECT s FROM Step s WHERE s.timestamp >= :start AND s.timestamp <= :end ORDER BY s.trackerId DESC")
    List<Step> getStepsByDate(@Param("start") Date start, @Param("end") Date end, Pageable pageable);

    @Query("SELECT s FROM Step s WHERE s.trackerId = :tracker AND s.timestamp >= :start AND s.timestamp <= :end ORDER BY s.trackerId DESC")
    List<Step> getStepsByTracker(@Param("tracker") String tracker,  @Param("start") Date start, @Param("end") Date end, Pageable pageable);

    @Query("SELECT * FROM registratie.step WHERE tracker_id = :tracker ORDER BY timestamp DESC LIMIT 1")
    Step getLatestStepByTracker(@Param("tracker") String tracker);
}
