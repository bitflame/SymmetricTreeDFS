

public class TimeConversion {
    public static String timeConversion(String s){
        if (s.endsWith("PM")){
            s = s.replace("PM","");
            int hour = Integer.parseInt(s.split(":")[0])-12;
            if (hour<10) {
                s = s.replace(s.split(":")[0],"0"+hour);
            } else {
                s = s.replace(s.split(":")[0],String.valueOf(hour));
            }


        } else if (s.endsWith("AM")){
            s = s.replace("AM","");

        }
        return s;
    }

    public static void main(String[] args) {

        String s1 = "12:00:01AM";
        String s2 = "12:00:01PM";
        System.out.println("Excepting 00:00:01 Getting: "+timeConversion(s1));
        System.out.println("Excepting 00:00:01 Getting: "+timeConversion(s2));
    }
}
