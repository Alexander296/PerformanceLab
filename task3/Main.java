import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_INTERVALS = 16;
    private static final double EPS = 0.0000001; // точность сравнения вещественных чисел

    private static void readFile(String filePath, List<Double> l) {
        File file = new File(filePath);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.err.println("\nФайл не найден!\n" + e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;

        try {
            while ((line = br.readLine()) != null) {
                try {
                    l.add(Double.parseDouble(line));
                } catch (NumberFormatException e) {
                    System.err.println("\nВо введенных значениях встретились НЕ числа! :\n" + e + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("IOException\n" + e + "\n");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String OS = System.getProperty("os.name").toLowerCase();
        String prefix;

        if (OS.indexOf("win") >= 0) prefix = "\\";
        else if (OS.indexOf("mac") >= 0) prefix = "/";
        else if ((OS.indexOf("nix") >= 0) || (OS.indexOf("nux") >= 0)) prefix = "/";
        else prefix = "/";

        String folderPath = args[0];
        String filePath1 = folderPath + prefix + "Cash1.txt";
        String filePath2 = folderPath + prefix + "Cash2.txt";
        String filePath3 = folderPath + prefix + "Cash3.txt";
        String filePath4 = folderPath + prefix + "Cash4.txt";
        String filePath5 = folderPath + prefix + "Cash5.txt";

        List <Double> list1 = new ArrayList<>();
        List <Double> list2 = new ArrayList<>();
        List <Double> list3 = new ArrayList<>();
        List <Double> list4 = new ArrayList<>();
        List <Double> list5 = new ArrayList<>();
        List <Double> sumList = new ArrayList<>();

        readFile(filePath1, list1);
        readFile(filePath2, list2);
        readFile(filePath3, list3);
        readFile(filePath4, list4);
        readFile(filePath5, list5);
        for (int i = 0; i < NUMBER_INTERVALS; i++) {
            sumList.add(i,
                    (list1.get(i) + list2.get(i) + list3.get(i)+ list4.get(i) + list5.get(i)));
        }
        Double max = 0.0;
        for (int i = 0; i < sumList.size(); i++) {
            if ((sumList.get(i) > max) &&
                    (Math.abs(max - sumList.get(i)) > EPS))
                max = sumList.get(i);
        }
        int maxNumber = sumList.indexOf(max) + 1;
        System.out.println(maxNumber);
    }
}
