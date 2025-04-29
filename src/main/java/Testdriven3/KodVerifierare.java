package Testdriven3;

public class KodVerifierare extends KodKontroll {
    private final String korrektKod;

    public KodVerifierare(String korrektKod) {
        this.korrektKod = korrektKod;
    }

    @Override
    public boolean verifiera(String input) {
        return korrektKod.equals(input);
    }
}
