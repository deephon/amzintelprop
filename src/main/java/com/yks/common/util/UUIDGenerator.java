package com.yks.common.util;

import java.util.UUID;

/**
 * ClassName:UUIDGenarator
 *
 * @Dec: UUID工具类
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/6 14:06
 */
public class UUIDGenerator {


    public static void main(String[] args) {
        for (int i = 0;i<100 ;i++) {
            System.out.println(getUUID());
        }
    }

    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        // 去掉"-"符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    /**
     * 获得指定数目的UUID
     *
     * @param number
     *            int 需要获得的UUID数量
     * @return String[] UUID数组
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
