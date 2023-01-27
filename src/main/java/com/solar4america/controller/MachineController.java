package com.solar4america.controller;

import com.solar4america.QO.GetTicketListQO;
import com.solar4america.QO.MachineQO;
import com.solar4america.VO.MachineVO;
import com.solar4america.api.IMachine;
import com.solar4america.entity.TicketDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/machines")
public class MachineController {
    @Autowired
    IMachine machineApi;
//0全部，1坏的
    @PostMapping("/listMachine")
    public List<MachineVO> listMachine(@RequestBody MachineQO machineQO) {
        return machineApi.listMachine(machineQO.getStatus());
    }

//
    @PostMapping("/listTicket")
    public List<TicketDO> listTicket(@RequestBody GetTicketListQO getTicketListQO) {
        return machineApi.listTicket(getTicketListQO.getStatus(), getTicketListQO.getMachineId());
    }

    @PostMapping("/test")
    public String listMachine() {
        return "test";
    }
}