package com.greenapex.CSV_Reader.EmployeeControllerTest;

import com.greenapex.CSV_Reader.Controller.EmployeeController;
import com.greenapex.CSV_Reader.Model.EmployeeModel;
import com.greenapex.CSV_Reader.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
public class GetEmployeeByIdTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeService empService;



    @Test
    public void testGetEmployee() throws Exception {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(1L);
        employeeModel.setName("ABC");
        employeeModel.setAge("24");
        employeeModel.setCountry("IND");

        when(empService.findById(Mockito.anyLong())).thenReturn(employeeModel);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fetchById"+"?id=1")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();

        System.out.println("Success: " + contentAsString);

        assert (!contentAsString.isEmpty());
        assertEquals(HttpStatus.OK.value(),status);
        verify(empService).findById(Mockito.anyLong());

    }
}
