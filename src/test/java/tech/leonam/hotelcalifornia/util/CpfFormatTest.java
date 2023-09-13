package tech.leonam.hotelcalifornia.util;

import org.junit.Assert;
import org.junit.Test;
import tech.leonam.hotelcalifornia.util.exception.DocumentException;

public class CpfFormatTest {
    private static final String CPF_INVALID = "000000000";
    private static final String CPF_VALID = "95806528057";
    private static final String CPF_VALID_FORMAT = "958.065.280-57";
    private static final String CPF_BLANK = " ";
    private static final String CPF_SMALL_SIZE = "9580652805";

    @Test(expected = DocumentException.class)
    public void testCpfSmall() throws DocumentException {
        CpfFormat.isTheSizeCorrect(CPF_SMALL_SIZE);
    }
    @Test(expected = DocumentException.class)
    public void CpfBlank() throws DocumentException {
        CpfFormat.isBlank(CPF_BLANK);
    }
    @Test
    public void CpfValid() throws DocumentException {
        var cpf = CpfFormat.format(CPF_VALID);
        Assert.assertEquals(CPF_VALID_FORMAT, cpf);
    }
}