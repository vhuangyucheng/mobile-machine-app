package com.solar4america.api.service;

import com.solar4america.api.ITicket;
import com.solar4america.entity.TicketDO;
import com.solar4america.mapper.TicketMapper;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TicketService implements ITicket {
    public static final String ACCOUNT_SID = "ACc5798627c5fe7e575726a5df887aa697";
    public static final String AUTH_TOKEN = "bbd123f88f145950818c5dc247f91514";

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public void addTicket(TicketDO ticketDO) {
        TwilioRestClient client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build();
        Message message = Message.creator(
                new PhoneNumber("+19168828161"),  // To number
                new PhoneNumber("+19166193779"),  // From number
                ticketDO.getMachineId().toString() + "  " + ticketDO.getTicketType() + "  " + ticketDO.getTicketDescription()       // SMS body
        ).create(client);

        System.out.println(message.getSid());
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
