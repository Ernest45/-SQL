package 백준.대기업코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4 {

    //23971
    //3가지 경우 현재 자리에서 행더하기, 열 더하기 둘다 더하기는 못감

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        int cols = (W + M) / (M + 1);
        int rows = (H + N) / (N + 1);
        int max_Students = cols * rows;
        System.out.println(max_Students);

        }

    }

