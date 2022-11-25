package com.abm.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("carPartInv4")
public class CarPartInventoryImpl4 implements CarPartInventory{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jt;

	public void addNewPart(CarPart carPart) {
		//JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		String sql = "insert into tbl_carpart (part_name, car_model, price, quantity) values (?,?,?,?)";

		jt.update(sql,carPart.getPartName(),carPart.getCarModel(),carPart.getPrice(),carPart.getQuantity() );

	}

	public List<CarPart> getAvailableParts() {
		
		// JdbcTemplate jt = new JdbcTemplate(dataSource);
		
	     String sql = "select * from TBL_CARPART";
	     List<CarPart> list = jt.query(sql, BeanPropertyRowMapper.newInstance(CarPart.class));
	     return list;
	}

}
