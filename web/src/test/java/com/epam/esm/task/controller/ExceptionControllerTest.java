package com.epam.esm.task.controller;

import com.epam.esm.task.config.MyWebApplicationInitializer;
import com.epam.esm.task.config.SpringConfig;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MyWebApplicationInitializer.class, SpringConfig.class})
class ExceptionControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ExceptionController exceptionController;
//    @Mock
//    private GiftCertificateService giftCertificateService;
//    @Mock
//    private TagService tagService;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(exceptionController)
                .setControllerAdvice(new ExceptionController())
                .build();
    }


    @Test
    void handleConstraintViolationException() {

    }

    @Test
    void handleDaoExceptions() {
    }

    @Test
    void handleBadRequestExceptions() {
    }

    @Test
    void handleBadRequestException() {
    }

    @Test
    void methodNotAllowedExceptionException() {
    }

    @Test
    void handleBadMediaTypeException() {
    }
}