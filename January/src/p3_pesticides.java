import java.io.*;
import java.util.*;

public class p3_pesticides {
    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("C:\\Users\\guole\\Downloads\\prob3_bronze_jan24\\10.in"));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(st.nextToken());
        boolean isneg = false;
        long[] arr = new long[N];
        long steps = 0;
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        if(arr[0] < 0) isneg = true;
        for(int i = 0; i < N; i++){
            long cur = arr[i];
            long tar;
            if(isneg == true) tar = (i+1) * -1;
            else{
                if(arr[0] == 0) tar = i;
                else tar = (i+1);
            } 
            long diff = (tar-cur);
            steps += Math.abs(diff);
            long mult = 0;
            if(diff >= 1 || diff <= -1){
                for(int j = i+1; j < N; j++){
                    mult = j-i + 1;
                    arr[j] += diff * mult;
                }
            }
        }
        steps += 1;
        pw.println(steps);
        pw.close();
    }
}
