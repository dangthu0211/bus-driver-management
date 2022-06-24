package Function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BinaryIO {

	public static <T> boolean writeToFile(ArrayList<T> obj, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(obj);
            oout.close();
            fout.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
    public static <T> ArrayList<T> readFromFile(ArrayList<T> obj, String fileName) {
        try{
            FileInputStream finp = new FileInputStream(fileName);
            ObjectInputStream oinp = new ObjectInputStream(finp);
            obj = (ArrayList<T>) oinp.readObject();
            oinp.close();
            finp.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public static void readBusDriver() {
    	Handling.BUSDRIVERS = readFromFile(Handling.BUSDRIVERS, "busDriver.dat");
    	System.out.print("Hiện danh sách lái xe đã đọc từ file (true-Có, false-Không): ");
        boolean check = new Scanner(System.in).nextBoolean();
        if(check) {
        	Handling.showListObjs(Handling.BUSDRIVERS);
        }
    }
    
    public static void readRoute() {
    	Handling.ROUTES = readFromFile(Handling.ROUTES, "route.dat");
    	System.out.print("Hiện danh sách tuyến đã đọc từ file (true-Có, false-Không): ");
        boolean check = new Scanner(System.in).nextBoolean();
        if(check) {
        	Handling.showListObjs(Handling.ROUTES);
        }
    }
    
    public static void readAssignment() {
    	Handling.ASSIGNMENTS = readFromFile(Handling.ASSIGNMENTS, "assignment.dat");
    	System.out.print("Hiện danh sách bảng phân công đã đọc từ file (true-Có, false-Không): ");
        boolean check = new Scanner(System.in).nextBoolean();
        if(check) {
        	Handling.showListObjs(Handling.ASSIGNMENTS);
        }
    }
    
}
