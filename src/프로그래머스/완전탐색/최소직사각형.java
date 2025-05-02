package 프로그래머스.완전탐색;



public class 최소직사각형 {
    /*
    명함을 담기 위한 최소 지갑 사이즈를 반환
    가로길이와 세로 길이가 다 들어가야한다. 그러나 명함의 경우 세로와 가로를 뒤집어도 된다
    그럼 가로, 세로 중 큰 것 찾고
    가로가 더 크다면 다음 큰 세로의 값이 가로보다 큰 지 확인
    크다면 스왑 후 다음 세로 중 큰 것 찾고 반복

    정답
    스왑보다는 그냥 더 긴쪽을 세로라고 그냥 고정해놓고 최대값을 찾고
    더 짧은 쪽을 가로라고 정해놓고 그 중 최대값을 구해 곱하면 끝..
     */
    public static void main(String[] args) {
        int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        최소직사각형 sol = new 최소직사각형();
        sol.solution(sizes);

    }

    public int solution(int[][] sizes) {
        //총 만개

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            int v = Math.max(sizes[i][0], sizes[i][1]);// 긴 곳을 가로로 찾기 위해
            int h = Math.min(sizes[i][0], sizes[i][1]);// 짧은 곳을 세로로 두기 위해
            maxX = Math.max(maxX, v);// 가장 긴 명함을 찾기 위해 가로 중 최대값 찾기
            maxY = Math.max(maxY, h);// 가장 긴 명합을 찾기 위해 세로중 최대 값 찾기
        }


        return maxX * maxY;
    }
}
