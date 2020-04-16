package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketToTicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class RestTicketController {

    private TicketToTicketDto ticketToTicketDto;
    private TicketService ticketService;

    @GetMapping("/list")
    public ResponseEntity<List<TicketDto>> listTickets(){
        return new ResponseEntity<List<TicketDto>>(ticketToTicketDto.convert(ticketService.listAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> gitById(@PathVariable Integer id){
        try {
            return new ResponseEntity<TicketDto>(ticketToTicketDto.convert(ticketService.getById(id)),HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }
}
