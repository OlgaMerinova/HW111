//1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HW1 {
    static int getRandomI() {
        return new Random().nextInt(2000) - 0;
    }

    static int getMostSignificantBit(int n) {
        int index = (int) (Math.log(n) / Math.log(2));
        return index;
    }

    static int[] findDividers(int start, int end, int target, boolean positive) {
        ArrayList<Integer> output = new ArrayList<Integer>();

        for (int index = start; index <= end; index++) {
            if (target != 0 &&
                    positive &&
                    index % target == 0) {
                output.add(index);
            }
            if (target != 0 &&
                    !positive &&
                    index % target != 0) {
                output.add(index);
            }
        }

        int[] intOutput = new int[output.size()];
        for (int index = 0; index < output.size(); index++) {
            intOutput[index] = output.get(index);
        }

        return intOutput;
    }

    public static void main(String[] args) {

        int i = getRandomI();
        System.out.println("i = " + i);

        int n = getMostSignificantBit(Math.abs(i));
        System.out.println("n = " + n);


        int[] m1 = findDividers(i, Short.MAX_VALUE, n, true);
        System.out.println("m1 = " + Arrays.toString(m1));

        int[] m2 = findDividers(Short.MIN_VALUE, i, n, false);
        System.out.println("m2 = " + Arrays.toString(m2));
    }
}

