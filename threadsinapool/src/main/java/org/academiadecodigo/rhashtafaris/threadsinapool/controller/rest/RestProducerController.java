package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.*;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.EventDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.ProducerDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producer")
public class RestProducerController {

    private ProducerService producerService;
    private ProducerToProducerDto producerToProducerDto;
    private ProducerDtoToProducer producerDtoToProducer;
    private EventDtoToEvent eventDtoToEvent;
    private EventToEventDto eventToEventDto;


    @GetMapping("/list")
    public ResponseEntity<List<ProducerDto>> userList() {
        return new ResponseEntity<List<ProducerDto>>(producerToProducerDto.convert(producerService.listProducers()),HttpStatus.OK);
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<?> producerEventList(@PathVariable Integer id) {

        try {
            return new ResponseEntity<List<EventDto>>(
                    eventToEventDto.convert(producerService.listAllEventsFromProducer(id)),
                    HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> producerById(@PathVariable Integer id) {

        try {
            return new ResponseEntity<ProducerDto>(
                    producerToProducerDto.convert(producerService.getById(id)),
                    HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<?> eventById(@PathVariable Integer id){

        try {
            return new ResponseEntity<EventDto>(
                    eventToEventDto.convert(producerService.getEventById(id)),
                    HttpStatus.OK
            ) ;
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @Autowired
    public void setProducerDtoToProducer(ProducerDtoToProducer producerDtoToProducer) {
        this.producerDtoToProducer = producerDtoToProducer;
    }

    @Autowired
    public void setProducerToProducerDto(ProducerToProducerDto producerToProducerDto) {
        this.producerToProducerDto = producerToProducerDto;
    }

    @Autowired
    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Autowired
    public void setEventDtoToEvent(EventDtoToEvent eventDtoToEvent) {
        this.eventDtoToEvent = eventDtoToEvent;
    }

    @Autowired
    public void setEventToEventDto(EventToEventDto eventToEventDto) {
        this.eventToEventDto = eventToEventDto;
    }
}
