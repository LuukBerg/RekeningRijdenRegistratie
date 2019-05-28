package rekeningrijden.fr.rekeningrijdersregistratie.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Movement;

public interface IMovementRepository extends PagingAndSortingRepository<Movement, Long>
{
    @Query("SELECT m FROM Movement m WHERE m.cartracker = :trackerId AND m.active = true")
    Movement getByCartrackeraAndActive(@Param("trackerId") String trackerId);
}
