package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알람시계 {
    // 쉽다 접근하는 시간보다 45분 땡기면 됨
    /*
    1. 일단 분이 45를 빼도 음수가 나오는지 아닌지
    2. 45뻈을 때 음수라면,시를 뺴주기
    3. 시를 뻈을 때 00인지 아닌지
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String time = br.readLine();
        String times[];

        times = time.split(" ");

        int h = Integer.parseInt(times[0]);
        int m = Integer.parseInt(times[1]);

        if (m - 45 >= 0 ) {
            m = m - 45;
            sb.append(h).append(" ").append(m);

        } else {
            m = 60 - Math.abs(m - 45);
            if (h - 1 >= 0) {
                h = h - 1;
                sb.append(h).append(" ").append(m);

            } else {
                h = 24 - Math.abs(h - 1);
                sb.append(h).append(" ").append(m);

            }

        }








        System.out.println(sb);
    }


}
