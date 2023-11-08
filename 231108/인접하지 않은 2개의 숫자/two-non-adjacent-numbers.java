import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            int startIndex = i;
            int skipIndex1 = i-1;
            int skipIndex2 = i+1;
            for(int j=0;j<N;j++){
                if(j == skipIndex1 || j == skipIndex2 || j== startIndex) continue;
                int value = arr[startIndex] + arr[j];
                max = Math.max(max, value);
            }
        }

        System.out.println(max);
    }
}