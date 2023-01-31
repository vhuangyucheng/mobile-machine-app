package com.solar4america.controller;

import com.solar4america.api.ITicket;
import com.solar4america.entity.TicketDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    ITicket ITicket;

    @PostMapping("/insertTicket")
//    public String insertTicket(TicketDO ticketDO, @RequestParam("file") MultipartFile file) {
    public String insertTicket(@RequestBody TicketDO ticketDO) {
        ITicket.addTicket(ticketDO);
        return "ok";
    }


    @PostMapping("/updateTicket")
    public String updateTicket(@RequestBody TicketDO ticketDO) {
        ITicket.removeTicket(ticketDO);
        return "ok";
    }

    @PostMapping("/getTicket")
    public TicketDO getTicket(@RequestBody TicketDO ticketDO) {
        return ITicket.getTicket(ticketDO);
    }

    @PostMapping("/test")
    public String listMachine() {
        return "test";
    }
}