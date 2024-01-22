package Controler;

import JDBC.JDBCUtil;
import Model.OrderedProduct;
import Model.Product;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author NBN
 */
public class DAOOrderedProduct {
    
    Connection c = JDBCUtil.getConnection();
    
    public ArrayList<OrderedProduct> getListDM(){
        ArrayList<OrderedProduct> list = new ArrayList<>();
        String sql = "SELECT * FROM `donmua`";
        try(PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            
            while(rs.next()){
                OrderedProduct n=new OrderedProduct();
                n.setId(rs.getInt("ID"));
                n.setMasp(rs.getString("Mã Sản Phẩm"));
                n.setSoluong(rs.getInt("Số Lượng"));
                n.setGia(rs.getInt("Giá"));
                list.add(n);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public void AddDM(OrderedProduct s){
        
        String sql = "INSERT INTO `donmua` (`Mã Sản Phẩm`,`Số Lượng`, `Giá`) "
                + "VALUES (?,?,?)";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1,s.getMasp());
            ps.setInt(2,s.getSoluong());
            ps.setInt(3,s.getGia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteDM(){
        String sql = "DELETE FROM donmua";
        try(PreparedStatement ps = c.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteRowDM(int Id){
        String sql = "DELETE FROM donmua WHERE ID = ?";
        try(PreparedStatement ps = c.prepareCall(sql)) {
            ps.setInt(1,Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    
    


