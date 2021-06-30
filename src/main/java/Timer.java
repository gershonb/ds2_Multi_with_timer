import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Timer {

    long timeSave = -1;
    //DO NOT EDIT EXCEPT WITHIN METHODS

    void start(){
        timeSave = System.currentTimeMillis();
    } // starts or resumes timer (throws an exception if start called after a start without reset
    int stop(){
        if (timeSave != -1) {
            return (int) (timeSave - System.currentTimeMillis());
        }else {
            return -1;
        }
    } // return milliseconds transpired since start was called (stop must be called only after start was called when time is ticking)
    void reset(){
        timeSave = -1;
    } // resets timer to 0 and stops time from transpiring
}