package learn.springframework.msscbeerservice;

import java.util.UUID;

// import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result;

// import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import learn.springframework.web.controller.BeerController;
import learn.springframework.web.model.BeerDto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
// @SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class MsscBeerServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads(){
	}

	@Test
	void getBeerById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void saveNewBeer() throws Exception{		
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(
			MockMvcRequestBuilders.post("/api/1/beer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(status().isCreated()
			);
	}

	@Test
	void updateBeerById() throws Exception{
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(
			MockMvcRequestBuilders.put("/api/v1/beer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(status().isCreated()
		);
	}
}
