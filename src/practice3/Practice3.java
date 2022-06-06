package practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("숫자 %d: ", i);
            list.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(list);
        System.out.println(list);
    }
}

