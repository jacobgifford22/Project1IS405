// Authors: Jacob Gifford, Jake Reynolds, Madaleine Osmun, Melissa Robles, Yuze Dong

// Note: This program takes a .csv file of names as an input, and outputs a .csv file of teams

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    // input .csv file
    public static void main(String[] args) throws IOException {    
    String token1 = "";

    Scanner inFile1 = new Scanner(new File("names.csv")).useDelimiter(",");

    ArrayList<String> names = new ArrayList<String>();

    while (inFile1.hasNextLine()) {
        token1 = inFile1.nextLine();
        names.add(token1);
    }
    inFile1.close();

    // process

    // create HashMap
    HashMap<String, String> nameTeams = new HashMap<String, String>();

    // user input for number of teams
    Scanner inputTeams = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter number of teams: ");
    Integer numTeams = inputTeams.nextInt();  // Read user input
    inputTeams.close();

    int counter = 1;

    // randomization process
    while (names.size() > 0) {
        for (int i = 1; i <= numTeams; i++) {
            int numNames = names.size(); 
            
            if (names.size() > 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, numNames);
                // gets a random name from the arraylist    
                String currentName = names.get(randomNum);
                String team = String.valueOf(i);
                String teamMembers = "";

                if (counter > numTeams) {
                    teamMembers = nameTeams.get(team) + "," + currentName;
                }
                else {
                    teamMembers = currentName;
                }

                nameTeams.put(team, teamMembers);
                names.remove(randomNum);
            }
            else {
                break;
            }
            counter += 1;
        }
    }

    System.out.println(nameTeams);

    String eol = System.getProperty("line.separator");

    try (Writer writer = new FileWriter("teams.csv")) {
    for (Map.Entry<String, String> entry : nameTeams.entrySet()) {
        writer.append(entry.getKey())
            .append(',')
            .append(entry.getValue())
            .append(eol);
    }
    } catch (IOException ex) {
    ex.printStackTrace(System.err);
    }

    }
}

