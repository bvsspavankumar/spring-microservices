package com.kp.ms.beerfactory.web.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kp.ms.beerfactory.web.models.BeerDto;
import com.kp.ms.beerfactory.web.models.BeerStyleEnum;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void getBeerById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/beer/"+UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)
			).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void saveNewBeer() throws Exception {
		
		BeerDto b1 = getValidBeerDto();
		String b1toJson = objectMapper.writeValueAsString(b1);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(b1toJson)
			).andExpect(MockMvcResultMatchers.status().isCreated());
		
	}
	
	@Test
	void updateBeerById() throws Exception {
		BeerDto b2 = getValidBeerDto();
		String b2toJson = objectMapper.writeValueAsString(b2);
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/api/v1/beer/"+UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(b2toJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	BeerDto getValidBeerDto() {
		return BeerDto.builder()
				.beerName("My Beer")
				.beerStyle(BeerStyleEnum.ALE)
				.price(new BigDecimal("2.33"))
				.upc(432112344321L)
				.build();
	}
}
