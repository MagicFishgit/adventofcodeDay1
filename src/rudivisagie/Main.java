package rudivisagie;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author rudivisagie
 */
public class Main {


    public static void main(String[] args) {

        //Challenge 1
        System.out.println("Day 1 Part 1 answer: " + resltNum().toString());
        // \Challenge 1

        //Challenge 2
        freqFreq();
        // \Challenge 2

    }

    // <--Methods -->

    //Loads data from file and returns data in ArrayList.
    private static ArrayList<Integer> loadData(){

        File file = new File("calibrationData");
        ArrayList<Integer> num = new ArrayList<>();

        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                num.add(input.nextInt());
            }

            input.close();

        }
        catch(FileNotFoundException e){
            System.err.format("Sorry, the file you are trying to access does not exist.\n");
        }
        catch(Exception e){
            System.err.format("An error has occured, please contact your friendly developer for help.");
        }
        return num; //returns arraylist

    }

    //Calculates result
    public static Integer resltNum(){

        int result = 0;
        ArrayList<Integer> num = loadData();
        Iterator itr = num.iterator();

        try {

            while(itr.hasNext()){
                result += (int)itr.next();
            }

        }
        catch(Exception e) {
            System.err.format("An error has occured"); //Could add more specific exceptions later.
        }

        return result;

    }

    //Finds the first freq. that comes up twice.
    /* Note: This was originally meant to return the answer and have an ArrayList
    passed as an argument. The ArrayList would have derived from the loadData()
    method. The idea was to promote code reusability but for some reason iterating
    through that ArrayList messes something up. I dont want to spend 2340443523
    hours figuring out why so now this method returns nothing.
    ~~TODO~~ Figure out why this is the case some point in the future.
    */
    public static void freqFreq(){

        try{
            ArrayList<Integer> freqRec = new ArrayList<>();

            int freq = 0;
            while(true){
                try (BufferedReader buffR = new BufferedReader(
                        new FileReader("calibrationData"))) {
                    String line;
                    while((line = buffR.readLine()) != null){
                        freq += Integer.parseInt(line);
                        if(freqRec.contains(freq)){
                            System.out.println("Day 1 Part 2 answer: " + freq);
                            System.exit(0);
                        }
                        freqRec.add(freq);
                    }   }
            }
        }
        catch(IOException | NumberFormatException e){
            System.err.format("Error in freqFreq. Dont Panic!");
            System.out.println(e);
        }
    }
}
