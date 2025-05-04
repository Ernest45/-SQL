package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도로와신호등 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] sign = new int[T][3];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {

                sign[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        int answer = 0;

        for (int i = 0; i < L; i++) {

            if (idx < T && sign[idx][0] == i) {
                int red = sign[idx][1];
                int green = sign[idx][2];

                int cycle = red + green; // 총 사이클을 구해야함
                int currTime = answer % cycle;

                if(currTime <red) { // 현재 시간에 레드라면 ?
                    answer = answer + (red - currTime);
                    //red가 바뀔 시간까지 기다리기 (시간은 감
                }
                idx++;
            }
            answer++;
        }
        System.out.println(answer);

    }
}
