package com.te.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.te.store.bean.Store;
import com.te.store.bean.service.StoreServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	CSVReader reader;
	@InjectMocks
	private StoreServiceImpl service;

	public ServiceTest() {
		reader = mock(CSVReader.class);
	}

	@Test
	void getStoreById() throws IOException {
		Store store = new Store();
		store.setAddress("krt");
		store.setCity("bangalore");
		store.setPostCode("563322");

		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");

		// assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f",
		// service.getAll(store.getStoreId()));
	}

	@Test
	void ge() throws IOException {

		Store store = new Store();
		store.setAddress("krt");
		store.setCity("bangalore");
		store.setPostCode("563322");
		store.setStoreId("12");
		String[] abc = { "12", "563322", "bangalore", "krt" };

		List<Store> list = new ArrayList<>();
		list.add(store);
		CSVReader csvReader = new CSVReader(new FileReader("/store/src/main/webapp/WEB-INF/views/stores.csv"));

		//when(service.getStoreById(store.getStoreId())).thenReturn(store);

		// assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f",
		// service.getByOption("city").get(0).getStoreId());

	}

}
