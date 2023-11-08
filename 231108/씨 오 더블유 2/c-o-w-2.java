import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String inputStr;
    static char[] inputArray;
    static char[] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new char[3];
        inputStr = br.readLine();
        inputArray = inputStr.toCharArray();
        
        combination(0, 0);
        System.out.println(answer);
    }

    public static void combination(int n, int cur){
        if(n == 3){
            String a = new String(arr);
            if(a.equals("COW"))
                answer++;
            return;
        }
        for(int i=cur;i<N;i++){
            visited[i] = true;
            arr[n] = inputArray[i];
            combination(n+1, i+1);
            visited[i] = false;
        }
    }
}