package com.yutons.cms.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import net.sf.json.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.codec.binary.Base64;

public class DESUtil {
    public static byte[] PUSH_DESKEY = "new6#cap".getBytes();
    public static final String ENDPOINT = "http://it.newcapec.cn:8082/CRM_WS.asmx?WSDL";
    public static final String soapaction = "http://tempuri.org/";

    /**
     * 微信协作中心消息推送服务
     *
     * @param gh      员工工号
     * @param content 推送内容
     * @return
     */
    public static String sendMsg(String gh, String content) {
        Service service = new Service();
        service.setMaintainSession(true);
        gh = DESUtil.toUtf8("'"+gh+"'");
        String sigin = DESUtil.toUtf8("NewCapec");//sigin 固定校验值
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(ENDPOINT);
            call.setOperationName(new QName(soapaction, "WX_POST_XINXI"));

            call.addParameter(new QName(soapaction, "touser"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(soapaction, "content"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(soapaction, "sign"), XMLType.XSD_STRING, ParameterMode.IN);

            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + "WX_POST_XINXI");
            call.setReturnType(XMLType.XSD_STRING);
            return call.invoke(new Object[]{gh, content, sigin}).toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String gh="DK0042";
        // System.err.println(gh+" "+sigin);
        //测试信息
        //System.out.println(DESUtil.sendMsg(gh, "123"));
        String s = DESUtil.sendMsg(gh, "姚建康发送的测试信息,请忽略");
        JSONObject jsonObject = JSONObject.fromObject(s);
        String invaliduser = jsonObject.getString("invaliduser");
        System.out.println(invaliduser.length());
    }

    /**
     * 加密函数
     *
     * @param data 加密数据
     * @param key  密钥
     * @return 返回加密后的数据
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            // 一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(dks);
            // using DES in ECB mode
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
            // 执行加密操作
            byte[] encryptedData = cipher.doFinal(data);
            return encryptedData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密函数
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        byte[] decryptedData = null;
        try {
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey sk = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, sk);
            decryptedData = cipher.doFinal(data);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return decryptedData;
    }

    /**
     * 转utf-8并加密
     *
     * @param str
     * @return
     */
    public static String toUtf8(String str) {
        String result = "";
        String iso;
        try {
            iso = new String(str.getBytes("utf-8"), "iso-8859-1");
            String utf8 = new String(iso.getBytes("iso-8859-1"), "utf-8");
            result = Base64.encodeBase64String(DESUtil.encrypt(utf8.getBytes(), PUSH_DESKEY));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
