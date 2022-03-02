package com.wonders.wsm4j;


/**
 * @author Rustacean
 */
public class Rust {

    static {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String root = path.substring(0, path.indexOf("/out")) + "/dylib/libwsm4j.so";
        System.load(root);
    }


    public static native String[] sm2_generate_keypair();

    public static native String sm2_encrypt(String public_key, String plain);

    public static native String sm2_decrypt(String private_key, String cipher);

    public static native String sm2_encrypt_c1c2c3(String public_key, String plain);

    public static native String sm2_decrypt_c1c2c3(String private_key, String cipher);

    public static native String sm2_sign(String private_key, String public_key, String plain);

    public static native boolean sm2_verify(String public_key, String plain, String signature);

    public static native String sm3_digest(String plain);

    public static native String sm4_generate_key();

    public static native String sm4_generate_iv();

    public static native String sm4_encrypt_ecb(String key, String plain);

    public static native String sm4_decrypt_ecb(String key, String cipher);

    public static native String sm4_encrypt_cbc(String key, String iv, String plain);

    public static native String sm4_decrypt_cbc(String key, String iv, String cipher);

    public static native String sm4_encrypt_cfb(String key, String iv, String plain);

    public static native String sm4_decrypt_cfb(String key, String iv, String cipher);

    public static native String sm4_encrypt_ofb(String key, String iv, String plain);

    public static native String sm4_decrypt_ofb(String key, String iv, String cipher);

    public static native String sm4_encrypt_ctr(String key, String iv, String plain);

    public static native String sm4_decrypt_ctr(String key, String iv, String cipher);
}
