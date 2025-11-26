package src.FlowerOrderSystem;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

public class ChckOut {
    public static void main(String[] args) throws InvalidInputException {
        LocalDateTime orderID = LocalDateTime.now();
        User user;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy hh:mm a");
        String formatted = orderID.format(formatter);
        System.out.println("Today's date is " + formatted);
    }


}