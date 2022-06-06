package practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    static int adder(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("숫자 %d: ", i);
            list.add(Integer.parseInt(reader.readLine()));
        }

        System.out.println("결과 : " + adder(list));
    }
}

