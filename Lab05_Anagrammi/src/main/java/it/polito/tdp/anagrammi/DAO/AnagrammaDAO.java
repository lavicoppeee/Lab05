package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {

   public boolean anagrammaEsiste(String p) {
		
   String sql="Select p.nome from parola as p where nome=?";
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, p);
			ResultSet rs=st.executeQuery();
			
			conn.close();
			
		 if(rs.next()) {
			 return true;
		 }else {
			 conn.close();
			 return false;
		 }
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
			
		}
	}

}
