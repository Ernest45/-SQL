package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 킹 {
    //열은 가장 왼쪽 열이 A이고, 가장 오른쪽 열이 H까지 이고,
    // 행은 가장 아래가 1이고 가장 위가 8이다. 예를 들어, 왼쪽 아래 코너는 A1이고, 그 오른쪽 칸은 B1이다.


    static Map<String, int[]> directionMap = new HashMap<>();

    static {
        directionMap.put("R", new int[]{0, 1});
        directionMap.put("L", new int[]{0, -1});
        directionMap.put("B", new int[]{-1, 0});
        directionMap.put("T", new int[]{1, 0});
        directionMap.put("RT", new int[]{1, 1});
        directionMap.put("LT", new int[]{1, -1});
        directionMap.put("RB", new int[]{-1, 1});
        directionMap.put("LB", new int[]{-1, -1});
    }

    //1. a를 행으로치환, 숫자를 열로
    //2.  생각할 것 돌이 있는데 돌로 움직이게 될 경우 온 방향대로 같이 밀어냄
    //3. 돌이나 내가 체스판 밖으로 나갈 경우 그 움직임은 끝나고 담 움직임 하면 됨


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String position = st.nextToken();
        String stone = st.nextToken();
        int number = Integer.parseInt(st.nextToken());

        int chess[][] = new int[10][10];

        //1. a를 행으로치환, 숫자를 열로

        int pCol = position.charAt(0) - 'A' + 1; //열
        int pRow = position.charAt(1) - '0'; // 행


        int sCol = stone.charAt(0) - 'A' + 1;
        int sRow = stone.charAt(1) - '0';




        chess[pRow][pCol] = 2; // 내 위치
        chess[sRow][sCol] = 3; // 돌 위치

        for (int i = 0; i < 10; i++) {
            chess[0][i] = 1;
            chess[i][0] = 1;
            chess[9][i] = 1;
            chess[i][9] = 1;

        }
        int now = 0;
        while (now < number) {
            String movement = br.readLine();

            int[] dir = directionMap.get(movement);
            int addRow = dir[0];
            int addCol = dir[1];

            if (chess[pRow +addRow][pCol + addCol] == 0) {

                chess[pRow][pCol] = 0;
                chess[pRow + addRow][pCol + addCol] = 2;
                pRow = pRow + addRow;
                pCol = pCol + addCol;

            } else if (chess[pRow + addRow][pCol + addCol] == 3 &&
                    chess[sRow + addRow][sCol + addCol] == 0) {


                chess[sRow + addRow][sCol + addCol] = 3;
                sRow += addRow;
                sCol += addCol;

                chess[pRow + addRow][pCol + addCol] = 2;
                chess[pRow][pCol] = 0;
                pRow += addRow;
                pCol += addCol;

            }

            now++;
        }

        for (int[] ints : chess) {
            for (int anInt : ints) {

                System.out.print(anInt+ " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();


        sb.append((char) (pCol + 'A' - 1)).append(pRow).append("\n");
        sb.append((char) (sCol + 'A' - 1)).append(sRow);
        System.out.println(sb);



//        System.out.println("pRow = " + pRow);
//        System.out.println("pCol = " + pCol);
//        System.out.println(sRow);
//        System.out.println(sCol);




        }

    }

