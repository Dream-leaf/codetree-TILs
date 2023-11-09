import java.io.*;
import java.util.*;

public class Main {
    static final int N = 19; // 바둑판 19줄임
    static final int BLACK = 1;
    static final int WHITE = 2;
    static int[][] map = new int[N][N];
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // map 입력받음
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int value = map[i][j];
                if(value == 0) continue;
                Loop: for(int s=0;s<4;s++){
                    for(int k=1;k<=2;k++){
                        int nx = i + (dx[s] * k);
                        int ny = j + (dy[s] * k);
                        if(!isRange(nx, ny) || map[nx][ny] != value) continue Loop;
                    }
                    for(int k=1;k<=2;k++){
                        int nx = i + (dx[(s+4)%8] * k);
                        int ny = j + (dy[(s+4)%8] * k);
                        if(!isRange(nx, ny) || map[nx][ny] != value) continue Loop;
                    }
                    System.out.println(value);
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }
        }

        System.out.println(0);
    }


    static boolean isRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
}