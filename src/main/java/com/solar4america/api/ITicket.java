package com.solar4america.api;

import com.solar4america.entity.TicketDO;

import java.util.List;

public interface ITicket {
    public void addTicket(TicketDO ticketDO);
    public void removeTicket(TicketDO ticketDO );
    public TicketDO getTicket(TicketDO ticketDO);
}
