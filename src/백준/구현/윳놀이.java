package 백준.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 윳놀이 {
    //주어진 0 0 0 0 의 정보로 a b c d인지 정해라
    //뒤집어진 갯수에 따라 도개걸윳모인지 정하는 거 0이 배, 1이 등

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String temp;

        while ((temp = br.readLine()) != null) {
            st = new StringTokenizer(temp, " ");
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 0) {
                    count++;
                }
            }
            switch(count) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;

                case 2:
                    System.out.println("B");
                    break;

                case 3:
                    System.out.println("C");
                    break;

                case 4:
                    System.out.println("D");
                    break;
            }

        }



    }
}
