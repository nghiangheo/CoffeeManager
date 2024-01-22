package Model;
/**
 *
 * @author NBN
 */
public class Customer {
    private int id;
    private String Tenkh, Diachi, Sdt;

    public Customer() {
    }

    public Customer(int id, String Tenkh, String Diachi, String Sdt) {
        this.id = id;
        this.Tenkh = Tenkh;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
    }

    public Customer(String Tenkh, String Diachi, String Sdt) {
        this.Tenkh = Tenkh;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkh() {
        return Tenkh;
    }

    public void setTenkh(String Tenkh) {
        this.Tenkh = Tenkh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }
    
}
