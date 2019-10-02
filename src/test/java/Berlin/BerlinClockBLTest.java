package Berlin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BerlinClockBLTest {
    @Mock
    private BerlinClockRepository repository;

    private Time time;
    private BerlinClockBL berlinClockBL;

    @Before
    public void setUp() throws Exception {
        berlinClockBL = new BerlinClockBL(repository);
        time = new Time().toBuilder()
                .singleMinutes("OOOO")
                .fiveMinutes("OOOOOOOOOOO")
                .singleHours("OOOO")
                .fiveHours("OOOO")
                .seconds("Y")
                .build();
    }

    @Test
    public void shouldConvertSingleMinuteToBerlinTime() {
        Mockito.when(repository.getCurrentMinute()).thenReturn(59);

        String result = berlinClockBL.convertSingleMinutes();
        Mockito.verify(repository).getCurrentMinute();

        Assert.assertEquals("YYYY", result);
    }

    @Test
    public void shouldConvertFiveMinutesToBerlinTime() {
        Mockito.when(repository.getCurrentMinute()).thenReturn(59);

        String result = berlinClockBL.convertFiveMinutes();
        Mockito.verify(repository).getCurrentMinute();

        Assert.assertEquals("YYRYYRYYRYY", result);
    }

    @Test
    public void shouldConvertSingleHoursToBerlinTime() {
        Mockito.when(repository.getCurrentHour()).thenReturn(23);

        String result = berlinClockBL.convertSingleHours();
        Mockito.verify(repository).getCurrentHour();

        Assert.assertEquals("RRRO", result);
    }

    @Test
    public void shouldConvertFiveHoursToBerlinTime() {
        Mockito.when(repository.getCurrentHour()).thenReturn(23);

        String result = berlinClockBL.convertFiveHours();
        Mockito.verify(repository).getCurrentHour();

        Assert.assertEquals("RRRR", result);
    }

    @Test
    public void shouldConvertSecondsToBerlinTime() {
        Mockito.when(repository.getCurrentSeconds()).thenReturn(59);

        String result = berlinClockBL.convertSeconds();
        Mockito.verify(repository).getCurrentSeconds();

        Assert.assertEquals("O", result);
    }

}