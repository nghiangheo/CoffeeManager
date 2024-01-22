
package Controler;

import JDBC.JDBCUtil;
import Model.Customer;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NBN
 */
public class DAOCustomer {
    Connection c = JDBCUtil.getConnection();
    public ArrayList<Customer> getListKH(){
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM `khachhang`";
        try(PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            
            while(rs.next()){
                Customer n=new Customer();
                n.setId(rs.getInt("ID"));
                n.setTenkh(rs.getString("Tên Khách Hàng"));
                n.setDiachi(rs.getString("Địa Chỉ"));
                n.setSdt(rs.getString("SĐT"));
               
                list.add(n);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddKH(Customer s){
        
        String sql = "INSERT INTO `khachhang` (`Tên Khách Hàng`, `Địa Chỉ`, `SĐT`) VALUES (?,?,?)";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1,s.getTenkh());
            ps.setString(2,s.getDiachi());
            ps.setString(3,s.getSdt());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
