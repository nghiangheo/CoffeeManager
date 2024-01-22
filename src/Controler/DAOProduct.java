package Controler;

import JDBC.JDBCUtil;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NBN
 */
public class DAOProduct {
    Connection c = JDBCUtil.getConnection();

    public ArrayList<Product> getListSP(){
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";
        try(PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            
            while(rs.next()){
                Product n=new Product();
                n.setId(rs.getInt("ID"));
                n.setMasp(rs.getString("Mã Sản Phẩm"));
                n.setTensp(rs.getString("Tên Sản Phẩm"));
                n.setLoai(rs.getString("Loại"));
                n.setGia(rs.getInt("Giá"));
                list.add(n);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddSP(Product s){
        
        String sql = "INSERT INTO `sanpham` (`Mã Sản Phẩm`, `Tên Sản Phẩm`, `Loại`, `Giá`) "
                + "VALUES (?,?,?,?)";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1,s.getMasp());
            ps.setString(2,s.getTensp());
            ps.setString(3,s.getLoai());
            ps.setInt(4,s.getGia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteSP(int id){
        String sql = "DELETE FROM sanpham WHERE ID=?";
        try(PreparedStatement ps = c.prepareCall(sql)) {
            
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   /* public ArrayList<Product> findbyName(String Name){
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham WHERE `Tên Sản Phẩm` like ?";
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, "%"+Name+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product n = new Product();
                n.setId(rs.getInt("ID"));
                n.setMasp(rs.getString("Mã Sản Phẩm"));
                n.setTensp(rs.getString("Tên Sản Phẩm"));
                n.setLoai(rs.getString("Loại"));
                n.setGia(rs.getInt("Giá"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }*/
    
    public List<Product> searchProduct(Product searchCriteria) throws SQLException {
        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM `sanpham` WHERE ";

        if (searchCriteria.getMasp()!= null && !searchCriteria.getMasp().isEmpty()) {
            query += "`Mã Sản Phẩm` LIKE '%" + searchCriteria.getMasp()+ "%' AND ";
        }
        if (searchCriteria.getTensp()!= null && !searchCriteria.getTensp().isEmpty()) {
            query += "`Tên Sản Phẩm` LIKE '%" + searchCriteria.getTensp()+ "%' AND ";
        }
        if (searchCriteria.getLoai()!= null && !searchCriteria.getLoai().isEmpty()) {
            query += "`Loại` LIKE '%" + searchCriteria.getLoai()+ "%' AND ";
        }
        
        // Loại bỏ AND cuối cùng
        query = query.substring(0, query.length() - 5);

        try (PreparedStatement statement = c.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setMasp(rs.getString("Mã Sản Phẩm"));
                product.setTensp(rs.getString("Tên Sản Phẩm"));               
                product.setLoai(rs.getString("Loại"));
                product.setGia(rs.getInt("Giá"));
                result.add(product);
            }
        }

    return result;
    } 
}
