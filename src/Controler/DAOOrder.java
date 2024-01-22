package Controler;

import JDBC.JDBCUtil;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NBN
 */
public class DAOOrder {
    Connection c = JDBCUtil.getConnection();
    public ArrayList<Order> getListHD(){
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM `hoadon`";
        try(PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            
            while(rs.next()){
                Order n=new Order();
                n.setId(rs.getInt("ID"));
                n.setDate(rs.getString("Ngày Đặt"));
                n.setThanhTien(rs.getInt("Thành Tiền"));
                list.add(n);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddDH(Order s){
        
        String sql = "INSERT INTO `hoadon` (`Ngày Đặt`, `Thành Tiền`) VALUES (?,?)";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1,s.getDate());
            ps.setInt(2,s.getThanhTien());      
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteDH(int Id){
        String sql = "DELETE FROM hoadon WHERE ID = ?";
        try(PreparedStatement ps = c.prepareCall(sql)) {
            ps.setInt(1,Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Order> findbyDate(String date){
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE `Ngày Đặt` like ?";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, "%"+date+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Order n = new Order();
                n.setId(rs.getInt("ID"));
                n.setDate(rs.getString("Ngày Đặt"));              
                n.setThanhTien(rs.getInt("Thành Tiền"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
