
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ApplicationRunner {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String file = System.getProperty("user.dir") + File.separator + "lexicon.txt";

        ArrayList<String> anagrams = new ArrayList<>();

        System.out.println("Please enter a string (single word or phrase)");
        System.out.print("> ");

        String initialInput = input.nextLine();

        String userinput = initialInput.replaceAll("\\s+", ""); //removing the spaces
        char[] inputArray = userinput.toLowerCase().toCharArray();
        Arrays.sort(inputArray);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String content;
            while ((content = reader.readLine()) != null) {

                char[] filearray = content.toLowerCase().toCharArray();
                Arrays.sort(filearray);
                if (Arrays.equals(filearray, inputArray)) {
                    anagrams.add(content);
                }
            }
        } catch (IOException ex) {
            System.out.println("Dictionary file not found");
        }

        System.out.print("Possible anagrams for " + "\"" + initialInput + "\"" + ": ");
        System.out.println(anagrams);

        mainMenu();
    }

    //menu where the user can choose to replay or quit the program
    public static void mainMenu() {

        System.out.print("Try again (1) or Exit (0) > ");
        String playOrExit = input.nextLine();

        if (null == playOrExit) {
            System.out.println("Invalid input. Please choose 1 or 0");
        } else {
            switch (playOrExit) {
                case "1":
                    main(null);
                    break;
                case "0":
                    System.out.println("Program Closed");
                    break;
                default:
                    System.out.println("Invalid input. Please choose 1 or 0");
                    mainMenu();
                    break;
            }
        }
    }
}
