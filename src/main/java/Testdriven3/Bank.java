package Testdriven3;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private User user;
    private String valuta;
    private double saldo;
    private List<String> logg;

    public Bank(User user, String valuta) {
        this.user = user;
        this.valuta = valuta;
        this.saldo = 1000.0;
        this.logg = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void ändraSaldo(double belopp) {
        saldo += belopp;
    }

    public void setSaldo(double nyttSaldo) {
        this.saldo = nyttSaldo;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public void läggTillLogg(String meddelande) {
        logg.add(meddelande);
    }

    public List<String> getLogg() {
        return logg;
    }

    public String getAnvändarNamn() {
        return user.getNamn();
    }
}
