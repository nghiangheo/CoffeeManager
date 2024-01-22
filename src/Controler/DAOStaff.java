package Controler;
import JDBC.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Staff;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NBN
 */

public class DAOStaff {
    Connection c = JDBCUtil.getConnection();    
   public ArrayList<Staff> getListNV() {
    ArrayList<Staff> list = new ArrayList<>();
    String sql = "SELECT * FROM nhanvien";

    try (PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Staff n = new Staff();
            n.setId(rs.getInt("ID"));
            n.setManv(rs.getString("Mã Nhân Viên"));
            n.setTennv(rs.getString("Họ và Tên"));
            n.setChucvu(rs.getString("Chức vụ"));
            n.setNgaysinh(rs.getString("Ngày Sinh"));
            n.setGt(rs.getString("Giới Tính"));
            n.setDiachi(rs.getString("Địa Chỉ"));
            n.setSDT(rs.getString("SĐT"));
            n.setEmail(rs.getString("Email"));
            n.setLuong(rs.getInt("Lương (tháng)"));
            list.add(n);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(c);
    }

    return list;
}

    
    public void AddNV(Staff s) {
    String sql = "INSERT INTO `nhanvien`(`Mã Nhân Viên`, `Họ và Tên`, `Chức vụ`, `Ngày Sinh`, `Giới Tính`, `Địa Chỉ`, `SĐT`, `Email`, `Lương (tháng)`) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";

    try (PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setString(1, s.getManv());
        ps.setString(2, s.getTennv());
        ps.setString(3, s.getChucvu());
        ps.setString(4, s.getNgaysinh());
        ps.setString(5, s.getGt());
        ps.setString(6, s.getDiachi());
        ps.setString(7, s.getSDT());
        ps.setString(8, s.getEmail());
        ps.setInt(9, s.getLuong());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(c);
    }
}
    
    public void DeleteNV(int id) {
    String sql = "DELETE FROM nhanvien WHERE ID=?";
    try (PreparedStatement ps = c.prepareCall(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(c);
    }
}

    
public List<Staff> searchStaff(Staff searchCriteria) throws SQLException {
        List<Staff> result = new ArrayList<>();

        // Thay thế bằng phương thức lấy kết nối đến cơ sở dữ liệu của bạn
        String query = "SELECT * FROM `nhanvien` WHERE ";

        // Xây dựng câu truy vấn dựa trên các trường có giá trị trong searchCriteria
        if (searchCriteria.getManv() != null && !searchCriteria.getManv().isEmpty()) {
            query += "`Mã Nhân Viên` LIKE '%" + searchCriteria.getManv() + "%' AND ";
        }
        if (searchCriteria.getTennv() != null && !searchCriteria.getTennv().isEmpty()) {
            query += "`Họ và Tên` LIKE '%" + searchCriteria.getTennv() + "%' AND ";
        }
        if (searchCriteria.getChucvu()!= null && !searchCriteria.getChucvu().isEmpty()) {
            query += "`Chức vụ` LIKE '%" + searchCriteria.getChucvu()+ "%' AND ";
        }
        if (searchCriteria.getNgaysinh()!= null && !searchCriteria.getNgaysinh().isEmpty()) {
            query += "`Ngày Sinh` LIKE '%" + searchCriteria.getNgaysinh()+ "%' AND ";
        }
        if (searchCriteria.getDiachi()!= null && !searchCriteria.getDiachi().isEmpty()) {
            query += "`Địa Chỉ` LIKE '%" + searchCriteria.getDiachi()+ "%' AND ";
        }
        if (searchCriteria.getSDT()!= null && !searchCriteria.getSDT().isEmpty()) {
            query += "`SĐT` LIKE '%" + searchCriteria.getSDT()+ "%' AND ";
        }
        if (searchCriteria.getEmail()!= null && !searchCriteria.getEmail().isEmpty()) {
            query += "`Email` LIKE '%" + searchCriteria.getEmail()+ "%' AND ";
        }
        if (searchCriteria.getGt()!= null && !searchCriteria.getGt().isEmpty()) {
            query += "`Giới Tính` LIKE '%" + searchCriteria.getGt()+ "%' AND ";
        }
        // Loại bỏ AND cuối cùng
        query = query.substring(0, query.length() - 5);

        try (PreparedStatement statement = c.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setManv(rs.getString("Mã Nhân Viên"));
                staff.setTennv(rs.getString("Họ và Tên"));
                staff.setChucvu(rs.getString("Chức vụ"));
                staff.setNgaysinh(rs.getString("Ngày Sinh"));
                staff.setDiachi(rs.getString("Địa Chỉ"));
                staff.setSDT(rs.getString("SĐT"));
                staff.setEmail(rs.getString("Email"));
                staff.setGt(rs.getString("Giới Tính"));
                staff.setLuong(rs.getInt("Lương (tháng)"));
                result.add(staff);
            }
        }

    return result;
    }   
    
}
