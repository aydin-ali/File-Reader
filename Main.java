/** This program allows the user to analyze objects in an array
 * The objects are different types of media files that have been read from a text file
 * @author aydin-ali kachra
 * @version 1
 */

/*
"reading text from a file" code to load the objects into the array is inspired by this video:
Lee, A. (2020, June 18). Java: Read a CSV File into an Array. Retrieved January 8, 2021, from
    https://www.youtube.com/watch?v=-Aud0cDh-J8&t=671s
*/

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        //welcome to the program
        System.out.println("Welcome to the media file program! \n" +
                "This programs allows you to play around with a list of different media file objects on Aydin's laptop. \n" +
                "Please wait a moment while the data is loaded into the system...");
        System.out.println("");

        //initializing the array variables for the objects
        int arraySize;
        Media[] mediaArray = new Media[0];
        int index = 0;

        //loading the file path into the program before reading the text
        String path = "/Users/aydin-alikachra/IdeaProjects/OOP Project/src/objectInfo.txt";
        String line;

        //loading the listings from text file into an array
        //beginning of "reading text from a file" code
        BufferedReader br = new BufferedReader(new FileReader(path));

        //loop to parse through the file until there's no more lines left
        while((line = br.readLine()) != null) {
            String[] values = line.split(", "); //splits words in the same line using the regex: ", "

            //checking the first value of the line to determine what to do with it: a number = array size, word = object type
            if (values[0].matches("[0-9]")) {
                arraySize = Integer.parseInt(values[0]);
                mediaArray = new Media[arraySize];
            } else if (values[0].equals("Photo")) {
                mediaArray[index] = new Photo(values[1], (values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));
                index++;
            } else if (values[0].equals("Video")) {
                mediaArray[index] = new Video(values[1], (values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), values[5]);
                index++;
            } else if (values[0].equals("Music")) {
                mediaArray[index] = new Music(values[1], (values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), values[5], values[6]);
                index++;
            }
        }
        //end of "reading text from a file" code

        //initializing variables for the program's menu
        String menuOption;
        int runCounter = -1;
        String menu = "A) Compare two entries in the list. \n" +
                "B) Display the list of media files. \n" +
                "C) Display a specific media file. \n" +
                "D) Calculate the total storage of all of the media files. \n" +
                "E) Quit the program.";

        //loop to run the menu until the user quits
        do {
            //different menu intro for 1st loop vs. iterations
            if (runCounter == -1) {
                System.out.println("All the data has been loaded! \n" +
                        "The following is the menu for this program:");
            } else {
                System.out.println("You are back at the menu for the program. Here are the options again:");
            }

            //printing out the menu
            System.out.println(menu);
            System.out.println("");

            //user input for menu
            System.out.print("Which option would you like to execute? (please only enter a capital letter from A-E): ");
            menuOption = in.nextLine();
            System.out.println("");

            //counting iterations of the program
            runCounter++;

            //operations for each menu option based on their stated fns
            //when asking for an index, assumes that the user doesn't know that indices start at 0
            if (menuOption.equals("A")) {
                int mediaFile1;
                int mediaFile2;

                //loops to ensure a valid index is inputted
                do {
                    System.out.print("Which index would you like to compare? (please only enter a digit from 1-5): ");
                    mediaFile1 = in.nextInt();
                    System.out.println("");
                    if (0 > mediaFile1 || 5 < mediaFile1) {
                        System.out.println("You entered an invalid index option. Please only enter a digit from 1-5.");
                        System.out.println("");
                    }
                } while(1 > mediaFile1 || 5 < mediaFile1);

                //loops to ensure a valid index is inputted
                do {
                    System.out.print("Which index would you like to compare the last index to? (please only enter a digit from 1-5): ");
                    mediaFile2 = in.nextInt();
                    System.out.println("");
                    if (1 > mediaFile2 || 5 < mediaFile2) {
                        System.out.println("You entered an invalid index option. Please only enter a digit from 1-5.");
                        System.out.println("");
                    }
                } while(1 > mediaFile2 || 5 < mediaFile2);

                if (mediaArray[mediaFile1 - 1].equals(mediaArray[mediaFile2 - 1])) {
                    System.out.println("The indexes are equal!");
                } else {
                    System.out.println("The indexes are not equal.");
                }
                in.nextLine();
            } else if (menuOption.equals("B")) {
                for (int i = 0; i < mediaArray.length; i++) {
                    System.out.println((i + 1) + ". " + mediaArray[i]);
                }
            } else if (menuOption.equals("C")) {
                int indexOption;

                //loops to ensure a valid index is inputted
                do {
                    System.out.print("Which index would you like to display? (please only enter a digit from 1-5): ");
                    indexOption = in.nextInt();
                    System.out.println("");
                    if (1 > indexOption || 5 < indexOption) {
                        System.out.println("You entered an invalid index option. Please only enter a digit from 1-5.");
                        System.out.println("");
                    }
                } while(1 > indexOption || 5 < indexOption);

                System.out.println(mediaArray[indexOption - 1]);
                in.nextLine();
            } else if (menuOption.equals("D")) {
                double totalStorage = 0.0;

                for (int i = 0; i < mediaArray.length; i++) {
                    totalStorage += mediaArray[i].getFileSize();
                }

                System.out.println("The total storage of all the files is: " + totalStorage + " MB.");
            } else if (menuOption.equals("E")) {
                System.out.println("You have now quit the program. You completed " + runCounter + " operations with the media files. \n" +
                        "Thank you for using the media file program!");
            } else {
                System.out.println("You entered an invalid menu option. Please retake a look a the menu and enter a capital letter from A-E.");
                runCounter--; //doesn't count as a real iteration
            }
            System.out.println("");
        } while (!(menuOption.equals("E")));
    }
}