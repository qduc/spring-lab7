package com.lampart.duc.lab7.application.controller;

import com.lampart.duc.lab7.api.data.DataService;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService<UserDto> userDataService;

    @Test
    public void indexShouldReturnListUserFromService() throws Exception {
        List<UserDto> userList = new ArrayList<>();
        userList.add(new UserDto("John Connor", "john_c", "john@example.com", "123"));

        when(userDataService.findAll()).thenReturn(userList);

        mockMvc.perform(get(UserController.urlPrefix)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("John Connor")));
    }
}
