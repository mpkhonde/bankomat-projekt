package Testdriven3;

public class User {
    private String namn;
    private String valuta;

    public User(String namn, String valuta) {
        this.namn = namn;
        this.valuta = valuta;
    }

    public String getNamn() {
        return namn;
    }

    public String getValuta() {
        return valuta;
    }
}
