import org.example.DecimalToRomano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 27/11/2023
 */
public class DecimalToRomanoTest {
    @Test
    @DisplayName("Converte Decimal para Romano, erro do numero 0")
    void valorComZero() {
        DecimalToRomano decimalToRomano = new DecimalToRomano();
        Exception exception = assertThrows(Exception.class, () -> {
            decimalToRomano.setDecimal(0);
            decimalToRomano.converterEmRomanos();
        });

        assertEquals("Não pode ser inserido valor menor ou igual a 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Converte Decimal para Romano, erro do numero maior que 3999")
    void valorGrande() {
        DecimalToRomano decimalToRomano = new DecimalToRomano();
        Exception exception = assertThrows(Exception.class, () -> {
            decimalToRomano.setDecimal(4000);
            decimalToRomano.converterEmRomanos();
        });

        assertEquals("O maior valor decimal que pode ser convertido é 3999.", exception.getMessage());
    }

    @Test
    @DisplayName("Converte Decimal para Romano, valores corretos")
    void converteCerto() throws Exception {
        DecimalToRomano decimalToRomano = new DecimalToRomano();
        decimalToRomano.setDecimal(19);
        assertEquals("XIX",decimalToRomano.converterEmRomanos());

        decimalToRomano.setDecimal(3549);
        assertEquals("MMMDXLIX", decimalToRomano.converterEmRomanos());
    }
}
