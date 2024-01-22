
package Model;
/**
 *
 * @author NBN
 */

public class Product {
    private int Id, Gia;
    private String Masp,Tensp, Loai;
    
    public Product(){      
    }
    public Product(int Gia, String Masp, String Tensp, String Loai) {
        this.Gia = Gia;
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Loai = Loai;
    }

    public Product(int Id, int Gia, String Masp, String Tensp, String Loai) {
        this.Id = Id;
        this.Gia = Gia;
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Loai = Loai;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
       
}
