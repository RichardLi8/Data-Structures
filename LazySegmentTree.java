import java.util.*;
import java.io.*;
public class LazySegmentTree {
    static int [] seg, a, lazy;
    static void build(int l, int r, int pos){
        if(l == r){
            seg[pos] = a[l];
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg[pos] = seg[2*pos] + seg[2*pos+1];
    }
    static void update(int l, int r, int ul, int ur, int val, int pos){
        if(l == ul && ur == r){
            seg[pos] += val*(r-l+1);
            lazy[pos] += val;
            return;
        }
        int mid = (l+r)/2;
        pushDown(l, r, pos);
        if(ur <= mid){
            update(l, mid, ul, ur, val, 2*pos);
        }
        else if(ul > mid){
            update(mid+1, r, ul, ur, val, 2*pos+1);
        }
        else{
            update(l, mid, ul, mid, val, 2*pos); update(mid+1, r, mid+1, ur, val, 2*pos+1);
        }
        seg[pos] = seg[2*pos] + seg[2*pos+1];
    }
    static void pushDown(int l, int r, int pos){
        if(lazy[pos] == 0) return;
        int mid = (l+r)/2;
        lazy[2*pos] += lazy[pos];
        lazy[2*pos+1] += lazy[pos];
        seg[2*pos] += lazy[pos] * (mid-l+1);
        seg[2*pos+1] += lazy[pos] * (r-mid);
        lazy[pos] = 0;
    }
    static int query(int l, int r, int ql, int qr, int pos){
        if(l == ql && qr == r){
            return seg[pos];
        }
        int mid = (l+r)/2;
        pushDown(l, r, pos);
        if(qr <= mid){
            return query(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            return query(l, mid, ql, mid, 2*pos) + query(mid+1, r, mid+1, qr, 2*pos+1);
        }
    }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of numbers: ");
        int n = readInt();
        seg = new int [4*n]; a = new int [n+1]; lazy = new int [4*n];
        System.out.print("Enter the array: ");
        for(int i = 1; i <= n; i++){
            a[i] = readInt();
        }
        build(1, n, 1);
        System.out.print("Enter the amount of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the operation: ");
            char c = readChar();
            if(c == 'u'){
                System.out.print("Enter the left and right index and value: ");
                int l = readInt(), r = readInt(), val = readInt();
                update(1, n, l, r, val, 1);
            }
            else if(c == 'q'){
                System.out.print("Enter the left and right index: ");
                int l = readInt(), r = readInt();
                System.out.println("The sum from " + l + " to " + r + " is " + query(1, n, l, r, 1));
            }
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
