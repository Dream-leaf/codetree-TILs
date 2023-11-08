import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int length = inputStr.length();
        for(int i=0;i<length-4;i++){
            char cur = inputStr.charAt(i);
            char next = inputStr.charAt(i+1);
            if(cur == '('&& next == '('){
                for(int j=i+2;j<length-1;j++){
                    char closeCur = inputStr.charAt(j);
                    char closeNext = inputStr.charAt(j+1);
                    if(closeCur == ')' && closeNext == ')'){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}