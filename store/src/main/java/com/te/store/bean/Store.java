package com.te.store.bean;

import java.sql.Date;

import javax.persistence.Id;

import com.opencsv.bean.CsvDate;

import lombok.Data;

@Data
public class Store {

	// @CsvBindByName(column ="Store Id" )
	private String storeId;

	// @CsvBindByName(column ="Post Code" )
	private String postCode;

	// @CsvBindByName(column ="City" )
	private String city;

	// @CsvBindByName(column ="Address" )
	private String address;

	// @CsvBindByName(column ="Opened Date" )
	@CsvDate(value = "dd/MM/yyy")
	private String openedDate;

	private long numberOfDays;
}
