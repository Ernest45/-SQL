package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 개미 {
    /* 떨어진 개미 무리가 있고, 둘이 서로 뱐대로 움직인다.
    움직이다 서로 만나면 바로 앞에 서로 다른 무리일 경우 서로 자리교체한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String leftAnt = br.readLine();
        String rightAnt = br.readLine();
        int t = Integer.parseInt(br.readLine());
        br.close();

        char[] reverse = leftAnt.toCharArray();
        swap(reverse);

        int totalAnt = leftAnt.length() + rightAnt.length();

        char[] ants = new char[totalAnt];

        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i <totalAnt; i++) {

            if(i < n) {
                ants[i] = reverse[i];
                map.put(ants[i], true);}
            else{
                ants[i] = rightAnt.charAt(i - n);
                map.put(ants[i], false);
            }
        }

        for (int i = 0; i < t; i++) {
            int j = 0;
            while (j < totalAnt - 1) {

                if (map.get(ants[j]) && !map.get(ants[j + 1])) {
                    //교차할 수 있는 가능성은
                    // 무조건 왼쪽 개미부터 시작해야하고,오른쪽으로 가야함(트루여야하고)
                    //바로 옆 개미는 왼쪽으로 움직여야함(false)

                    char tempAnt = ants[j];
                    ants[j] = ants[j + 1];
                    ants[j + 1] = tempAnt;

                    j = j + 2;
                    // 바꿨다면 바로 +1개미는 또 본인이 될 수 있으니 +2로 마무리

                } else {
                    j++; //아니면 바로 옆 개미 찾아보기
                }
            }
        }

        for (int i = 0; i < ants.length; i++) {
            System.out.print(ants[i]);

        }


    }
    private static void swap(char[] reverse) {
        int left= 0;
        int right = reverse.length -1;
        while (left < right) {
            char temp = reverse[left];
            reverse[left] = reverse[right];
            reverse[right] = temp;
            left++;
            right--;
        }

    }


}
