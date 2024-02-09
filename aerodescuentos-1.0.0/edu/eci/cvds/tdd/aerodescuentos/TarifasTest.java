import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

public class CalculadorDescuentosTest {

    @Test
    public void testMenorDe18ConMasDe20DiasAntelacion() {
        assertEquals(80000.0, CalculadorDescuentos.calculoTarifa(100000, 25, 16), 0.01);
    }

    @Test
    public void testMayorDe65ConMasDe20DiasAntelacion() {
        assertEquals(77000.0, CalculadorDescuentos.calculoTarifa(100000, 25, 70), 0.01);
    }

    @Test
    public void testEntre18y65ConMasDe20DiasAntelacion() {
        assertEquals(85000.0, CalculadorDescuentos.calculoTarifa(100000, 25, 30), 0.01);
    }

    @Test
    public void testMenorDe18ConMenosDe20DiasAntelacion() {
        assertEquals(95000.0, CalculadorDescuentos.calculoTarifa(100000, 15, 16), 0.01);
    }

    @Test
    public void testMayorDe65ConMenosDe20DiasAntelacion() {
        assertEquals(92000.0, CalculadorDescuentos.calculoTarifa(100000, 15, 70), 0.01);
    }

    @Test
    public void testEntre18y65ConMenosDe20DiasAntelacion() {
        assertEquals(100000.0, CalculadorDescuentos.calculoTarifa(100000, 15, 30), 0.01);
    }
}
