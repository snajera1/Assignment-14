import java.text.DecimalFormat;

public class MetricConverter {
    public static String feetToMeter(double f){ //Each of these is a static method used to preform a metric conversion on a given number
        DecimalFormat df = new DecimalFormat("#.##"); //Uses an object from the DecimalFormat class to round the result to make it presentable
        return (df.format(f / 3.28084)) + " meters";
    }

    public static String inchToCM(double i){
        DecimalFormat df = new DecimalFormat("#.##");
        return (df.format(i * 2.54)) + " CM";
    }

    public static String milesToKM(double m){
        DecimalFormat df = new DecimalFormat("#.##");
        return (df.format(m * 1.6093445)) + " KM";
    }

    public static String mmToInches(double m){
        DecimalFormat df = new DecimalFormat("#.##");
        return (df.format(m / 25.4)) + " inches";
    }

}
