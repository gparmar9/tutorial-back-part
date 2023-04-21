package com.ccsw.tutorial.lending;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.exceptions.GameUsed;
import com.ccsw.tutorial.exceptions.MaxLendings;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.lending.model.Lending;
import com.ccsw.tutorial.lending.model.LendingDto;
import com.ccsw.tutorial.lending.model.LendingSearchDto;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
public class LendingServiceImpl implements LendingService {

    @Autowired
    LendingRepository lendingRepository;

    @Autowired
    GameService gameService;

    @Autowired
    ClientService clientService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Lending> findPage(LendingSearchDto dto, Long idGame, Long idClient, Date newDate) {

        return this.lendingRepository.find(dto.getPageable(), idGame, idClient, newDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, LendingDto dto) {

        Long idGame = dto.getGame().getId();
        Long idClient = dto.getClient().getId();

        Date bDate = dto.getBeginDate();
        Date eDate = dto.getEndDate();

        if (!this.lendingRepository.findGames(idGame, bDate, eDate).isEmpty()) {
            throw new GameUsed("Error: El juego ya está prestado");
        }

        else if (this.lendingRepository.findClients(idClient, bDate, eDate).size() > 1) {
            throw new MaxLendings("Error: El cliente ha alcanzado el límite de préstamos");
        }

        else {
            System.out.print(this.lendingRepository.findGames(idGame, bDate, eDate).isEmpty());
            System.out.print(this.lendingRepository.findClients(idGame, bDate, eDate).size());

            Lending lending = null;

            if (id == null)
                lending = new Lending();
            else
                lending = this.lendingRepository.findById(id).orElse(null);

            BeanUtils.copyProperties(dto, lending, "id", "game", "client");

            lending.setGame(gameService.get(dto.getGame().getId()));
            lending.setClient(clientService.get(dto.getClient().getId()));

            this.lendingRepository.save(lending);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.lendingRepository.deleteById(id);

    }
}