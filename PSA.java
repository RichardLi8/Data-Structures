import java.util.*;
import java.io.*;
public class PSA {
    static int psa[];
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of numbers: ");
        int n = readInt();
        psa = new int [n+1];
        System.out.print("Enter the array: ");
        for(int i = 1; i <= n; i++){
            psa[i] = readInt() + psa[i-1];
        }
        System.out.print("Enter the amount of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the left and right index of the range: ");
            int l = readInt(), r = readInt();
            System.out.println("The sum from " + l + " to " + r + " is " + (psa[r]-psa[l-1]));
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
