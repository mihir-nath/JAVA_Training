package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RenewInsuranceDAOImplimentation implements RenewInsuranceDAO {

	
    Connection conn ; //GLOBAL 
    
    public RenewInsuranceDAOImplimentation() {
    	try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public Insurance selectInsurance(int policyNumber) {
		Insurance insObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			
			ResultSet result = statement.executeQuery("SELECT * FROM INSDB WHERE REGNO="+regNumber +"AND STATUS="+false);
			
			//5. process teh result if any
			if(result.next()) {
				insObj = new Insurance(); 
				
				insObj.setTwoWheeler(result.getBoolean(1));
				insObj.setFourWheeler(result.getBoolean(2));
				insObj.setVehcileModel(result.getString(4));
				insObj.setVehcileManufacturer(result.getString(3));
				insObj.setDrivingLicense(result.getString(5));
				insObj.setPurchaseDate(result.getString(6));
				insObj.setRegistrationNumber(result.getInt(7));
				insObj.setEngineNumber(result.getString(8));
				insObj.setChasisNumber(result.getString(9));
				insObj.setThirdPartyLiabilityInsurance(result.getBoolean(10));
				insObj.setComprehensiveInsurance(result.getBoolean(11));
				insObj.setOneYear(result.getBoolean(12));
				insObj.setTwoYear(result.getBoolean(13));
				insObj.setThreeYear(result.getBoolean(14));
				insObj.setPlanStatus(result.getBoolean(15));
				insObj.setAmount(result.getInt(16));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insObj;
	}

	@Override
	public List<Insurance> selectExpiredInsurances() {
		List<Insurance> insList = new ArrayList<Insurance>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			
			ResultSet result = statement.executeQuery("SELECT * FROM INSDB WHERE STATUS="+false);
			
			
			while(result.next()) 
			{
				Insurance insObj = new Insurance(); 
				
				insObj.setTwoWheeler(result.getBoolean(1));
				insObj.setFourWheeler(result.getBoolean(2));
				insObj.setVehcileModel(result.getString(4));
				insObj.setVehcileManufacturer(result.getString(3));
				insObj.setDrivingLicense(result.getString(5));
				insObj.setPurchaseDate(result.getString(6));
				insObj.setRegistrationNumber(result.getInt(7));
				insObj.setEngineNumber(result.getString(8));
				insObj.setChasisNumber(result.getString(9));
				insObj.setThirdPartyLiabilityInsurance(result.getBoolean(10));
				insObj.setComprehensiveInsurance(result.getBoolean(11));
				insObj.setOneYear(result.getBoolean(12));
				insObj.setTwoYear(result.getBoolean(13));
				insObj.setThreeYear(result.getBoolean(14));
				insObj.setPlanStatus(result.getBoolean(15));
				insObj.setAmount(result.getInt(16));
			}
		    }
		   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   return insList;
	}

	@Override
	public void updateInsurance(Insurance ins) {
		try {
			PreparedStatement pst =conn.prepareStatement("UPDATE INSDB set tplins=?, cins=? ,oyr=? ,tyr=?,thyr=?,pstatus=? =>where regno=?");
					
			pst.setBoolean (10, ins.isThirdPartyLiabilityInsurance());
			pst.setBoolean (11, ins.isComprehensiveInsurance());		
			pst.setBoolean (12, ins.isOneYear());
			pst.setBoolean (13, ins.isTwoYear());
			pst.setBoolean (14, ins.isThreeYear());
			pst.setBoolean (15, ins.isPlanStatus());
			pst.setInt (7, ins.getRegistrationNumber());
			System.out.println("PreparedStatement is created : "+ pst);
					
					
			int rows = pst.executeUpdate();
					
			System.out.println("Row MODIFIED : "+rows);
		} 
		catch (SQLException e) 
		{
					
			e.printStackTrace();
		}
		
	}

}
