package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 올림픽 {

    /*
    1. 금메달 수
    2. 금메달이 같으면 은메달 수
    3. 둘 다 같으면 동메달 수
    공동 2등이 가능하며, 다음 에는 4로 된다.  +1의 순위로 정해짐

    // 이거 배열 정렬을 하면 되는데 조건을 잘 정해야할듯?
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 국가 수
        int m = Integer.parseInt(st.nextToken()); // 타겟 국가 등수

        int[][] country = new int[n][4];
        int target = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());

            }
            if (country[i][0] == m) {
                target = i;

            }
        }

        int rank = 1;
        // 금메달이 작다면


        for (int i = 0; i < n; i++) {

            if (i == target) continue;


            if (country[i][1] > country[target][1]) {
                rank++;

            } else if (country[i][1] == country[target][1] && country[i][2] > country[target][2]) {
                rank++;
            } else if ((country[i][1] == country[target][1] && country[i][2] == country[target][2]
                    && country[i][3] > country[target][3])) {
                rank++;
            }
        }
        System.out.println(rank);



    }
}
