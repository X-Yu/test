package com.example.demo.escape;

import org.apache.commons.lang3.CharUtils;
import org.apache.tools.zip.ZipEncodingHelper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-11-04 10:50  //时间
 */
public class DoMain {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println("Default Charset=" + Charset.defaultCharset());
//        String str = new String("3-2ETF������ҳ-���".getBytes(),"GBK");
//        String a = new String(str.getBytes(), "GBK");
//        String b = new String(str.getBytes(), "UTF-8");
//        String c = new String(str.getBytes(), "ISO-8859-1");
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        String escapStr = "ä¸\u00ADæ\u0096\u0087";
//        String esc = escapeString(a);
//        System.out.println(esc);

String str=String.format("%04d",14);

        System.out.println(LocalDate.now().atStartOfDay());
        System.out.println(str);
    }

    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|t*|r*|n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = ch.length;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!(CharUtils.isAsciiAlpha(c) || CharUtils.isAsciiNumeric(c))) {
                if (!isChinese(c)) {
                    return true;
                }
            }
//            if (!Character.isLetterOrDigit(c)) {
//
//            }
        }

        return false;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        }
        return false;
    }


    public static String escapeString(String str) {
        String escapeStr = str;
        // 判断是否是乱码
        boolean flag = isMessyCode(escapeStr);
        if (flag) {
            try {
                Map<String, String> map = utfString(escapeStr);
                if (map.get("flag").equals("false")) {
                    return map.get("data");
                }

                Map<String, String> gbk = gbkString(escapeStr);
                if (gbk.get("flag").equals("false")) {
                    return gbk.get("data");
                }

                Map<String, String> iso = isoString(escapeStr);
                if (iso.get("flag").equals("false")) {
                    return iso.get("data");
                }
//                escapeString(escapeStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return escapeStr;
    }

    public static Map<String, String> utfString(String str) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String escapeStr = new String(str.getBytes(), "UTF-8");
        System.out.println("utf8:" + escapeStr);
        // 判断是否是乱码
        boolean flag = isMessyCode(escapeStr);
        System.out.println("utf8 flag:" + flag);
        map.put("flag", flag + "");
        map.put("data", escapeStr);
        return map;
    }

    public static Map<String, String> gbkString(String str) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String escapeStr = new String(str.getBytes(), "GBK");
        // 判断是否是乱码
        boolean flag = isMessyCode(escapeStr);
        System.out.println("gbk:" + escapeStr);
        System.out.println("gbk flag:" + flag);
        map.put("flag", flag + "");
        map.put("data", escapeStr);
        return map;
    }


    public static Map<String, String> isoString(String str) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String escapeStr = new String(str.getBytes(), "ISO-8859-1");
        System.out.println("iso:" + escapeStr);

        // 判断是否是乱码
        boolean flag = isMessyCode(escapeStr);
        System.out.println("iso flag:" + flag);
        map.put("flag", flag + "");
        map.put("data", escapeStr);
        return map;
    }



    public static String getUTF8StringFromGBKString(String gbkStr) {
        try {
            return new String(getUTF8BytesFromGBKString(gbkStr), "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new InternalError();
        }
    }

    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }

}
