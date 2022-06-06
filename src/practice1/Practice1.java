package practice1;

import java.io.*;

public class Practice1 {

    static int adder(int a, int b){
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("첫번째 숫자를 입력해주세요 : ");
        int a = Integer.parseInt(reader.readLine());
        System.out.printf("두번째 숫자를 입력해주세요 : ");
        int b = Integer.parseInt(reader.readLine());

        System.out.println("결과 : " + adder(a,b));
    }
}
