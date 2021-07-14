import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Rectangle parserRectangle(String str) {
        FileReader reader = null;
        try {
            reader = new FileReader(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Rectangle rectangle = new Rectangle();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String tmp = line;
                tmp = tmp.split("\\\\", 2)[0];
                String[] tox = tmp.split(" ", 2);
                rectangle.setCoordinates(Float.parseFloat(tox[0]), Float.parseFloat(tox[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (rectangle);
    }


    public static void parseAndCheckPoints(Rectangle rectangle, String str) {
        FileReader reader = null;
        try {
            reader = new FileReader(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String tmp = line;
                tmp = tmp.split("\\\\", 2)[0];
                String[] tox = tmp.split(" ", 2);
                float x = Float.parseFloat(tox[0]);
                float y = Float.parseFloat(tox[1]);
                if (rectangle.checkPointOfVertex(x, y))
                    System.out.println("" + 0);
                else if (rectangle.checkPointOnTheEdge(x, y))
                    System.out.println("" + 1);
                else if (rectangle.checkPointInRectangle(x, y))
                    System.out.println("" + 2);
                else
                    System.out.println("" + 3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = parserRectangle(args[0]);
        parseAndCheckPoints(rectangle, args[1]);
    }
}
