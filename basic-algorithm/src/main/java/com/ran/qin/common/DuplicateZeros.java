/**
 * @Classname DuplicateZeros
 * @Description leetCode - 1089. 复写零
 * @Date 2022/6/17 10:15
 * @author zhangqin
 */

package com.ran.qin.common;

public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros d = new DuplicateZeros();
        int[] arr = {0,0,0,0,0,0};
        d.duplicateZerosOne(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void duplicateZerosOne(int[] arr) {

        int[] res = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index > arr.length - 1){
                break;
            }
            if(arr[i] == 0 && index + 1 < arr.length){
                res[index++] = arr[i];
                res[index++] = 0;
            }else {
                res[index++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
