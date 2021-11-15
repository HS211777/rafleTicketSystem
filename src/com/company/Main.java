package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    private static ArrayList<Integer> nums = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<Integer> tickets = new ArrayList<>();

    public static void main(String[] args) {
        createNumsArray();
        boolean end = false;
        while(!end){
            mainmenu();
            int choice = Integer.parseInt(input());
            switch (choice){
                case 1:
                    buyTickets();
                    break;
                case 2:
                    if (checkTickets()){
                        System.out.println("you win a prize");
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
    public static void createNumsArray(){
        for (int i = 0; i < 500; i++){
            nums.add(i+1);
        }
        Collections.shuffle(nums);
    }
    public static void buyTickets(){
        boolean valid = false;
        while (!valid){
            try{
                System.out.println("Enter your Name");
                String name = input();
                names.add(name);
                valid = true;
            }
            catch(Exception e){
                System.out.println("Error "+e);
            }
        }
        tickets.add(nums.get(0));
        nums.remove(0);
    }
    public static void mainmenu(){
        System.out.println("Menu:");
        System.out.println("1 - Buy Ticket");
        System.out.println("2 - Check Tickets");
        System.out.println("3 - Exit");
    }
    public static boolean checkTickets(){
        System.out.println("Enter your name:");
        String name = input()
        System.out.println("Enter ticket number:");
        int ticketNum = Integer.parseInt(input());
        boolean validName = false;
        int nameKey = -1;
        boolean validNum = false;
        int numkey = -1;
        for (int i = 0; i < names.size(); i++){
            if (names.get(i).equalsIgnoreCase(name)){
                validName = true;
                nameKey = i;
            }
        }
        for (int i = 0; i < tickets.size(); i++){
            if (tickets.get(i) == ticketNum){
                validNum = true;
                numkey = i;
            }
        }
        boolean valid = false;
        if (validName && validNum){
            if (numkey == nameKey){
                System.out.println("Your name and ticekt number are correct");
                valid = true;
            }
            else{
                System.out.println("either your name and ticket number do not match");
            }
        }
        else{
            System.out.println("either your name or ticket number is not on our database");
        }
        
    }
    public static String input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
    //store names and raffle numbers in 2 lists
    //if raffle number is prime the person won a prize
}
