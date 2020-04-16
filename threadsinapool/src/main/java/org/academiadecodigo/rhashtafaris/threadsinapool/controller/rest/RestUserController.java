package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.TicketToTicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.UserToUserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.UserNotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserToUserDto userToUserDto;
    private TicketToTicketDto ticketToTicketDto;
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> userList(){
        return new ResponseEntity<List<UserDto>>(userToUserDto.convert(userService.listAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<?> userTicketList(@PathVariable Integer id){

        try {
            return new ResponseEntity<List<TicketDto>>(
                    ticketToTicketDto.convert(userService.getById(id).getUserTickets()),
                    HttpStatus.OK);
        } catch (UserNotFoundEx userNotFoundEx) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userById(@PathVariable Integer id){

        try {
            return new ResponseEntity<UserDto>(userToUserDto.convert(userService.getById(id)),HttpStatus.OK);
        } catch (UserNotFoundEx userNotFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username")
    public ResponseEntity<?> userByUsername(@RequestBody UserDto userDto){

        try {
            return new ResponseEntity<UserDto>(userToUserDto.convert(userService.getByName(userDto.getUsername())),HttpStatus.OK);
        } catch (UserNotFoundEx userNotFoundEx) {
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
}
