import org.example.RomanoToDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 27/11/2023
 */
public class RomanoToDecimalTest {

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres Inválidos")
    void caracteresInvalidos() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("XIIP");
        });
        assertEquals("Número romano inválido. O valor possui caracteres Inválidos.", exception.getMessage());
    }

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres repetidos mais de 3 vezes")
    void repeteMaisQueTres() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("XXXXII");
        });
        assertEquals("Número romano inválido. Algum Caracter se repete mais que três vezes.", exception.getMessage());
    }

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres Regras da letra I")
    void regraDoI() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMID");
        });
        assertEquals("Número romano inválido. O caracter 'I' está em um local proibido.", exception.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("IMD");
        });
        assertEquals("Número romano inválido. O caracter 'I' está em um local proibido.", exception2.getMessage());

        Exception exception3 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMIC");
        });
        assertEquals("Número romano inválido. O caracter 'I' está em um local proibido.", exception3.getMessage());

        Exception exception4 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMIL");
        });
        assertEquals("Número romano inválido. O caracter 'I' está em um local proibido.", exception4.getMessage());
    }

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres Regras da letra X")
    void regraDoX() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("XM");
        });
        assertEquals("Número romano inválido. O caracter 'X' está em um local proibido.", exception.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMXD");
        });
        assertEquals("Número romano inválido. O caracter 'X' está em um local proibido.", exception2.getMessage());
    }

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres Regras da letra L")
    void regraDoL() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("LM");
        });
        assertEquals("Número romano inválido. O caracter 'L' está em um local proibido.", exception.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMLD");
        });
        assertEquals("Número romano inválido. O caracter 'L' está em um local proibido.", exception2.getMessage());

        Exception exception3 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMLC");
        });
        assertEquals("Número romano inválido. O caracter 'L' está em um local proibido.", exception3.getMessage());
    }

    @Test
    @DisplayName("Converte Romano para Decimal. Caracteres repetidos antes de um numero maior")
    void repeteMenor() {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        Exception exception = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("MMCCD");
        });
        assertEquals("Número romano inválido. Contém caracteres repetidos antes de um valor maior.", exception.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("CCD");
        });
        assertEquals("Número romano inválido. Contém caracteres repetidos antes de um valor maior.", exception2.getMessage());

        Exception exception3 = assertThrows(Exception.class, () -> {
            romanoToDecimal.setRomano("LIIX");
        });
        assertEquals("Número romano inválido. Contém caracteres repetidos antes de um valor maior.", exception3.getMessage());
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource({
            "MMMDXLIX,  3549",
            "MCMLXXXII, 1982",
            "MMCCLIII,  2253",
            "CCCLII,    352",
            "XCIV,      94"
    })
    void valoresCorretos(String romano, int resultado) throws Exception {
        RomanoToDecimal romanoToDecimal = new RomanoToDecimal();
        romanoToDecimal.setRomano(romano);
        assertEquals(
                resultado, romanoToDecimal.converterEmDecimal(),
                ()-> "Romano: "+romano+", equivale a "+resultado+" em decimal."
        );
    }
}
