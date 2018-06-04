package com.jary.daily.security;

import com.google.common.base.Charsets;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @author fanzhengjie
 * @create 2018/6/4 下午4:53
 * @description
 */
public class EncryptService {

    private static final String KEY_ALGORITHM_RSA = "RSA";
    private static final String RSA_CIPHER = "RSA/ECB/PKCS1Padding";

    /**
     * 私钥解密
     * @param dataRsaPriKey
     * @param content
     * @return
     */
    public String descryptByPrivateKey(String dataRsaPriKey, String content) {
        try{
            //私钥（BASE64编码）
            byte[] keyBytes = Base64.decodeBase64(dataRsaPriKey);
            byte[] decodeBase64 = Base64.decodeBase64(content);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
            Key privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher =  Cipher.getInstance(RSA_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            int inputLen = decodeBase64.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            //对数据分段解密
            while (inputLen - offset > 0){
                if(inputLen - offset > 256){
                    cache = cipher.doFinal(decodeBase64, offset, 256);
                }else{
                    cache = cipher.doFinal(decodeBase64, offset, (inputLen - offset));
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * 256;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData, Charsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥加密
     * @param dataRsaPubKey
     * @param content
     * @return
     */
    public String encryptByPublicKey(String dataRsaPubKey, String content){
        try{
            //公钥（BASE64编码）
            byte[] encryptedData = new byte[0];
            try{
                byte[] keyBytes = Base64.decodeBase64(dataRsaPubKey);
                byte[] ctb = content.getBytes("utf-8");
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
                Key publicK = keyFactory.generatePublic(x509EncodedKeySpec);
                //对数据加密
                Cipher cipher = Cipher.getInstance(RSA_CIPHER);
                cipher.init(Cipher.ENCRYPT_MODE, publicK);
                int inputLen = ctb.length;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int offset = 0;
                byte[] cache;
                int i = 0;
                //对数据分段加密
                while(inputLen - offset > 0){
                    if(inputLen - offset > 256){
                        cache = cipher.doFinal(ctb, offset, 256);
                    }else{
                        cache = cipher.doFinal(ctb, offset, inputLen - offset);
                    }
                    out.write(cache, 0,cache.length);
                    i++;
                    offset = i * 256;
                }
                encryptedData = out.toByteArray();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            String encodeBase64String = Base64.encodeBase64String(encryptedData);
            return encodeBase64String;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥签名
     * @param signPriKey
     * @param signModel
     * @param content
     * @return
     */
    public String generateSign(String signPriKey, String signModel, String content){
        try{
            byte[] keyBytes = Base64.decodeBase64(signPriKey);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance(signModel);
            signature.initSign(privateK);
            signature.update(content.getBytes("utf-8"));
            byte[] result = signature.sign();
            return Base64.encodeBase64String(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥验签
     * @param signPubKey
     * @param signModel
     * @param content
     * @param sign
     * @return
     */
    public boolean verifySign(String signPubKey, String signModel, String content, String sign){
        try{
            byte[] keyBytes = Base64.decodeBase64(signPubKey);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
            PublicKey publicK = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance(signModel);
            signature.initVerify(publicK);
            signature.update(content.getBytes("utf-8"));
            return signature.verify(Base64.decodeBase64(sign));
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
