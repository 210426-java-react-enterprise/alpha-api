package com.revature.services; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring5.SpringTemplateEngine;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/** 
* MailServiceImpl Tester. 
* 
* @author Nicholas Recino
* @since Jun 13, 2021
* @version 1.0 
*/ 
public class MailServiceImplTest {

    @InjectMocks
    MailServiceImpl sut;

    @Mock
    JavaMailSender mockMailSender;

    @Mock
    SpringTemplateEngine mockTemplateEngine;

@Before
public void before() throws Exception {
    openMocks(this);
} 

@After
public void after() throws Exception {
    sut = null;
    mockMailSender = null;
    mockTemplateEngine = null;
} 


@Test
public void testSendEmail() throws Exception { 
//TODO: Test goes here... 
} 


} 
