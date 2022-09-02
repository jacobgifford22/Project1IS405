import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    // input .csv file
    public static void main(String[] args) throws IOException {    
    String token1 = "";

    Scanner inFile1 = new Scanner(new File("names.csv")).useDelimiter(",");

    List<String> names = new ArrayList<String>();

    while (inFile1.hasNext()) {
        token1 = inFile1.next();
        names.add(token1);
    }
    inFile1.close();

    String[] namesArray = names.toArray(new String[0]);

    for (String s : namesArray) {
        System.out.println(s);
    }

    // process
    // create HashMap
    HashMap<Integer, String> nameTeams = new HashMap<Integer, String>();

    // user input for number of teams
    Scanner inputTeams = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter number of teams: ");

    Integer numTeams = inputTeams.nextInt();  // Read user input
    System.out.println(numTeams);  // Output user input

    // TODO: randomization process here

    for (String s : namesArray) {

    }
    nameTeams.put(1, "USA");
    System.out.println(nameTeams);

    // create output .csv file
    try {
        File myObj = new File("teams.csv");
        if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        } else {
        System.out.println("File already exists.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    // write to output file
    try {
        FileWriter myWriter = new FileWriter("teams.csv");
        for (String s : namesArray) {
            myWriter.write(s);
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }
}

