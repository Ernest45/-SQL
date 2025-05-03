package 백준.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 세로읽기  {
    //최대 15열을 가지는 알파벳 조합을 가지는 5열을 만드는 것
    // 널이 들어가는 걸로 하면 좋겠다 빈칸이 나오면 안 넣ㄹ을수도 있으니
    // 일단 뒤집엇거 넣어서 읽을 때 제대로 읽는 방법이 떠오르고
    // 두번째는 그대로 넣고 읽을 때 바꿔서 읽기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[][] arr = new Character[5][15];

        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                arr[i][j] = a.charAt(j);

            }
        }

        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != null) {
                    sb.append(arr[j][i]);

                }
            }
        }
        bw.write(sb.toString());
        bw.flush(); // 출력 버퍼 비우기





    }
}
