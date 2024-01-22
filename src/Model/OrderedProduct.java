package Model;

/**
 *
 * @author NBN
 */
public class OrderedProduct {
    private int Id, Soluong, Gia;
    private String Masp;

    public OrderedProduct() {
    }

    public OrderedProduct(int Id, int Soluong, int Gia, String Masp) {
        this.Id = Id;
        this.Soluong = Soluong;
        this.Gia = Gia;
        this.Masp = Masp;
    }

    public OrderedProduct(int Soluong, int Gia, String Masp) {
        this.Soluong = Soluong;
        this.Gia = Gia;
        this.Masp = Masp;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
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
    
}
