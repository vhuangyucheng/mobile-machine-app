package com.solar4america.controller;

import com.solar4america.QO.GetTicketListQO;
import com.solar4america.QO.MachineQO;
import com.solar4america.VO.ListWrapper;
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
    public ListWrapper<MachineVO> listMachine(@RequestBody MachineQO machineQO) {
        ListWrapper<MachineVO> machineVOListWrapper = new ListWrapper<>();
        machineVOListWrapper.setPageName("机器列表");
        machineVOListWrapper.setList(machineApi.listMachine(machineQO.getStatus()));
        return machineVOListWrapper;
    }

//0全部，1未关闭，2关闭
    @PostMapping("/listTicket")
    public ListWrapper<TicketDO> listTicket(@RequestBody GetTicketListQO getTicketListQO) {
        ListWrapper<TicketDO> TicketDOListWrapper = new ListWrapper<>();
        TicketDOListWrapper.setPageName("工单列表");
        TicketDOListWrapper.setList(machineApi.listTicket(getTicketListQO.getStatus(), getTicketListQO.getMachineId()));
        return TicketDOListWrapper;
    }

    @PostMapping("/test")
    public String listMachine() {
        return "test";
    }
}
