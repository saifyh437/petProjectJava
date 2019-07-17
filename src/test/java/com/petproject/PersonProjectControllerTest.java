package com.petproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petproject.controller.PersonProjectController;
import com.petproject.model.Person;
import com.petproject.repository.PersonRepository;
import com.petproject.request.PersonRequest;
import com.petproject.response.PersonResponse;

@WebMvcTest(controllers = PersonProjectController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersonProjectControllerTestConfiguration.class)
public class PersonProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonRepository personRepository;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testHappyPathGetPersons() throws Exception {

		Person person = new Person();
		person.setPersonAge(10);
		person.setPersonName("Saify");

		List<Person> persons = new ArrayList<Person>();
		persons.add(person);

		when(personRepository.findAll()).thenReturn(persons);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/personproject")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		List<PersonResponse> personResponses = extractResponse(result, List.class);

		assertThat(personResponses).isNotNull();
		assertThat(personResponses).hasSize(1);
	}
	
	@Test
	public void testHappyPathCreatePersons() throws Exception {

		PersonRequest perRequest = new PersonRequest();
		perRequest.setPersonAge(10);
		perRequest.setPersonName("Saify");

		Person person = new Person();
		person.setPersonAge(10);
		person.setPersonName("Saify");

		when(personRepository.save(person)).thenReturn(person);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personproject")
				 .content(mapper.writeValueAsString(perRequest)) .contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		PersonResponse personResponse = extractResponse(result, PersonResponse.class);

		assertThat(personResponse).isNotNull();
		assertThat(personResponse.getPersonName()).isEqualTo("Saify");
	}

	private <T> T extractResponse(MvcResult mvcResult, Class<T> clazz) throws Exception {
		return mapper.readValue(mvcResult.getResponse().getContentAsString(), clazz);
	}
}
