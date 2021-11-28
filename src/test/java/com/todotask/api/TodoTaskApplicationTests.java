package com.todotask.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.request.AuthenticationRequest;
import com.todotask.api.response.AuthenticationResponse;
import com.todotask.api.response.ResponseDTO;
import com.todotask.api.service.TodoTaskService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class TodoTaskApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
    private TodoTaskService totoTaskService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@org.junit.Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	// JUnit test for request token
	@Test
	public void getRequestTokenTest() throws Exception {
		AuthenticationRequest user = new AuthenticationRequest();
		user.setUsername("user1");
		user.setPassword("123456");
		
		String JsonRequest = objectMapper.writeValueAsString(user);
		
		MvcResult result = mockMvc.perform(post("/requesttoken").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		AuthenticationResponse response = objectMapper.readValue(resultContext, AuthenticationResponse.class);
		
		System.out.println(response.getJwt());
		Assert.assertTrue(isJWT(response.getJwt()) == Boolean.TRUE);
			
	}
	
	
	// JUnit test for adding task
	@Test
	public void addTodoTaskTest() throws Exception {
		TodoTaskDto taskDto = new TodoTaskDto();
		taskDto.setDescription("Task 158");
		taskDto.setIsDone(false);
		taskDto.setPiorityName("low");
		
		String JsonRequest = objectMapper.writeValueAsString(taskDto);
		
		String token=getToken();
		
		
		MvcResult result = mockMvc.perform(post("/addTask").header(HttpHeaders.AUTHORIZATION, "Bearer "+token).content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		ResponseDTO response = objectMapper.readValue(resultContext, ResponseDTO.class);
		
		System.out.println(response.getErrorcode());
		System.out.println(response.getErrormsg());
		Assert.assertTrue(response.getErrorcode() == 0);
			
	}

	// JUnit test for get task list 
	@Test
	public void getTaskListTest() throws Exception {
		
		
		String JsonRequest = objectMapper.writeValueAsString("");
		
		String token=getToken();
		
		MvcResult result = mockMvc.perform(get("/todoTasks")
				.header(HttpHeaders.AUTHORIZATION, "Bearer "+token)
				.param("page", "0")
	            .param("size", "10").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		ResponseDTO response = objectMapper.readValue(resultContext, ResponseDTO.class);
		
		System.out.println(response.getPayload().size());
		System.out.println(response.getPageSize());
		System.out.println(response.getPageNumber());
		Assert.assertTrue(response.getPayload().size() >= 0 && response.getPageSize()==10 && response.getPageNumber()==0);
			
	}
	// JUnit test for updating task
	@Test
	public void updateTaskTest() throws Exception {
		
		int id=3;
		
		TodoTaskDto taskDto= new TodoTaskDto();
		taskDto.setId(id);
		taskDto.setIsDone(false);
		taskDto.setDescription("Updated Task Information");
		taskDto.setPiorityName("low");
		String JsonRequest = objectMapper.writeValueAsString(taskDto);
		
		String token=getToken();
		
		
		MvcResult result = mockMvc.perform(post("/updateTask").header(HttpHeaders.AUTHORIZATION, "Bearer "+token)
				.content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		ResponseDTO response = objectMapper.readValue(resultContext, ResponseDTO.class);
		
		ResponseDTO responseDtoUpdatedEntity=totoTaskService.findById(id);
		
		Assert.assertTrue(response.getErrorcode() == 0 
				&& response.getPayload().get(0).getDescription().equals(responseDtoUpdatedEntity.getPayload().get(0).getDescription()));
			
	}
	
	// JUnit test for getting task by id
	@Test
	public void getTaskByIdTest() throws Exception {
		
		int id=3;
		
		String JsonRequest = objectMapper.writeValueAsString("");
		
		String token=getToken();
		
		MvcResult result = mockMvc.perform(get("/todoTask")
				.header(HttpHeaders.AUTHORIZATION, "Bearer "+token)
				.param("id", id+"")
				.content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		ResponseDTO response = objectMapper.readValue(resultContext, ResponseDTO.class);
		
		Assert.assertTrue(response.getErrorcode() == 0 && response.getPayload().get(0).getId()==id);
			
	}
	
	// JUnit test for deleting task by id
	@Test
	public void deleteTaskByIdTest() throws Exception {
		
		int id=5;
		
		TodoTaskDto taskDto= new TodoTaskDto();
		taskDto.setId(id);
		
		String JsonRequest = objectMapper.writeValueAsString(taskDto);
		
		String token=getToken();
		
		MvcResult result = mockMvc.perform(post("/deleteTask")
				.header(HttpHeaders.AUTHORIZATION, "Bearer "+token)
				.content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		ResponseDTO response = objectMapper.readValue(resultContext, ResponseDTO.class);
		
		Assert.assertTrue(response.getErrorcode() == 0);
			
	}
	
	
	private String getToken() throws Exception {
		AuthenticationRequest user = new AuthenticationRequest();
		user.setUsername("user1");
		user.setPassword("123456");
		
		String JsonRequest = objectMapper.writeValueAsString(user);
		
		MvcResult result = mockMvc.perform(post("/requesttoken").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		AuthenticationResponse response = objectMapper.readValue(resultContext, AuthenticationResponse.class);
		
		return response.getJwt();
		
			
	}
	
	
	
	private boolean isJWT(String jwt) {
        String[] jwtSplitted = jwt.split("\\.");
        if (jwtSplitted.length != 3) // The JWT is composed of three parts
            return false;
        try {
            String jsonFirstPart = new String(Base64.getDecoder().decode(jwtSplitted[0]));
            JSONObject firstPart = new JSONObject(jsonFirstPart); // The first part of the JWT is a JSON
            if (!firstPart.has("alg")) // The first part has the attribute "alg"
                return false;
            String jsonSecondPart = new String(Base64.getDecoder().decode(jwtSplitted[1]));
            JSONObject secondPart = new JSONObject(jsonSecondPart); // The first part of the JWT is a JSON
            //Put the validations you think are necessary for the data the JWT should take to validate
        }catch (JSONException err){
            return false;
        }
        return true;
    }
//	@Test
//	void contextLoads() {
//	}
//	


}
