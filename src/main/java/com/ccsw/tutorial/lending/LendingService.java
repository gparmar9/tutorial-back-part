package com.ccsw.tutorial.lending;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.lending.model.Lending;
import com.ccsw.tutorial.lending.model.LendingDto;
import com.ccsw.tutorial.lending.model.LendingSearchDto;

public interface LendingService {

    /**
     * Método para recuperar todas los Lending
     * 
     * @return
     */
    Page<Lending> findPage(LendingSearchDto dto, Long idGame, Long idClient, Date newDate);

    /**
     * Método para crear o actualizar un Lending
     * 
     * @param dto
     * @return
     */
    void save(Long id, LendingDto dto);

    /**
     * Método para borrar una Category
     * 
     * @param id
     */
    void delete(Long id);

}
