package practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice4 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while (true){
            System.out.printf("숫자 %d: ",++count);
            int i = Integer.parseInt(reader.readLine());
            if (i == 0) {
                System.out.println("결과 : " + list);
                break;
            }
            list.add(i);
        }
    }
}

