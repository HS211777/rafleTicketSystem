package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static ArrayList<Integer> nums = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<Integer> tickets = new ArrayList<>();

    public static void main(String[] args) {
        createNumsArray();
        boolean end = false;
        while (!end) {
            mainmenu();
            int choice = 0;
            try{
                boolean valid = false;
                while(!valid){
                    choice = Integer.parseInt(input());
                    valid = true;
                }
            }
            catch (Exception e){
                System.out.println("Error "+e);
            }
            switch (choice) {
                case 1:
                    buyTickets();
                    break;
                case 2:
                    if (checkTickets()) {
                        System.out.println("You win a prize");
                    }
                    else{
                        System.out.println("You do not win");
                    }
                    break;
                case 3:
                    end = true;
                    break;
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }

    public static void createNumsArray() {
        for (int i = 0; i < 500; i++) {
            nums.add(i + 1);
        }
        Collections.shuffle(nums);
    }

    public static void buyTickets() {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Enter your Name");
                String name = input();
                names.add(name);
                valid = true;
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        System.out.println("your number is: "+nums.get(0));
        tickets.add(nums.get(0));
        nums.remove(0);
    }

    public static void mainmenu() {
        System.out.println("Menu:");
        System.out.println("1 - Buy Ticket");
        System.out.println("2 - Check Tickets");
        System.out.println("3 - Exit");
    }

    public static boolean checkTickets() {
        System.out.println("Enter your name:");
        String name = input();
        System.out.println("Enter ticket number:");
        int ticketNum = 0;
        try{
            boolean valid = false;
            while (!valid){
                ticketNum = Integer.parseInt(input());
                valid = true;
            }
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
        boolean validName = false;
        int nameKey = -1;
        boolean validNum = false;
        int numkey = -1;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                validName = true;
                nameKey = i;
            }
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i) == ticketNum) {
                validNum = true;
                numkey = i;
            }
        }
        return isPrime(numkey,verifyTicket(validName,validNum,nameKey,numkey));
    }

    public static String input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        String out = "";
        try{
            while (!valid){
                out = br.readLine();
                valid = true;
            }
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
        return out;
    }
    public static boolean isPrime(int numkey, boolean valid){
        boolean prime = false;
        if (valid) {
            if (tickets.get(numkey) != 1) {
                for (int i = 2; i < tickets.get(numkey); i++) {
                    if (tickets.get(numkey) % i == 0) {
                        prime = false;
                        break;
                    }
                    else{
                        prime = true;
                    }
                }
            }
        }
        return prime;
    }
    public static boolean verifyTicket(boolean validName, boolean validNum, int nameKey, int numkey){
        boolean valid = false;
        if (validName && validNum) {
            if (numkey == nameKey) {
                System.out.println("Your name and ticket number are correct");
                valid = true;
            } else {
                System.out.println("Your name and ticket number do not match");
            }
        } else {
            System.out.println("Either your name or ticket number is not on our database");
        }
        return valid;
    }
    //if raffle number is prime the person won a prize
}
