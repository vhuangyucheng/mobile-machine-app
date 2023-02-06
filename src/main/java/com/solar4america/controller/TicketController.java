package com.solar4america.controller;

import com.solar4america.api.ITicket;
import com.solar4america.entity.TicketDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    ITicket ITicket;

    @PostMapping("/insertTicket")
    public String insertTicket(TicketDO ticketDO, @RequestParam("file") MultipartFile file) {
//    public String insertTicket(@RequestBody TicketDO ticketDO) {

        // 获取文件名
        String fileName = file.getOriginalFilename();
//        String filePath = "C:\\Users\\jhuang\\WebstormProjects\\vue-test-app1\\vue-test-app\\public\\";
        String filePath = "D:\\webstormworkspace\\vue-test-app\\public\\";

        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件上传失败");
        }
        ticketDO.setTicketImg(fileName);
        ITicket.addTicket(ticketDO);
        return "ok";
    }

    @PostMapping("/updateTicket")
    public TicketDO updateTicket(TicketDO ticketDO, @RequestParam("file") MultipartFile file) {
//    public String insertTicket(@RequestBody TicketDO ticketDO) {

        // 获取文件名
        String fileName = file.getOriginalFilename();
//        String filePath = "C:\\Users\\jhuang\\WebstormProjects\\vue-test-app1\\vue-test-app\\public\\";
        String filePath = "D:\\webstormworkspace\\vue-test-app\\public\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件上传失败");
        }
        ticketDO.setTicketImg2(fileName);
        ITicket.removeTicket(ticketDO);
        return ITicket.getTicket(ticketDO);
    }

    @PostMapping("/reopenTicket")
    public String reopenTicket(@RequestBody TicketDO ticketDO) {
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