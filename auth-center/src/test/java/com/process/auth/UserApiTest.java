package com.process.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Danfeng
 * @since 2018/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void whenQuerySuccess() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/test/properties").
                    contentType(MediaType.APPLICATION_JSON_UTF8)).
                    andExpect(MockMvcResultMatchers.status().isOk()).
                    andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
