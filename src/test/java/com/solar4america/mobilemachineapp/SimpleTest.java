package com.solar4america.mobilemachineapp;

import com.solar4america.entity.MachineDO;
import java.net.URI;
import java.net.URISyntaxException;

import com.solar4america.mapper.MachineMapper;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private MachineMapper machineMapper;

    public static final String ACCOUNT_SID = "ACc5798627c5fe7e575726a5df887aa697";
    public static final String AUTH_TOKEN = "bbd123f88f145950818c5dc247f91514";


    @Test
    public void testSelect() {
        TwilioRestClient client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build();
        Message message = Message.creator(
                new PhoneNumber("+19168828161"),  // To number
                new PhoneNumber("+19166193779"),  // From number
                "Hello world!"                    // SMS body
        ).create(client);

        System.out.println(message.getSid());
    }

}