package com.abm.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carPartInv1")
public class CarPartInventoryImpl1 implements CarPartInventory{

	public void addNewPart(CarPart carPart) {
		 Connection conn = null;
	        try {
	        	// Loading the JDBC Driver
	            Class.forName("org.apache.derby.jdbc.ClientDriver");
	            
	            // Connecting the Database
	            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/training", "derby", "derby");
	            System.out.println("yay, got connected...");
	            
	            String sql = "insert into tbl_carpart (part_name, car_model, price, quantity) values (?,?,?,?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            
	            stmt.setString(1, carPart.getPartName());
	            stmt.setString(2, carPart.getCarModel());
	            stmt.setDouble(3, carPart.getPrice());
	            stmt.setInt(4, carPart.getQuantity());
	            stmt.executeUpdate();
	            
	        }
	        catch( SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally {
	            try { conn.close();}
	            catch(Exception e) { }
	        }
		
	}

	public List<CarPart> getAvailableParts() {
		 Connection conn = null;
		 PreparedStatement stmt = null;
	        try {
	        	// Loading the JDBC Driver
	            Class.forName("org.apache.derby.jdbc.ClientDriver");
	            
	            // Connecting the Database
	            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/training", "derby", "derby");
	            
	            String sql = "select * from TBL_CARPART";
	            stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            
	            List<CarPart> list = new ArrayList<>();
	            while (rs.next()) {
	            	CarPart cp = new CarPart();
	            	cp.setPartNo(rs.getInt("PART_NO"));
	            	cp.setPartName(rs.getString("PART_NAME"));
	            	cp.setCarModel(rs.getString("CAR_MODEL"));
	            	cp.setPrice(rs.getDouble("PRICE"));
	            	cp.setQuantity(rs.getInt("QUANTITY"));
	            	list.add(cp);
	            }
	            return list;
	        }catch(ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        finally {
	            try { conn.close();}
	            catch(Exception e) {
	                
	            }
	        }
	}

}
