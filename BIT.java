import java.util.*;
import java.io.*;
public class BIT {
    static int bit [];
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit[i] += v;
        }
    }
    static int query(int i){
        int ret = 0;
        for(; i > 0; i -= i&-i){
            ret += bit[i];
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        System.out.print("Enter the amount of numbers: ");
        int n = readInt();
        bit = new int [n+1];
        System.out.print("Enter the array: ");
        for(int i = 1; i <= n; i++){
            int v = readInt();
            update(i, v);
        }
        System.out.print("Enter the amount of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the left and right index: ");
            int l = readInt(), r = readInt();
            System.out.println("The sum from " + l + " to " + r + " is " + (query(r)-query(l-1)));
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
}
