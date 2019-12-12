package com.lucas.mp.demo.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroJiaMITest {

    public static void main(String[] args) {

        //生成盐（部分，需要存入数据库中）
        String random = new SecureRandomNumberGenerator().nextBytes().toBase64();
        String random1 = new SecureRandomNumberGenerator().nextBytes().toHex();
        String random2 = new SecureRandomNumberGenerator().nextBytes().toString();
        System.err.println(random);
        System.err.println(random1);
        System.err.println(random2);
        ByteSource bytes = ByteSource.Util.bytes(random);
//        System.err.println(bytes.toString());
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String result = new SimpleHash(Sha256Hash.ALGORITHM_NAME,"123", random, 1024).toHex();
        String result1 = new SimpleHash(Sha256Hash.ALGORITHM_NAME,"123", random, 1024).toString();
        String result2 = new SimpleHash(Sha256Hash.ALGORITHM_NAME,"123", random, 1024).toBase64();
        System.err.println(result);
        System.err.println(result1);
        System.err.println(result2);


    }

}
