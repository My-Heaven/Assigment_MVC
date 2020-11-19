    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.tbluser;

import datvt.utitil.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Tan DaT
 */
public class tblUserDAO implements Serializable{
    public String checkLogin(String username, String password) throws SQLException, NamingException{
        Connection  con =null;
        PreparedStatement stm=null;
        ResultSet rs = null;
        try{
            //1. connect DB
            con = DBHelper.makeConnection();
            //2. create SQL String
            if(con != null){
                String sql="Select lastname "
                        + "From tblUser "
                        + "where username = ? and password = ? ";
                //3. create statement object
                stm=con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Execute
                rs = stm.executeQuery();
                //5. xu li ket qua
                if(rs.next()){
                    String fullname =rs.getString("lastname");
                    return fullname;
                }//end if 
            }//end if connection is opened
        }finally{
            if(rs != null)
                rs.close();
            if(stm != null)
                stm.close();
            if(con != null);
                con.close();
        }
        return null;
    }
    private  List<tblUserDTO> accounList;

    public List<tblUserDTO> getAccounList() {
        return accounList;
    }
    
    
    public void searchLastName(String searchValue)throws SQLException, NamingException{
        Connection  con =null;
        PreparedStatement stm=null;
        ResultSet rs = null;
        try{
            //1. connect DB
            con = DBHelper.makeConnection();
            //2. create SQL String
            if(con != null){
                String sql="Select username, password, lastname, isAdmin "
                        + "From tblUser "
                        + "where lastname Like ?";
                //3. create statement object
                stm=con.prepareStatement(sql);
                stm.setString(1, "%"+searchValue+"%");
                //4. Execute
                rs = stm.executeQuery();
                //5. xu li ket qua
                while(rs.next()){
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        String fullname = rs.getString("lastname");
                        boolean role = rs.getBoolean("isAdmin");
                        tblUserDTO dto = new tblUserDTO(username, password, fullname, role);
                        if(this.accounList == null){
                            this.accounList = new ArrayList<tblUserDTO>(); 
                        }
                        this.accounList.add(dto);
                        
                }//end if connection is opened
            }
        }finally{
            if(rs != null)
                rs.close();
            if(stm != null)
                stm.close();
            if(con != null);
                con.close();
        }
        
    }
    public boolean delete(String username)throws SQLException, NamingException{
        Connection  con =null;
        PreparedStatement stm=null;
        try{
            //1. connect DB
            con = DBHelper.makeConnection();
            //2. create SQL String
            if(con != null){
                String sql="Delete from tblUser "
                        + "where username = ? ";
                //3. create statement object
                stm=con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute
                int row =stm.executeUpdate();
                //5. xu li ket qua
                    if(row > 0){
                    return true;
                    }
                //end if 
            }//end if connection is opened
        }finally{
            if(stm != null)
                stm.close();
            if(con != null);
                con.close();
        }
        return false;
    }
    public boolean update(String username, String password, boolean role) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        
        try{
            con = DBHelper.makeConnection();
            if(con!=null){
                String sql="update tblUser "
                        + "set password= ? , isAdmin = ? "
                        + "where username = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, password);
                pst.setBoolean(2, role);
                pst.setString(3, username);
                int row= pst.executeUpdate();
                if(row > 0){
                    return true;
                }
                
            }
            
        }
        finally{
            if(pst!=null) pst.close();
            if(con!=null) con.close();
        }
        return false;
    }
    public boolean createAccount(String username, String password, String fullname, boolean role)throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        
        try{
            con = DBHelper.makeConnection();
            if(con!=null){
                String sql="insert into tblUser(username, password, lastname, isAdmin) values(?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                pst.setString(3, fullname);
                pst.setBoolean(4, role);
                int row= pst.executeUpdate();
                if(row > 0){
                    return true;
                }
                
            }
            
        }
        finally{
            if(pst!=null) pst.close();
            if(con!=null) con.close();
        }
        return false;
    }
}
