import java.util.*;
import java.io.*;
public class PSA2D {
    static int psa[][];
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of rows: ");
        int n = readInt();
        System.out.print("Enter the amount of columns: ");
        int m = readInt();
        psa = new int [n+1][m+1];
        System.out.println("Enter the 2D matrix: ");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                psa[i][j] = readInt() + psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
            }
        }
        System.out.print("Enter the amount of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the top left index: ");
            int x1 = readInt(), y1 = readInt();
            System.out.print("Enter the bottom right index: ");
            int x2 = readInt(), y2 = readInt();
            int sum = psa[x2][y2] - psa [x1-1][y2] - psa[x2][y1-1] + psa [x1-1][y1-1];
            System.out.println("The sum from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ") is " + sum);
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
