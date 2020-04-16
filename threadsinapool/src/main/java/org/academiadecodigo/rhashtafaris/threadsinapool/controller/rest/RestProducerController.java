package org.academiadecodigo.rhashtafaris.threadsinapool.controller.rest;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter.*;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.EventDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.ProducerDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.ProducerService;
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
@RequestMapping("/api/producer")
public class RestProducerController {

    private ProducerService producerService;
    private ProducerToProducerDto producerToProducerDto;
    private ProducerDtoToProducer producerDtoToProducer;
    private EventDtoToEvent eventDtoToEvent;
    private EventToEventDto eventToEventDto;
    private TicketToTicketDto ticketToTicketDto;


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

    @GetMapping("/event/{id}/list")
    public ResponseEntity<?> getTicketsByEventId (@PathVariable Integer id){
        try {
            return new ResponseEntity<List<TicketDto>>(
                    ticketToTicketDto.convert(producerService.getTicketsByEventId(id))
                    ,HttpStatus.OK);
        } catch (NotFoundEx notFoundEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("")
    public ResponseEntity<?> createProducer(
            @Valid @RequestBody ProducerDto producerDto,
            BindingResult bindingResult,
            UriComponentsBuilder uriBuilder) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Producer producer = producerService.save(producerDtoToProducer.convert(producerDto));
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uriBuilder.path("/api/customer/" + producer.getId()).build().toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createProducerEvent(
            @PathVariable Integer id,
            @Valid @RequestBody EventDto eventDto,
            BindingResult bindingResult,
            UriComponentsBuilder uriBuilder) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Event event = producerService.saveEventOnProducer(eventDtoToEvent.convert(eventDto),producerService.getById(id));

        HttpHeaders header = new HttpHeaders();
        header.setLocation(uriBuilder.path("/api/customer/" + event.getId()).build().toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
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

    @Autowired
    public void setTicketToTicketDto(TicketToTicketDto ticketToTicketDto) {
        this.ticketToTicketDto = ticketToTicketDto;
    }
}
