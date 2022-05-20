package com.greenapex.CSV_Reader.EmployeeControllerTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    public void upsertRecordTest() throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("test.csv");
        MockMultipartFile file = new MockMultipartFile("file", "test.csv",
                "text/csv", classPathResource.getInputStream());
        this.mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/upsertRecords")
                        .file(file)
                        .contentType("text/csv")
                        .content(file.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

}
