/**
 * @Classname FindFirstBad
 * @Description 二分查找 leetCode 278
 * @Date 2021/11/27 6:19 下午
 * @author zhangqin
 */

package com.ran.qin.binary;

public class FindFirstBad {

    public static void main(String[] args) {
        FindFirstBad f = new FindFirstBad();
        int i = f.firstBadVersion(3);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        if (isBadVersion(start)){
            return start;
        }
        while(start < end){
            int mid = start + ((end - start) >> 1);
            if (isBadVersion(mid)) {
                end = mid;
            }else {
                start = mid +1;
            }
        }
        return start;
    }

    boolean isBadVersion(int version) {
        if (version >= 2) {
            return true;
        }
        return false;
    }
}
