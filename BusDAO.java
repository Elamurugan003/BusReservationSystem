package busResv;

import java.sql.*;

// data access object
public class BusDAO {
	
    public void displayBusInfo() throws SQLException{
    	String query = "select * from bus";
    	Connection con = DbConnection.getConnection();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(query);
    	
    	while(rs.next()) {
    		System.out.println("Bus No : " + rs.getInt(1));
    		
    		if(rs.getInt(2) == 0)
    			System.out.println("Ac Bus: No");
    		else
    			System.out.println("Ac Bus: Yes");
    		
    		System.out.println("Capacity: "+rs.getInt(3));
    		System.out.println("Driver Name: "+rs.getString(4));
    		System.out.println("Travel From: "+rs.getString(5));
    		System.out.println("Travel To: "+rs.getString(6));
    		System.out.println();
    	}
    	
    	System.out.println("-----------------------------");
    }
    
    public void addBus(Bus bus) throws SQLException{
		String query = "insert into bus values (?,?,?,?,?,?)";
		
		Connection con = DbConnection.getConnection();
    	PreparedStatement pst = con.prepareStatement(query);
    	
    	pst.setInt(1,bus.getBusNo());
    	pst.setInt(2, bus.getAc());
    	pst.setInt(3, bus.getCapacity());
    	pst.setString(4, bus.getDriverName());
    	pst.setString(5, bus.getTravelFrom());
    	pst.setString(6, bus.getTravelTo());
    	
    	pst.executeUpdate();
	}
    
    public int getCapacity(int id) throws SQLException{
    	String query = "select capacity from bus where id =" + id;
    	
    	Connection con = DbConnection.getConnection();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(query);
    	
    	rs.next();
    	return rs.getInt(1);
    }
}
