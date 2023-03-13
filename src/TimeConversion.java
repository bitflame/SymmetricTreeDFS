

public class TimeConversion {
    public static String timeConversion(String s) {
        if (s.endsWith("PM")) {
            s = s.replace("PM", "");
            int hour = Integer.parseInt(s.split(":")[0]);
            if (hour < 12) hour += 12;
            s = s.replaceFirst(s.split(":")[0], String.valueOf(hour));

        } else if (s.endsWith("AM")) {// ends with am
            s = s.replace("AM", "");
            int hour = Integer.parseInt(s.split(":")[0]);
            if (hour == 12) {
                s = s.replaceFirst(s.split(":")[0], "00");
            }
        }

        return s;
    }

    public static void main(String[] args) {

        String s1 = "12:00:01AM";
        String s2 = "12:00:01PM";
        String s3 = "01:00:00AM";
        String s4 = "01:00:01AM";
        String s5 = "01:00:01PM";
        System.out.println("Excepting 00:00:01 for 12:00:01AM Getting: " + timeConversion(s1));
        System.out.println("Excepting 12:00:01 for 12:00:01PM Getting: " + timeConversion(s2));
        System.out.println("Excepting 01:00:00 for 01:00:00AM Getting: " + timeConversion(s3));
        System.out.println("Excepting 01:00:01 for 01:00:01AM Getting: " + timeConversion(s4));
        System.out.println("Excepting 13:00:01 for 01:00:01PM Getting: " + timeConversion(s5));
        String s6 = "12:40:22AM"; // Expecting 00:40:22
        System.out.println("Excepting  00:40:22 for 12:40:22AM Getting: " + timeConversion(s6));
        String s7 = "12:05:39AM"; // Expecting 00:05:39
        System.out.println("Excepting  00:05:39 for 12:05:39AM Getting: " + timeConversion(s7));
        String s8 = "12:00:00AM"; // Expecting 00:00:00
        System.out.println("Excepting  00:00:00 for 12:00:00AM Getting: " + timeConversion(s8));
    }
}
