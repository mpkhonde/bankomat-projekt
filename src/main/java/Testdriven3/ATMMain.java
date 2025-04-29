package Testdriven3;

import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔐 Autentisering innan användning
        KodKontroll kontroll = new KodVerifierare("1234");
        int försök = 0;
        final int MAX_FÖRSÖK = 3;
        boolean autentiserad = false;

        while (försök < MAX_FÖRSÖK) {
            System.out.print("🔒 Ange kod: ");
            String inputKod = scanner.nextLine();

            // 🔄 Verifieringsanimation
            System.out.print("🔄 Verifierar kod");
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(500);
                    System.out.print(".");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println();

            if (kontroll.verifiera(inputKod)) {
                autentiserad = true;
                System.out.println("✅ Kod korrekt! Välkommen.");
                break;
            } else {
                försök++;
                System.out.println("❌ Fel kod. Försök kvar: " + (MAX_FÖRSÖK - försök));
            }
        }

        if (!autentiserad) {
            System.out.println("🚫 För många felaktiga försök. Programmet avslutas.");
            scanner.close();
            return;
        }

        // 👤 Namninmatning efter godkänd kod
        System.out.print("👤 Skriv ditt namn: ");
        String namn = scanner.nextLine();

        User user = new User(namn, "SEK");
        Bank bank = new Bank(user, "SEK");
        ATM atm = new ATM(user, bank);

        boolean kör = true;
        System.out.println("\n🏧 Välkommen till bankautomaten, " + user.getNamn() + "!");

        while (kör) {
            // 📋 Meny
            System.out.println("-----------------------------------");
            System.out.println("\n📋 Meny:");
            System.out.println("1️⃣  Visa saldo");
            System.out.println("2️⃣  Sätt in pengar");
            System.out.println("3️⃣  Ta ut pengar");
            System.out.println("4️⃣  Visa transaktionslogg");
            System.out.println("5️⃣  Byt valuta");
            System.out.println("6️⃣  Avsluta");
            System.out.println("-----------------------------------");

            System.out.print("👉 Ditt val: ");
            String val = scanner.nextLine();

            switch (val) {
                case "1":
                    atm.visaSaldo();
                    break;

                case "2":
                    System.out.print("💵 Hur mycket vill du sätta in? ");
                    double in = scanner.nextDouble();
                    scanner.nextLine();
                    atm.sättIn(in);
                    frågaOmKvitto(scanner, atm, "Insättning", in);
                    break;

                case "3":
                    System.out.print("💸 Hur mycket vill du ta ut? ");
                    double ut = scanner.nextDouble();
                    scanner.nextLine();
                    atm.taUt(ut);
                    frågaOmKvitto(scanner, atm, "Uttag", ut);
                    break;

                case "4":
                    atm.visaLogg();
                    break;

                case "5":
                    System.out.print("🌐 Ange ny valuta (SEK, USD, EUR): ");
                    String nyValuta = scanner.nextLine().toUpperCase();
                    bank.setValuta(nyValuta);
                    System.out.println("✅ Valutan är nu " + nyValuta);
                    break;

                case "6":
                    kör = false;
                    System.out.println("👋 Tack för besöket, " + user.getNamn() + "!");
                    break;

                default:
                    System.out.println("⚠️ Ogiltigt val. Försök igen.");
            }
        }

        scanner.close();
    }

    // Fråga om användaren vill ha kvitto
    private static void frågaOmKvitto(Scanner scanner, ATM atm, String typ, double belopp) {
        System.out.print("📄 Vill du ha kvitto? (ja/nej): ");
        String svar = scanner.nextLine().toLowerCase();
        if (svar.equals("ja")) {
            atm.skrivKvitto(typ, belopp);
        }
    }
}
