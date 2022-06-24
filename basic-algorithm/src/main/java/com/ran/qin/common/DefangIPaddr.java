/**
 * @Classname DefangIPaddr
 * @Description leetCode - 1108. IP 地址无效化
 * @Date 2022/6/21 10:06
 * @author zhangqin
 */

package com.ran.qin.common;

public class DefangIPaddr {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
