/**
 * @Classname FindSubstring
 * @Description leetCode - 30. 串联所有单词的子串
 * @Date 2022/6/23 22:19
 * @author zhangqin
 */

package com.ran.qin.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {

    public static void main(String[] args) {
    String s = "barfoofoobarthefoobarman";
    String[] words = {"bar","foo","the"};
    FindSubstring f = new FindSubstring();
        List<Integer> substring = f.findSubstring(s, words);
        substring.forEach(ss -> System.out.print(ss));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLength = words[0].length();
        int totalNumber = words.length;
        int length = s.length();
        //只用循环wordLength次的原因：从wordLength+1的单词集合是从0开始的单词集合的子集
        for (int i = 0; i < wordLength; i++) {

            if (i + wordLength * totalNumber > length) {
                break;
            }

            Map<String, Integer> diff = new HashMap<>();

            //初始化滑动窗口
            for (int j = 0; j < totalNumber; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                diff.put(word, diff.getOrDefault(word, 0) + 1);
            }

            //和目标数组进行比较
            for (String word : words) {
                diff.put(word, diff.getOrDefault(word, 0) - 1);
                if (diff.get(word) == 0) {
                    diff.remove(word);
                }
            }

            //开始滑动
            //滑动次数 =
            for (int start = i; start < length - wordLength * totalNumber + 1; start += wordLength) {
                if (start != i) {
                    String word = s.substring(start + wordLength * (totalNumber - 1), start + wordLength * totalNumber);
                    diff.put(word, diff.getOrDefault(word, 0) + 1);
                    if (diff.get(word) == 0) {
                        diff.remove(word);
                    }
                    word = s.substring(start - wordLength, start);
                    diff.put(word, diff.getOrDefault(word, 0) - 1);
                    if (diff.get(word) == 0){
                        diff.remove(word);
                    }
                }
                if (diff.isEmpty()){
                    res.add(start);
                }
            }
        }

        return res;
    }
}
