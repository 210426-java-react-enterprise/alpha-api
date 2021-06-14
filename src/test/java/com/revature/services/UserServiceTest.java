package com.revature.services; 

import com.revature.repos.UserRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

/** 
* UserService Tester. 
* 
* @author Nicholas Recino
* @since Jun 13, 2021
* @version 1.0 
*/ 
public class UserServiceTest {

    @InjectMocks
    UserService sut;

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
public void testRegister() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testGetAllUsers() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testIsValid() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testIsUserValid() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testIsUsernameAvailable() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testIsEmailAvailable() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testAuthenticate() throws Exception { 
//TODO: Test goes here... 
} 


@Test
public void testGetUserByUsername() throws Exception { 
//TODO: Test goes here... 
} 


} 
