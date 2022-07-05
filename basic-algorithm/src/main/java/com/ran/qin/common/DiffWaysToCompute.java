/**
 * @Classname DiffWaysToCompute
 * @Description leetCode - 241. 为运算表达式设计优先级
 * @Date 2022/7/3 13:17
 * @author zhangqin
 */

package com.ran.qin.common;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    public static void main(String[] args) {


    }

    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> options = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    options.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    options.add(SUBTRACTION);
                } else if (expression.charAt(i) == '+') {
                    options.add(MULTIPLICATION);
                }
                i++;
            }else {
                int num = 0;
                while(i<expression.length() && Character.isDigit(expression.charAt(i))){
                   num = num*10+ expression.charAt(i) - '0';
                   i++;
                }
                options.add(num);
            }
        }
        return null;
    }
}
