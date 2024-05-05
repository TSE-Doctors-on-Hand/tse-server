package cmp2804.tse.server.controller

import cmp2804.tse.server.TestMocks.Companion.APPOINTMENTS
import cmp2804.tse.server.service.AppointmentService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class AppointmentControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var appointmentService: AppointmentService

    @Test
    fun `get all appointments`() {
        println("RUNNING TESTS!")

        // TODO -> Get data search working?
        val expected = APPOINTMENTS

        mockMvc.get("/api/symptom/all") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                }
//                jsonPath("$[0].id") { value(expected.first().id) }
//                jsonPath("$.length()") { value(expected.size) }
            }
    }


}