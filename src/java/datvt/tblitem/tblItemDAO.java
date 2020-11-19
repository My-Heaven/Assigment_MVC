/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.tblitem;

import datvt.utitil.DBHelper;
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
public class tblItemDAO {

    private List<tblItemDTO> accounList;

    public List<tblItemDTO> getAccounList() {
        return accounList;
    }

    public void showItem(String nameitem) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select id, name, price, quantity "
                        + "from tblItem "
                        + "where name like ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + nameitem + "%");
                rs = pst.executeQuery();
                while (rs.next()) {

                    tblItemDTO item = new tblItemDTO(rs.getString("id"), rs.getString("name"), Integer.parseInt(rs.getString("price")), Integer.parseInt(rs.getString("quantity")));
                    if (this.accounList == null) {
                        this.accounList = new ArrayList<tblItemDTO>();
                    }
                    this.accounList.add(item);
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
