package it.dstech.formazione.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.dstech.formazione.chat.model.Persona;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = StarterApplication.class)
@AutoConfigureMockMvc
public class ChatRestTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void getAllPerson() {

		try {
			MvcResult result = mock.perform(get("/usernames").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
			String contentAsString = result.getResponse().getContentAsString();
			
			ObjectMapper obj = new ObjectMapper();
			Persona[] readValue = obj.readValue(contentAsString	, Persona[].class);
			assertEquals(readValue.length , 5);
			for (Persona persona : readValue) {
				System.out.println(persona);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void altroTest() {

		try {
			MvcResult result = mock.perform(get("/usernames").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
			String contentAsString = result.getResponse().getContentAsString();
			
			ObjectMapper obj = new ObjectMapper();
			List<Persona> readValue = Arrays.asList(obj.readValue(contentAsString	, Persona[].class));
			assertNotEquals(readValue.size() , 4);
			for (Persona persona : readValue) {
				System.out.println(persona);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
