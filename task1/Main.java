import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        File file = new File(args[0]);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(fr);
        String line;
        try {
            while ((line = in.readLine()) != null) {
                try {
                    arrayList.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.err.println("\nНе числа:\n" + e + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Action.sort(arrayList);
        System.out.printf("%.2f\n", Action.percentile(arrayList));
        System.out.printf("%.2f\n", Action.median(arrayList));
        System.out.printf("%.2f\n", Action.maxValueOfSortedArray(arrayList));
        System.out.printf("%.2f\n", Action.minValueOfSortedArray(arrayList));
        System.out.printf("%.2f\n", Action.average(arrayList));
    }
}
