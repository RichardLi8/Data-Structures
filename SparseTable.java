import java.util.*;
import java.io.*;
public class SparseTable {
    static int log2(int v){
        return (int)(Math.log(v)/Math.log(2));
    }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of numbers: ");
        int n = readInt(), max = log2(n);
        int st [][] = new int [n+1][max+1];
        System.out.print("Enter the array: ");
        for(int i = 1; i <= n; i++){
            st[i][0] = readInt();
        }
        for(int j = 1; j <= max; j++){
            for(int i = 1; i+(1<<j)-1 <= n; i++){
                st[i][j] = Math.max(st[i][j-1], st[i+(1<<j-1)][j-1]);
            }    
        }
        System.out.print("Enter the number of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the left and right index: ");
            int l = readInt(), r = readInt();
            int k = log2(r-l+1);
            int ans = Math.max(st[l][k], st[r-(1<<k)+1][k]);
            System.out.println("The max value from " + l + " to " + r + " is " + ans);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
    static char readChar() throws IOException{
        return next().charAt(0);
    }
}
