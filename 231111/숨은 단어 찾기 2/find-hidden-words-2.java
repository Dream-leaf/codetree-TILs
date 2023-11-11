import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++){
            String rowStr = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = rowStr.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                char firstChar = map[i][j];
                if(firstChar != 'L') continue; // 첫 번째 글자가 L이 아니면 건너뛴다.
                Loop: for(int s=0;s<8;s++){ // 8방향을 본다.
                    for(int k=1;k<=2;k++){
                        int nx = i + (dx[s] * k);
                        int ny = j + (dy[s] * k);
                        if(!isRange(nx, ny) || map[nx][ny] != 'E') continue Loop;
                    }
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }


    static boolean isRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<M;
    }
}