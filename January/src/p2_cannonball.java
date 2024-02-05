import java.io.*;
import java.util.*;

public class p2_cannonball{
    static class spot{
        Integer type;
        Integer r_m;
        Boolean broken;
        public spot(int t, int r, boolean b){
            this.type = t;
            this.r_m = r;
            this.broken = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        spot[] spots = new spot[N];
        int streak = 0;
        int k = 1;
        boolean dir = true;
        int ans = 0;
        int tcount = 0;
        int pl = S-1;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(r.readLine());
            int t = Integer.parseInt(st.nextToken());
            if(t == 1) tcount++;
            spots[i] = new spot(t, Integer.parseInt(st.nextToken()), false);
        }
        while(true){
            int prevans = ans;
            int curtype = spots[pl].type;
            int currm = spots[pl].r_m;
            boolean broke = spots[pl].broken;
            if((curtype == 1) && (Math.abs(k) >= currm)){
                if(broke == false){
                    spots[pl].broken = true;
                    ans++;
                } 
            }
            else if(curtype == 0){
                k += currm;
                dir = !dir;
            }
            if(dir == true){
                pl += k;
            }
            else{
                pl -= k;
            }
            if(curtype == 0 && currm == 0){
                if(spots[pl].type == 0 && spots[pl].r_m == 0){
                    break;
                }
            }
            if((pl < 0) || (pl >= N)) break;
            if(ans == tcount) break;
            if(ans == prevans) streak++;
            else streak = 0;
            if(streak >= 1000000) break;
        }
        pw.println(ans);
        pw.close();
    }
}