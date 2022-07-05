/**
 * @Classname FindLUSlength
 * @Description leetCode - 522. 最长特殊序列 II
 * @Date 2022/6/27 22:43
 * @author zhangqin
 */

package com.ran.qin.common;

public class FindLUSlength {

    public static void main(String[] args) {

        char[] ss;
        String[] strs = {"aaa","aaa","aa"};
        FindLUSlength f = new FindLUSlength();
        System.out.println(f.findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubSequence(strs[j], strs[i])){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res = Math.max(strs[i].length(), res);
            }
        }
        return res;
    }

    public boolean isSubSequence(String source, String target){
        int indexOfSource = 0;
        int indexOfTarget = 0;
        while(indexOfSource < source.length() && indexOfTarget < target.length()){
            if (source.charAt(indexOfSource) == target.charAt(indexOfTarget)){
                indexOfTarget++;
            }
            indexOfSource++;
        }
        return target.length() == indexOfTarget;
    }
}
