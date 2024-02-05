import java.io.*;
import java.util.*;

public class p1_majorityopinion{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] cows = new int[N];
            st = new StringTokenizer(r.readLine());

            for(int j = 0; j < N; j++){
                cows[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> works = new ArrayList<>();
            if(N == 2){
                int a = cows[0];
                int b = cows[1];
                if(a == b) works.add(a);
            }
            else{
                for(int j = 2; j < N; j++){
                    int a = cows[j-2];
                    int b = cows[j-1];
                    int c = cows[j];
                    if(a == b || a == c){
                        if(works.contains(a)){
                            continue;
                        }
                        else{
                            works.add(a);
                        }
                    }
                    else if(b == c){
                        if(works.contains(b)){
                            continue;
                        }
                        else{
                            works.add(b);
                        }
                    }
                }
            }
            Collections.sort(works);
            if(works.isEmpty()) pw.print(-1);
            else{
                for(int j = 0; j < works.size(); j++){
                    if(j != (works.size()-1)){
                        pw.print(works.get(j) + " ");
                    }
                    else{
                        pw.print(works.get(j));
                    }
                }
            }
            pw.println();
        }
        pw.close();
    }
}