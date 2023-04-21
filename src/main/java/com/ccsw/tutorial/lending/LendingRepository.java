package com.ccsw.tutorial.lending;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.lending.model.Lending;

public interface LendingRepository extends CrudRepository<Lending, Long> {

    // Query para recuperar un préstamo filtrado
    @Query("select l from Lending l where (:idClient is null or l.client.id =:idClient) and (:idGame is null or l.game.id = :idGame) and (:newDate is null or (l.beginDate <= :newDate and l.endDate >= :newDate))")
    Page<Lending> find(Pageable pageable, @Param("idGame") Long idGame, @Param("idClient") Long idClient,
            @Param("newDate") Date new_date);

    // Query para recuperar un juego entre las fechas establecidas
    @Query("select l from Lending l where l.game.id = :idGame and (l.beginDate <= :eDate and l.endDate >= :bDate)")
    public List<Lending> findGames(@Param("idGame") Long idGame, @Param("bDate") Date bDate,
            @Param("eDate") Date eDate);

    // Query para recuperar un cliente entre las fechas establecidas
    @Query("select l from Lending l where l.client.id = :idClient and (l.beginDate <= :eDate and l.endDate >= :bDate)")
    public List<Lending> findClients(@Param("idClient") Long idClient, @Param("bDate") Date bDate,
            @Param("eDate") Date eDate);
}