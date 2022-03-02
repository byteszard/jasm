package com.wonders.wsm4j;

/**
 * @author Rustacean
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("===================SM3测试===================");
        String hash = Rust.sm3_digest("abc");
        assert "66c7f0f462eeedd9d1f2d46bdc10e4e24167c4875cf2f7a2297da02b8f4ba8e0".equals(hash);
        System.out.println("Hash(abc) = " + hash);

        System.out.println();
        System.out.println("===================SM2测试===================");

        System.out.println("1.-------SM2随机秘钥------");
        String[] pair = Rust.sm2_generate_keypair();

        String private_key = pair[0];
        String public_key = pair[1];

        System.out.println("私钥：" + private_key);
        System.out.println("公钥：" + public_key);

        System.out.println();
        System.out.println("2.-------SM2加密解密(c1c3c2)------");
        String p1 = "圣光会抛弃你的，英雄，就像抛弃我那样。——巫妖王";
        String c1 = Rust.sm2_encrypt(public_key, p1);
        String t1 = Rust.sm2_decrypt(private_key, c1);
        System.out.println("明文：" + p1);
        System.out.println("密文：" + c1);
        System.out.println("解密：" + t1);
        assert p1.equals(t1);

        System.out.println();
        System.out.println("3.-------SM2加密解密(c1c2c3)------");
        String p2 = "兽人永不为奴，我们终将成王。——加尔鲁什·地狱咆哮";
        String c2 = Rust.sm2_encrypt_c1c2c3(public_key, p2);
        String t2 = Rust.sm2_decrypt_c1c2c3(private_key, c2);
        System.out.println("明文：" + p2);
        System.out.println("密文：" + c2);
        System.out.println("解密：" + t2);
        assert p2.equals(t2);

        System.out.println();
        System.out.println("4.-------SM2签名验签------");
        String p3 = "没人生来杰出（No one breather who is worthier）——奥格瑞姆·毁灭之锤";
        String c3 = Rust.sm2_sign(private_key, public_key, p3);
        boolean t3 = Rust.sm2_verify(public_key, p3, c3);
        System.out.println("明文：" + p3);
        System.out.println("签名：" + c3);
        System.out.println("验签：" + t3);
        assert t3;


        System.out.println();
        System.out.println("===================SM4测试===================");
        System.out.println("1.-------SM4随机秘钥和向量------");
        String key = Rust.sm4_generate_key();
        String iv = Rust.sm4_generate_iv();
        System.out.println("密钥：" + key);
        System.out.println("向量：" + iv);

        System.out.println();
        String p4 = "记住‘被遗忘者’的含义，我们既非生者也非死者，我们将被活着的和死去的人遗忘。我们回到了曾经告别的世界上，但是却永远无法回到我们曾经活着的那些日子，永远无法回到那些我们曾经爱过的人的身边。我们是存在也是诅咒，因此我们遗忘过去，并且被过去遗忘。——希尔瓦娜斯";
        System.out.println("明文：" + p4);
        System.out.println();

        System.out.println();
        System.out.println("2.-------SM4加密解密(ECB)------");
        String c4 = Rust.sm4_encrypt_ecb(key, p4);
        String t4 = Rust.sm4_decrypt_ecb(key, c4);
        System.out.println("密文：" + c4);
        System.out.println("解密：" + t4);
        assert p4.equals(t4);

        System.out.println();
        System.out.println("3.-------SM4加密解密(CBC)------");
        String c5 = Rust.sm4_encrypt_cbc(key, iv, p4);
        String t5 = Rust.sm4_decrypt_cbc(key, iv, c5);
        System.out.println("密文：" + c4);
        System.out.println("解密：" + t5);
        assert p4.equals(t5);

        System.out.println();
        System.out.println("4.-------SM4加密解密(CFB)------");
        String c6 = Rust.sm4_encrypt_cfb(key, iv, p4);
        String t6 = Rust.sm4_decrypt_cfb(key, iv, c6);
        System.out.println("密文：" + c6);
        System.out.println("解密：" + t6);
        assert p4.equals(t6);

        System.out.println();
        System.out.println("5.-------SM4加密解密(OFB)------");
        String c7 = Rust.sm4_encrypt_ofb(key, iv, p4);
        String t7 = Rust.sm4_decrypt_ofb(key, iv, c7);
        System.out.println("密文：" + c7);
        System.out.println("解密：" + t7);
        assert p4.equals(t7);

        System.out.println();
        System.out.println("6.-------SM4加密解密(CTR)------");
        String c8 = Rust.sm4_encrypt_ctr(key, iv, p4);
        String t8 = Rust.sm4_decrypt_ctr(key, iv, c8);
        System.out.println("密文：" + c8);
        System.out.println("解密：" + t8);
        assert p4.equals(t8);
    }
}
