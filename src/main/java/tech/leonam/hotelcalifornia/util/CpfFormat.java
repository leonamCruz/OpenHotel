package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.util.exception.DocumentException;

public class CpfFormat {
    private static final short SIZE_CPF = 11;
    public static String format(String cpf) throws DocumentException {
        verificationCpf(cpf);
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
    private static void verificationCpf (String cpf) throws DocumentException {
        isBlank(cpf);
        isTheSizeCorrect(cpf);
    }
    protected static void isBlank(String cpf) throws DocumentException {
        if (cpf.isBlank()){
            throw new DocumentException("CPF blank");
        }
    }
    protected static void isTheSizeCorrect(String cpf) throws DocumentException {
        if(cpf.length() != SIZE_CPF){
            throw new DocumentException("CPF with incorrect size.");
        }
    }
}
