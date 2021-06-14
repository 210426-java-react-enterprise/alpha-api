package com.revature.services; 

import com.revature.repos.LocationRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

/** 
* LocationService Tester. 
* 
* @author Nicholas Recino
* @since Jun 13, 2021
* @version 1.0 
*/ 
public class LocationServiceTest {

    @InjectMocks
    LocationService sut;

    @Mock
    LocationRepository mockLocationRepository;
@Before
public void before() throws Exception { 
    openMocks(this);
}

@After
public void after() throws Exception { 
    sut = null;
    mockLocationRepository = null;
}


@Test
public void testGetLatLonOfACity() throws Exception { 
//TODO: Test goes here... 
} 


} 
