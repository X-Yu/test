package com.example.demo.encrypted;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-06-15 17:41  //时间
 */
public class Domain {

    public static void main(String[] args) {
        String a="{\"checkType\":\"ip\",\"ip\":\"10.176.66.75\",\"sessionId\":\"6\",\"appId\":\"LINK\",\"timestamp\":1623748241}";

        String pubkey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPvKPORPcwGiLG1w7aRTPYJoTO" +
                "s5iLAzUtVQG6t+NvzIRsZR70LUDUJ1EZwfZVFCKY96xo8G7FPW+BXe/GAKxCtTkF" +
                "ODbN9uGuwJD3iPml2fvde+Tgzfpv6jEN/IxH2PM+i2aZBDSNxwJGDSTXsPamCCI/" +
                "Usn2Y9Vzv5CV06C55wIDAQAB";
        String rsa= rsaEncrypt(a,pubkey);

        System.out.println(rsa+"----");
//        String c="sqHIzS8NFFu5WxC+0sS2QgBTIDAbO1bUoFo1Awr9ItSONWyapTd1x80N/L0ddKRkwk+moPQxxMu0jJuOs4CpPWPi7N4eSjm/lG/ZJRHLslpm+wmiXIl5iljgR1fw+EimSn4GNLgSNQzbg+GtmLexKn11vXWdI86LxILJe4xrBfcebnxfn/JgPr+TNnFZtihDNpGpp6oZOkwE3l4Zpny5sHlrusRtK4iMIlHgCRnrp6QMjoz7e80WwcYKoH0HtxOpvGbqiV14oCJMXsJ/mc8r2OzqRdZR+BCx39oB/msoB5sRXZuw2qKhIq/m0E89lKJNKpiGnwH3vteMN0rfPpIaOQ==";

        String prikey= "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDGO12yXBksx7zW" +
                "EtQviqqDnMmhx4iB8JHx0Ax9dxbhqnuUGGl4VHI8OovZX+t8ZiVLi3UHrKQwEMLo" +
                "yKbo7EJ5Fl9AAHANbApm/J6I96MSJBAzEzgmyLgsN+TqzI57aGx7D7K2VidNSrKo" +
                "xpjq8htltKMHRKT6QH1yHU/NHhnel6ERY6qhpWy1P0zTQryrAZLkT0DWdLbdjeJV" +
                "63hw66HzRA2EHj1pV6RYBUvSR5BQCrepFiMuGbpIqa+JSDBhHaTkbuUD/2GIOVMX" +
                "vISyt2A+MnFk0E65Hdll8bRVQ0FTcLma+47XVceJcQv93Wfk9m81d5GIUrTnC/2f" +
                "S9+dZ9JRAgMBAAECggEAL7yAFcGD9nqrCMpD+qbj5QnOrHzGbLQoERlOyK/y/Kj3" +
                "VXSDgYykbciTgOdOaAiZFpYgupZie4itxyz6tMCgSVSP33O7iB/qaV6QNt+bj3TL" +
                "yeDo9r4DS/Kx17Em5qUA6qmfGbWphT1lxKr+jCV9X4Ked9OZ/wGks+RHIVgMVsO0" +
                "bi4E85ECAvGo1FAfDI62EchRFA/v8HwhiKv7RjzNVaKQPE2I8Od4Zg47Yr4Kb0w8" +
                "g0El2aN5FhffJX0Rcbz+FqLLQhpjs0lILtqr6Lr8aDXkvEPEB7nMq/74BrdbhFrG" +
                "/o3xHu8kJXXWJsC3iQxq+QF0+SkBGPbleVEMOMezgQKBgQDkQEWvZ7lpexpWerpk" +
                "X05+RTbwPlRN2gdc2LwVDHvMnG3xMvQyk195p0SzwPD7CZ0kZnAkTuJ7FPRCzoaE" +
                "g0M+6I+pzv9wMqqhDK0LCCZi5TiIg72BWK9vVGnyTR7/1OVn+J82aEoxAeP53xmK" +
                "g+RFuG+IuzgfafTRifmcPgon+QKBgQDeVNMN62mzKTcJQo3ONiElax3ZM5KCPy9q" +
                "D/49TUWiGy1ZbHvwMZyHg8cGzxnVIbmnpGbYcqSxy1PBDoSymfoxwhxi3nuMzThX" +
                "6sRLcjM2t9TxYF4pCJ0PO/AXU7WHBbFiSa52Iu6ZiW7XU185lU2pD0408dxrvHt5" +
                "z5hQIAIDGQKBgQCCzYZhx8pMdXyZdImefbOozxd1w/JiDwFLJvVaBqZnknm60N16" +
                "olQDjmTjsj0nT9IbCw1W8VH/APod0ubpx6NgyLuTr4lZDeAUnQQJn2kIIZ4tNXoD" +
                "RwR6g2CXt7R9Hc89rw/miQuDXDb+eejUJVNK1TAtpkS6U+k1r6E49aCyWQKBgQC/" +
                "7npEifW1tN7OH6ZLXm8+3jnmR58y0VkdNrFEOnDigJOlnwFfWXTHh/tI5YBnfbXI" +
                "AyTFtjJ3ShADmYT0qfhS/D+FGouOAZuiSgkrGGsd0ZUCyy5+PfFYNWYOvTT4WvHG" +
                "59S0J3PTF9GYEWEjVMC2MYBSNHkUiKIPhib3BKq4AQKBgEoYYiDlmfqQOHOd9Ah7" +
                "gFrXfu7trk07Iyys1SR53ZyKydr4kfShBYT+Hww9FfMl2kANsgQ4ZcCFHDLLHsww" +
                "ESIahv0v9fk4KUifn51ewtixUl/N7VEue6MTJMzFlembjdYuGv32yxtKA4kwOWJf" +
                "vBoUnHY6Zo3xIIxYKfnxFIhT";


        byte [] res= decrypt(Base64.getDecoder().decode(rsa.getBytes()),prikey);
        String b= String.valueOf(res);
        System.out.println(b);

    }


    /**
     * 安全类工具
     *
     * @param path 公钥输入流
     * @throws Exception 加载公钥时产生的异常
     * @author zhangmingming
     * /**
     * 从文件中输入流中加载公钥
     */
    public static String loadPublicKeyByFile(String path) throws Exception {
        try {
            Resource resource = new ClassPathResource(path);
            InputStreamReader intput = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(intput);
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    /**
     * 从文件中加载私钥
     *
     * @param path 私钥文件名
     * @return 是否成功
     * @throws Exception
     */
    public static String loadPrivateKeyByFile(String path) throws Exception {
        try {
            Resource resource = new ClassPathResource(path);
            InputStreamReader intput = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(intput);
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        }
    }

    public static PrivateKey string2PrivateKey(String priStr) {
        byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            return privateKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("key generator error : ".concat(priStr));

    }

    /** */
    /**
     * a
     * <P>
     * 私钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] encryptedData, String privateKey) {
        byte[] decryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, string2PrivateKey(privateKey));
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            int MAX_DECRYPT_BLOCK = 128;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            decryptedData = out.toByteArray();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decryptedData;
    }

    public static String getDecrypt(String encryptString, String privateKey) {

        return Optional
                .ofNullable(Domain.decrypt(
                        org.apache.commons.codec.binary.Base64.decodeBase64(encryptString), privateKey))
                .map(String::new).orElse("");
    }

    public static String rsaEncrypt(String input, String rsaPublicKey) {
        String result = "";
        try {
            // 将Base64编码后的公钥转换成PublicKey对象
            byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(rsaPublicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(keyBytes));
            // 加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] inputArray = input.getBytes();
            int inputLength = inputArray.length;
            System.out.println("加密字节数：" + inputLength);
            // 最大加密字节数，超出最大字节数需要分组加密
            int MAX_ENCRYPT_BLOCK = 117;
            // 标识
            int offSet = 0;
            byte[] resultBytes = {};
            byte[] cache = {};
            while (inputLength - offSet > 0) {
                if (inputLength - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(inputArray, offSet, MAX_ENCRYPT_BLOCK);
                    offSet += MAX_ENCRYPT_BLOCK;
                } else {
                    cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                    offSet = inputLength;
                }
                resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
                System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length,
                        cache.length);
            }
            result = org.apache.commons.codec.binary.Base64.encodeBase64String(resultBytes);
        } catch (Exception e) {
            System.out.println("rsaEncrypt error:" + e.getMessage());
        }
        System.out.println("加密的结果：" + result);
        return result;
    }
}
