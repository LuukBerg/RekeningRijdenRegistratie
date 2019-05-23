package rekeningrijden.fr.rekeningrijdersregistratie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;

import java.util.Date;
import java.util.List;

public interface IStepRepository extends PagingAndSortingRepository<Step, Long> {

    @Query("SELECT s FROM Step s WHERE s.timestamp BETWEEN :start AND :end")
    List<Step> getStepsByDate(@Param("start") long start, @Param("end") long end, Pageable pageable);

}
