package Berlin;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BerlinClockBLTest {
    @Mock
    private BerlinClockRepository repository;

    private Time time;
    private BerlinClockBL berlinClockBL;

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this);
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
    @Parameters({
            "00, OOOO",
            "59, YYYY",
            "32, YYOO",
            "34, YYYY",
            "35, OOOO"
    })
    public void shouldConvertSingleMinuteToBerlinTime(String minutes, String expected) {
        //Mockito.when(repository.getCurrentMinute()).thenReturn(59);

        String result = berlinClockBL.convertSingleMinutes(minutes);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Parameters({
            "00, OOOOOOOOOOO",
            "59, YYRYYRYYRYY",
            "04, OOOOOOOOOOO",
            "23, YYRYOOOOOOO",
            "35, YYRYYRYOOOO"
    })
    public void shouldConvertFiveMinutesToBerlinTime(String minutes, String expected) {
        //Mockito.when(repository.getCurrentMinute()).thenReturn(59);

        String result = berlinClockBL.convertFiveMinutes(minutes);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Parameters({
            "00, OOOO",
            "23, RRRO",
            "02, RROO",
            "08, RRRO",
            "14, RRRR"
    })
    public void shouldConvertSingleHoursToBerlinTime(String hours, String expected) {
        //Mockito.when(repository.getCurrentHour()).thenReturn(23);

        String result = berlinClockBL.convertSingleHours(hours);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Parameters({
            "00, OOOO",
            "23, RRRR",
            "02, OOOO",
            "08, ROOO",
            "16, RRRO"
    })
    public void shouldConvertFiveHoursToBerlinTime(String hours, String expected) {
        //Mockito.when(repository.getCurrentHour()).thenReturn(23);

        String result = berlinClockBL.convertFiveHours(hours);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Parameters({
            "00, Y",
            "59, O"
    })
    public void shouldConvertSecondsToBerlinTime(String seconds, String expected) {
       // Mockito.when(repository.getCurrentSeconds()).thenReturn(59);

        String result = berlinClockBL.convertSeconds(seconds);

        Assert.assertEquals(expected, result);
    }

    @Test
    @Parameters({
            "00:00:00, YOOOOOOOOOOOOOOOOOOOOOOO",
            "23:59:59, ORRRRRRROYYRYYRYYRYYYYYY",
            "16:50:06, YRRROROOOYYRYYRYYRYOOOOO",
            "11:37:01, ORROOROOOYYRYYRYOOOOYYOO"
    })
    public void shouldConvertCompleteDateToBerlinTime(String date, String expected) {

        String result = berlinClockBL.convertCompleteDate(date);

        Assert.assertEquals(expected, result);
    }

}