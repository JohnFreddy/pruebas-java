package Berlin;

public class BerlinClockBL {

    private BerlinClockRepository repository;

    public BerlinClockBL(BerlinClockRepository repository) {
        this.repository = repository;
    }

    public String convertSingleMinutes(String minutes) {
        Integer currentMinute = Integer.parseInt(minutes);
        currentMinute = currentMinute % 10;
        StringBuilder x = new StringBuilder();
        x = getSingleTimeValue(x, "Y", currentMinute);
        System.out.println(setNullValues(x, 4));
        return setNullValues(x, 4);
    }

    public String convertFiveMinutes(String minutes) {
        Integer currentMinute = Integer.parseInt(minutes);

        currentMinute = (int) (double) currentMinute / 5;
        StringBuilder x = new StringBuilder();
        for ( int i = 1; i <= currentMinute; i ++ ) {
            if( i % 3 == 0) {
                x.append("R");
            }else {
                x.append("Y");
            }
        }
        System.out.println(setNullValues(x, 11));
        return setNullValues(x, 11);
    }

    public String convertSingleHours(String hours) {
        Integer currentHour = Integer.parseInt(hours);
        currentHour = currentHour % 10;
        StringBuilder x = new StringBuilder();
        x = getSingleTimeValue(x, "R", currentHour);
        System.out.println(setNullValues(x, 4));
        return setNullValues(x, 4);
    }

    private String setNullValues(StringBuilder x, int i2) {
        for (int i = x.length(); i < i2; i++) {
            x.append("O");
        }
        return x.toString();
    }

    private StringBuilder getSingleTimeValue(StringBuilder x, String append, Integer length) {
        for ( int i = 1; i <= length; i ++ ) {
            x.append(append);
            if (i == 5) {
                x.replace(0,x.length(), "");
            }
        }
        return x;
    }

    public String convertFiveHours(String hours) {
        Integer currentHour = Integer.parseInt(hours);
        currentHour = (int) (double) currentHour / 5;
        StringBuilder x = new StringBuilder();
        for (int i = 1; i <= currentHour; i++) {
            x.append("R");
        }
        System.out.println(setNullValues(x, 4));
        return setNullValues(x, 4);
    }

    public String convertSeconds(String seconds) {
        Integer currentSeconds = Integer.parseInt(seconds);
        String x = "Y";
        for (int i = 1; i <= currentSeconds; i++) {
            x = x.equals("Y") ? "O" : "Y";
        }
        System.out.println(x);
        return x;
    }

    public String convertCompleteDate(String date) {
        String[] d = date.split(":");

        String fh = convertFiveHours(d[0]);
        String sh = convertSingleHours(d[0]);
        String fm = convertFiveMinutes(d[1]);
        String sm = convertSingleMinutes(d[1]);
        String s = convertSeconds(d[2]);

        return s+fh+sh+fm+sm;
    }
}
