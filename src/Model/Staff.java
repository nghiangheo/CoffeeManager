
package Model;
/**
 *
 * @author NBN
 */
public class Staff {
    private int Id, Luong;
    private String Manv, Tennv, Chucvu, Ngaysinh,Gt, Diachi, SDT, Email;

    public Staff() {
    }

    public Staff(int Luong, String Manv, String Tennv, String Chucvu, String Ngaysinh, String Gt, String Diachi, String SDT, String Email) {
        this.Luong = Luong;
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Chucvu = Chucvu;
        this.Ngaysinh = Ngaysinh;
        this.Gt = Gt;
        this.Diachi = Diachi;
        this.SDT = SDT;
        this.Email = Email;
    }

    public Staff(int Id, int Luong, String Manv, String Tennv, String Chucvu, String Ngaysinh, String Gt, String Diachi, String SDT, String Email) {
        this.Id = Id;
        this.Luong = Luong;
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Chucvu = Chucvu;
        this.Ngaysinh = Ngaysinh;
        this.Gt = Gt;
        this.Diachi = Diachi;
        this.SDT = SDT;
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getGt() {
        return Gt;
    }

    public void setGt(String Gt) {
        this.Gt = Gt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
