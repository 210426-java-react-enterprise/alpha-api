package com.revature.services; 

import com.fasterxml.jackson.annotation.JacksonInject;
import com.revature.repos.UserRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

/** 
* UserDetailsServiceImpl Tester. 
* 
* @author Nicholas Recino
* @since Jun 13, 2021
* @version 1.0 
*/ 
public class UserDetailsServiceImplTest {

    @InjectMocks
    UserDetailsServiceImpl sut;

    @Mock
    UserRepository mockUserRepository;

@Before
public void before() throws Exception {
    openMocks(this);
} 

@After
public void after() throws Exception {
    sut = null;
    mockUserRepository = null;
} 


@Test
public void testLoadUserByUsername() throws Exception { 
//TODO: Test goes here... 
} 


} 
