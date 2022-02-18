package com.te.store.bean.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.te.store.bean.Store;
import com.te.store.exception.StoreException;

@Service
public class StoreServiceImpl implements StoreService {

	@Override
	public Object getById(String storeId) {
		List<Store> list2 = new ArrayList<Store>();
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Store Id", "storeid");
		mapping.put("Post Code", "postcode");
		mapping.put("City", "city");
		mapping.put("Address", "address");
		mapping.put("Opened Date", "openeddate");

		HeaderColumnNameTranslateMappingStrategy<Store> strategy = new HeaderColumnNameTranslateMappingStrategy<Store>();
		strategy.setType(Store.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = null;

		try {
			csvReader = new CSVReader(new FileReader("src/main/webapp/WEB-INF/views/stores.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();
		List<Store> list = csvToBean.parse(strategy, csvReader);
		Store bean = null;
		for (Store store : list) {
			Date date = null;

			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(store.getOpenedDate());
				Date dat = new Date();

				long timediff = Math.abs(dat.getTime() - date.getTime());
				long dif = TimeUnit.DAYS.convert(timediff, TimeUnit.MILLISECONDS);

				store.setNumberOfDays(dif);
			} catch (Exception e) {
				// TODO: handle exceptions
			}
			if (store.getStoreId().equals(storeId)) {
				bean = store;
			} else {
				throw new StoreException("Please Enter Valid Id...");
			}
			if (bean != null || !storeId.isEmpty()) {
				return bean;
			} else {
				throw new StoreException("id should not be null or empty...");
			}
		}

		return bean;
	}

	@Override
	public Object getByOption(String option) {

		if (option != null || !option.isEmpty()) {

			List<Store> list2 = new ArrayList<Store>();

			Map<String, String> mapping = new HashMap<String, String>();
			mapping.put("Store Id", "storeid");
			mapping.put("Post Code", "postcode");
			mapping.put("City", "city");
			mapping.put("Address", "address");
			mapping.put("Opened Date", "openeddate");

			HeaderColumnNameTranslateMappingStrategy<Store> strategy = new HeaderColumnNameTranslateMappingStrategy<Store>();
			strategy.setType(Store.class);
			strategy.setColumnMapping(mapping);

			CSVReader csvReader = null;
			try {
				csvReader = new CSVReader(new FileReader("src/main/webapp/WEB-INF/views/stores.csv"));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			CsvToBean csvToBean = new CsvToBean();

			List<Store> list = csvToBean.parse(strategy, csvReader);

			for (Store store : list) {
				Date date = null;

				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(store.getOpenedDate());
					Date dat = new Date();

					long timediff = Math.abs(dat.getTime() - date.getTime());
					long dif = TimeUnit.DAYS.convert(timediff, TimeUnit.MILLISECONDS);

					store.setNumberOfDays(dif);
				} catch (Exception e) {
					// TODO: handle exceptions
				}
			}

			System.out.println(list);
			if (option.equalsIgnoreCase("city")) {
				list2 = list.stream().sorted((i, j) -> i.getCity().compareTo(j.getCity())).collect(Collectors.toList());
				return list2;

			} else if (option.equalsIgnoreCase("openedDate"))
				list2 = list.stream().sorted((i, j) -> i.getOpenedDate().compareTo(j.getOpenedDate()))
						.collect(Collectors.toList());
			else {
				throw new StoreException("please enter the valid option...");
			}
		
			return list2;
		}
		
		return option;
	}
}