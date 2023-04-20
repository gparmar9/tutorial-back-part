package com.ccsw.tutorial.lending;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.lending.model.Lending;
import com.ccsw.tutorial.lending.model.LendingDto;
import com.ccsw.tutorial.lending.model.LendingSearchDto;

@RequestMapping(value = "/lending")
@RestController
@CrossOrigin(origins = "*")
public class LendingController {

    @Autowired
    LendingService lendingService;

    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Lending}
     * 
     * @param dto
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LendingDto> findPage(@RequestParam(value = "idGame", required = false) Long idGame,
            @RequestParam(value = "idClient", required = false) Long idClient,
            @RequestParam(value = "newDate", required = false) Date newDate, @RequestBody LendingSearchDto dto) {

        Page<Lending> lendings = this.lendingService.findPage(dto, idGame, idClient, newDate);

        return this.beanMapper.mapPage(lendings, LendingDto.class);
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Lending}
     * 
     * @param id
     * @param data datos de la entidad
     */
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LendingDto dto) {

        this.lendingService.save(id, dto);
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Lending}
     * 
     * @param id PK de la entidad
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.lendingService.delete(id);
    }
}
