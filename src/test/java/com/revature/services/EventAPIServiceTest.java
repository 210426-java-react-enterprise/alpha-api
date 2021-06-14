package com.revature.services; 

import com.revature.models.Event;
import com.revature.models.User;
import com.revature.repos.EventRepository;
import org.jetbrains.annotations.NotNull;

import static com.sun.tools.doclint.Entity.times;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.postgresql.hostchooser.HostRequirement.any;

/** 
* EventAPIService Tester. 
* 
* @author Nicholas Recino
* @since Jun 13, 2021
* @version 1.0 
*/

public class EventAPIServiceTest {

    @InjectMocks
    EventAPIService sut;

    @Mock
    EventRepository mockEventRepository;

    Event Event = new Event();


@Before
public void before() throws Exception {
    openMocks(this);
} 

@After
public void after() throws Exception {
    sut = null;
    mockEventRepository = null;
} 


@Test
public void testGetEventsWithValidLongAndLat() throws Exception {
//TODO: Test goes here...
    assertTrue(sut.getEvents(40.712,-74.006).size() > 0);

} 


@Test
public void testGetEventWithInvalidEvent() throws Exception {
//TODO: Test goes here...
    Event event = sut.getEvent("fgfd");
    assertNull(event.getEvent_url());
}
@Test
public void testGetEventWithValidEvent() throws Exception {
//TODO: Test goes here...
        Event event = sut.getEvent("721901");
        System.out.println(event);
        assertTrue(event.getEvent_id() == 721901);
    }


@Test
public void testGetUserEventsWithNullUser() throws Exception {
//TODO: Test goes here...
    User user = new User();
    assertTrue(sut.getUserEvents(user).size() == 0);

}
@Test
public void testGetUserEventsWithValidUser() throws Exception {
    User user = new User();
    sut.getUserEvents(new User(1,"password","fname","email@gmail.com"));
    verify(mockEventRepository,times(1)).getEventByUserId(1);
    }

@Test
public void testSaveEvent() throws Exception {
//TODO: Test goes here...
    Event event = new Event();
    sut.saveEvent(event);
    verify(mockEventRepository,times(1)).save(event);


} 


} 
