package com.revature.controllers;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.CityStateLocationDTO;
import com.revature.models.Event;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.security.TokenGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EventControllerTest {

    private MockMvc mockMvc;
    private WebApplicationContext webContext;
    private TokenGenerator tokenGenerator;
    SimpleDateFormat jsFormat = new SimpleDateFormat(("EE MMM d y H:m:s 'GMT'Z (zz)"));


    @Autowired
    public EventControllerTest(WebApplicationContext webContext, TokenGenerator tokenGenerator) {
        this.webContext = webContext;
        this.tokenGenerator = tokenGenerator;
    }

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }

    @AfterEach
    public void breakDown() {
        this.mockMvc = null;
    }

    @Test
    public void test_getEventsInHomeTownValidCityAndState() throws Exception{
        User mockAdminUser = new User();
        mockAdminUser.setId(1);
        mockAdminUser.setUsername("seantaba");
        mockAdminUser.setPassword("password");
        mockAdminUser.setRoles(Role.ADMIN);
        String token = tokenGenerator.createJwt(mockAdminUser);

        this.mockMvc.perform(get("/events/hometown").header("Authorization", token))
                .andDo(print())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN + ";charset=ISO8859-1"));

    }

    @Test
    public void test_getEventsBasedOnLocation() throws Exception{

        CityStateLocationDTO mockCity = new CityStateLocationDTO();
        mockCity.setCity("Raleigh");
        mockCity.setState("North Carolina");

        this.mockMvc.perform(post("/events/location").content(asJsonString(mockCity)).contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

    @Test
    public void test_getEventsBasedOnId() throws Exception{

        String eventId = "5295569";
        this.mockMvc.perform(post("/events/id").content(asJsonString(eventId)).contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

    @Test
    public void test_getEventsByUsername() throws Exception{
        User mockAdminUser = new User();
        mockAdminUser.setId(1);
        mockAdminUser.setUsername("seantaba");
        mockAdminUser.setPassword("password");
        mockAdminUser.setRoles(Role.ADMIN);
        String token = tokenGenerator.createJwt(mockAdminUser);

        Event mockEvent = new Event();
        mockEvent.setEvent_url("https://seatgeek.com/phish-tickets/eugene-oregon-matthew-knight-arena-2021-07-13-3-30-am/concert/5295569");
        mockEvent.setEvent_title("testTitle");
        this.mockMvc.perform(get("/events/user").header("Authorization", token))
                .andDo(print())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN + ";charset=ISO8859-1"));

    }

//    @Test (expected = NestedServletException.class)
//    public void test_saveEventByUsername() throws Exception{
//        User mockAdminUser2 = new User();
//        mockAdminUser2.setId(1);
//        mockAdminUser2.setUsername("seantaba");
//        mockAdminUser2.setPassword("password");
//        mockAdminUser2.setRoles(Role.ADMIN);
//        String token = tokenGenerator.createJwt(mockAdminUser2);
//
//        Event mockEvent = new Event();
//        mockEvent.setEvent_url("https://seatgeek.com/phish-tickets/eugene-oregon-matthew-knight-arena-2021-07-13-3-30-am/concert/5295569");
//        mockEvent.setEvent_title("testTitle");
//        this.mockMvc.perform(post("/events/save").content(asJsonString(mockEvent)).contentType(MediaType.APPLICATION_JSON_VALUE).header("Authorization", token))
//                .andDo(print())
//                .andExpect(content().contentType(MediaType.TEXT_PLAIN + ";charset=ISO8859-1"));
//
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
