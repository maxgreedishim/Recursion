import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
	    int [] array = new int[]{11,55,44,66,33,77,66,-101,111};
        sort(array,0,array.length -1);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] array,int from, int to){
        if (!(from < to)) return;
        int middle = (from + to) / 2;
        //System.out.println("middle %s".formatted(middle));
        sort(array,from,middle);
        sort(array,middle +1,to);
        merge(array,from,middle,to);
    }
    public static void merge(int[] array,int from,int middle, int to){
        int maxLeft = array[from]; // наибольшее число в левой половине
        int maxLeftIndex = from; // индекс ячейки с наибольшим числом
        for(int i = from; i <= middle; i++){
            if(array[i] <= maxLeft) continue; // числа меньше максимального нас не интерисуют
            maxLeft = array[i]; // запоменае новое наибольшее число которое вытесняло предыдущие
            maxLeftIndex = i; // и его индекс
        }
        for (int i = middle + 1; i <= to; i++){
            if (array[i] >= maxLeft) continue;// числа больше максимального нас не интерисуют
            array[maxLeftIndex] = array[i];// меняем в левой части наибольшее на найденное
            array[i] = maxLeft;// помещаем большее число из левой половины в правую
            sort(array,from,to); // отправляем на пересортировку
            break;
        }
    }
}
