package Testdriven3;

import java.time.LocalDateTime;

public class ATM {
    private final User user;
    private final Bank bank;
    private final String atmId = "ATM-042"; // Bankautomat-ID

    public ATM(User user, Bank bank) {
        this.user = user;
        this.bank = bank;
    }

    public void visaSaldo() {
        System.out.printf("💰 Saldo: %.2f %s%n", bank.getSaldo(), bank.getValuta());
    }

    public void sättIn(double belopp) {
        if (belopp <= 0) {
            System.out.println("⚠️ Beloppet måste vara större än 0.");
        } else {
            bank.ändraSaldo(belopp);
            bank.läggTillLogg("Insättning: +" + belopp + " " + bank.getValuta());
            System.out.println("✅ Insättning lyckades.");
        }
    }

    public void taUt(double belopp) {
        if (belopp <= 0) {
            System.out.println("⚠️ Beloppet måste vara större än 0.");
        } else if (belopp > bank.getSaldo()) {
            System.out.println("❌ Otillräckligt saldo.");
        } else {
            bank.ändraSaldo(-belopp);
            bank.läggTillLogg("Uttag: -" + belopp + " " + bank.getValuta());
            System.out.println("✅ Uttag lyckades.");
        }
    }

    public void visaLogg() {
        System.out.println("\n📘 Transaktionslogg:");
        if (bank.getLogg().isEmpty()) {
            System.out.println("Ingen aktivitet ännu.");
        } else {
            for (String logg : bank.getLogg()) {
                System.out.println("- " + logg);
            }
        }
    }

    public void skrivKvitto(String typ, double belopp) {
        System.out.println("\n📄 KVITTO");
        System.out.println("──────────────────────────────");
        System.out.println("Användare: " + user.getNamn());
        System.out.println("Bankomat-ID: " + atmId);
        System.out.println("Typ:        " + typ);
        System.out.printf ("Belopp:     %.2f %s%n", belopp, bank.getValuta());
        System.out.println("Datum:      " + LocalDateTime.now());
        System.out.printf ("Saldo nu:   %.2f %s%n", bank.getSaldo(), bank.getValuta());
        System.out.println("──────────────────────────────\n");
    }
}
