/**
 * @Classname NmPrimeArrangements
 * @Description leetCode - 1175. 质数排列
 * @Date 2022/6/30 22:53
 * @author zhangqin
 */

package com.ran.qin.common;

public class NmPrimeArrangements {

    public static void main(String[] args) {

        NmPrimeArrangements n = new NmPrimeArrangements();
        int i = n.numPrimeArrangements(100);
        System.out.println(i);
    }

    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)){
                count++;
            }
        }
        long res1 = 1;
        for (int i = 1; i <= count; i++) {
           res1*=i;
            res1%=1000000007;
        }


        long res2 = 1;
        for (long i = 1; i <= n - count; i++) {
            res2*=i;
            res2%=1000000007;
        }
        return (int)(res1*res2%1000000007);

    }

    private boolean isPrime(int num){

        if(num ==1){
            return false;
        }

        for (int i = 2; i *i<= num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
