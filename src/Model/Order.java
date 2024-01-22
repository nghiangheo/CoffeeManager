package Model;

/**
 *
 * @author NBN
 */
public class Order {
    private int Id, ThanhTien;
    private String Date;
    public Order(){       
    }

    public Order(int Id, int ThanhTien, String Date) {
        this.Id = Id;
        this.ThanhTien = ThanhTien;
        this.Date = Date;
    }

    public Order(int ThanhTien, String Date) {
        this.ThanhTien = ThanhTien;
        this.Date = Date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    
}
