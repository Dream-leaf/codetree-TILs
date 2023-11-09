import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr; // 숫자 자리별로 저장
    static int[] count; // 숫자 길이 저장
    static int[] number;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        count = new int[N];
        number = new int[N];
        // 입력
        for(int i=0;i<N;i++){
            arr[i] = new int[5];
            String inputStr = br.readLine();
            count[i] = inputStr.length();
            int num = Integer.parseInt(inputStr);
            number[i] = num;
            disassemble(num, i, 4);
        }

        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int[] first = arr[i];
                    int[] second = arr[j];
                    int[] third = arr[k];

                    int max_length = Math.max(count[i], Math.max(count[j], count[k]));
                    int carryOccur = 0; // carry가 발생한 횟수;
                    int sum = 0;
                    for(int l=4;l>=4-max_length;l--){
                        sum = first[l] + second[l] + third[l];
                        if(sum >= 10) carryOccur++;
                    }
                    if(carryOccur == 0){
                        answer = Math.max(answer, number[i] + number[j] + number[k]);
                    }
                }
            }
        }

        if(answer == Integer.MIN_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    static void disassemble(int num, int index, int cnt){
        if(num < 10){
            arr[index][cnt] = num;
            return;
        }
        disassemble(num / 10, index, cnt-1);
        arr[index][cnt] = num % 10;
    }

}