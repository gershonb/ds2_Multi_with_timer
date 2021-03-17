import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Timer {


    //DO NOT EDIT EXCEPT WITHIN METHODS
    
    public void start(){
        //code here

        try {
            File myObj = new File("startBool.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("1")){
                    throw new IllegalArgumentException("Cannot start after a start without a reset");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String startTime = Long.toString(System.currentTimeMillis());
        try {
            FileWriter myWriter = new FileWriter("startTime.txt");
            FileWriter myWriter2 = new FileWriter("startBool.txt");
            myWriter.write(startTime);
            myWriter2.write("1");
            myWriter.close();
            myWriter2.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public long stop(){
        //code here
        long endTime = 0;
        try {
            File myObj = new File("startTime.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                endTime = Long.parseLong(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter2 = new FileWriter("startBool.txt", false);
            myWriter2.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return endTime;
    }

    public void reset(){
        //code here
        try {
            FileWriter myWriter = new FileWriter("startTime.txt", false);
            FileWriter myWriter2 = new FileWriter("startBool.txt", false);
            myWriter.close();
            myWriter2.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}