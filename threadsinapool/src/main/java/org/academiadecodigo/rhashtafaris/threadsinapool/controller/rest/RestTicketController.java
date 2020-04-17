package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketDtoToTicket;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketToTicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.TicketService;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class RestTicketController {

    private TicketToTicketDto ticketToTicketDto;
    private TicketDtoToTicket ticketDtoToTicket;
    private TicketService ticketService;
    private UserService userService;

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

    @PutMapping("/trade")
    public ResponseEntity<?> tradeTickets(@RequestBody TicketDto ticket1, @RequestBody TicketDto ticket2){

        try {
            ticketService.ticketTrade(ticketDtoToTicket.convert(ticket1),ticketDtoToTicket.convert(ticket2));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/match")
    public ResponseEntity<?> tradeTickets(@RequestBody UserDto userDto, @RequestBody TicketDto ticketDto){

        try {
            userService.matchTicket(userDto.getId(),ticketDtoToTicket.convert(ticketDto));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {

        try {
            ticketService.delete(ticketService.getById(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @Autowired
    public void setTicketDtoToTicket(TicketDtoToTicket ticketDtoToTicket) {
        this.ticketDtoToTicket = ticketDtoToTicket;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
