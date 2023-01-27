package com.solar4america.api.service;

import com.solar4america.api.ITicket;
import com.solar4america.entity.TicketDO;
import com.solar4america.mapper.TicketMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class TicketService implements ITicket {
    @Autowired
    private TicketMapper ticketMapper;
    @Override
    public void addTicket(TicketDO ticketDO) {
        ticketMapper.insert(ticketDO);
    }

    @Override
    public void removeTicket(TicketDO ticketDO) {
        ticketMapper.updateById(ticketDO);
    }

    @Override
    public TicketDO getTicket(TicketDO ticketDO) {
        TicketDO ticketDO1 = ticketMapper.selectById(ticketDO.getTicketId());
        return ticketDO1;
    }


}
