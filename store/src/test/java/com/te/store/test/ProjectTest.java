package com.te.store.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.store.bean.Store;

public class ProjectTest {

	@Test
	void test() throws JsonProcessingException, ParseException {

		ObjectMapper mapper = new ObjectMapper();

		String json = "{\"storeId\":\"12\",\"postCode\":\"563322\",\"city\":\"bangalore\",\"address\":\"krt\",\"openedDate\":null,\"numberOfDays\":0}";
				

		Store store = new Store();
		store.setAddress("krt");
		store.setCity("bangalore");
		// store.setOpenedDate(new SimpleDateFormat("dd-MM-yyyy").parse("12-12-1999"));

		store.setPostCode("563322");
		store.setStoreId("12");

		System.out.println(mapper.writeValueAsString(store));

		Store readValue = mapper.readValue(json, Store.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
