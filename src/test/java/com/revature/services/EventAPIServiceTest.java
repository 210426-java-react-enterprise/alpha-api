package com.revature.services; 

import com.revature.repos.EventRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

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
public void testGetEvents() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testGetEvent() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testGetUserEvents() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testSaveEvent() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testEventProcess() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = EventAPIService.getClass().getMethod("eventProcess", Event.class, LinkedHashMap<String,.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
