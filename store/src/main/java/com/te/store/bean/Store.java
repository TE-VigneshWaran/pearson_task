package com.te.store.bean;

import com.opencsv.bean.CsvDate;

import lombok.Data;

@Data
public class Store {

	private String storeId;

	private String postCode;

	private String city;

	private String address;

	@CsvDate(value = "dd/MM/yyy")
	private String openedDate;

	private long numberOfDays;
}
