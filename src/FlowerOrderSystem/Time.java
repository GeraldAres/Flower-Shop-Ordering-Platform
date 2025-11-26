package src.FlowerOrderSystem;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
public class Time {
    Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
       LocalDateTime date = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy hh:mm a");
       String formatted = date.format(formatter);
       System.out.println("Today's date is " + formatted);
   }


}

