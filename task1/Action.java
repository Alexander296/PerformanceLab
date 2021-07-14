import java.util.Collections;
import java.util.List;

public class Action {

    public static void sort(List<Integer> list) {
       Collections.sort(list);
    }

    public static float minValueOfSortedArray(List<Integer> list) {
        return (float) list.get(0);
    }

    public static float maxValueOfSortedArray(List<Integer> list){
        return (float) list.get(list.size() - 1);
    }

    public static float average(List<Integer> list){
        int av = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            av += list.get(i);
        }
        return (float) av/size;
    }

    public static float median(List<Integer> list) {
        int countNumbers = list.size();
        float med;
        if (countNumbers % 2 == 0) {
            int a = countNumbers / 2;
            float x1 = list.get(a - 1);
            float x2 = list.get(a);
            med = (x1 + x2) / 2;
        }
        else {
            med = (float) list.get(countNumbers/2);
        }
        return med;
    }

    public static float percentile(List<Integer> list) {
        float index = (((float)90 / 100) * (list.size() - 1)) + 1;
        int whole = (int)Math.floor(index);
        float fract = index - whole;
        return list.get(whole - 1) + (fract * (list.get(whole) - list.get(whole - 1)));
    }
}
