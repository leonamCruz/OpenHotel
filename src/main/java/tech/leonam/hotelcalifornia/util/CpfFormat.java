package tech.leonam.hotelcalifornia.util;

public class CpfFormat {
    public static String format(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}
