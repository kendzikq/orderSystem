package com.example.ordersystem;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApplicationTests extends BaseMvcTest {

    @Test
    void healthCheck() throws Exception {

        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
