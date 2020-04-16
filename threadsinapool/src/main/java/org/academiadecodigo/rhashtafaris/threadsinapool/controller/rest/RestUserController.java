package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketDtoToTicket;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketToTicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.UserDtoToUser;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.UserToUserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;
    private TicketToTicketDto ticketToTicketDto;
    private TicketDtoToTicket ticketDtoToTicket;
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> userList() {
        return new ResponseEntity<List<UserDto>>(userToUserDto.convert(userService.listAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<?> userTicketList(@PathVariable Integer id) {

        try {
            return new ResponseEntity<List<TicketDto>>(
                    ticketToTicketDto.convert(userService.getById(id).getUserTickets()),
                    HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userById(@PathVariable Integer id) {

        try {
            return new ResponseEntity<UserDto>(userToUserDto.convert(userService.getById(id)), HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username")
    public ResponseEntity<?> userByUsername(@RequestBody UserDto userDto) {

        try {
            return new ResponseEntity<UserDto>(userToUserDto.convert(userService.getByName(userDto.getUsername())), HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserDto userDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userService.exists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

            User user = userService.save(userDtoToUser.convert(userDto));
            return new ResponseEntity<UserDto>(userToUserDto.convert(user), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserDto userDto,
            BindingResult bindingResult,
            UriComponentsBuilder uriBuilder) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.save(userDtoToUser.convert(userDto));
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uriBuilder.path("/api/user/" + user.getId()).build().toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createTicket(
            @PathVariable Integer id,
            @Valid @RequestBody TicketDto ticketDto,
            BindingResult bindingResult,
            UriComponentsBuilder uriBuilder) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Ticket ticket = userService.addTicket(ticketDtoToTicket.convert(ticketDto), userService.getById(id));
            HttpHeaders header = new HttpHeaders();
            header.setLocation(uriBuilder.path("/api/user/" + ticket.getId()).build().toUri());
            return new ResponseEntity<>(header, HttpStatus.CREATED);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setTicketDtoToTicket(TicketDtoToTicket ticketDtoToTicket) {
        this.ticketDtoToTicket = ticketDtoToTicket;
    }
}
