package com.syning.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Scanner;


/**
 * 模拟手机验证码
 * 1、随机生成六位数的验证码
 * 2、验证码在两分钟内有效 ： 把验证码放入redis中，设置过期时间120秒   手机号码为 key  验证码为 value
 * 3、从redis中取出验证码，判断输入的验证码与redis中存放的验证码是否一致
 */
public class PhoneCode {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String phone = "";
        System.out.print("请输入手机号码:> ");
        phone = sc.nextLine();

        // 1、随机生成六位数的验证码
        String retCode = getCode();

        // 2、验证码在两分钟内有效 ： 把验证码放入redis中，设置过期时间120秒   手机号码为 key  验证码为 value
        setCodeToRdis(phone, 120, retCode);

        // 3、从redis中取出验证码，判断输入的验证码与redis中存放的验证码是否一致

        String inCode = "";


        boolean loop = true;
        int count = 2;
        while (loop) {
            inCode = getInCode();  // 输入函数

            if (judgeCode(inCode, phone)) {
                System.out.println("验证码输入正确");
                loop = false;
            } else {
                if (count <= 0) {
                    System.out.println("三次输入错误，退出程序");
                    break;
                }
                System.out.println("验证码错误，你还有" + count + "次机会");
                count--;
            }
        }

    }

    // 1、随机生成六位数的验证码
    static String getCode() {
        Random random = new Random();

        String code = "";

        for (int i = 0; i < 6; ++i) {
            int rand = random.nextInt(10);
            code += rand;
        }

        return code;
    }

    // 2、验证码在两分钟内有效 ： 把验证码放入redis中，设置过期时间120秒
    static void setCodeToRdis(String phone, int second, String code) {
        Jedis jedis = new Jedis("192.168.3.129", 6379);
        jedis.auth("syning");
        jedis.setex(phone, second, code);
        jedis.close();
    }

    // 3、从redis中取出验证码，判断输入的验证码与redis中存放的验证码是否一致
    static boolean judgeCode(String inCode, String phone) {
        Jedis jedis = new Jedis("192.168.3.129", 6379);
        jedis.auth("syning");
        // 取出 value 值
        String value = jedis.get(phone);
        jedis.close();
        if (value != null) {
            return value.equals(inCode);   // 输入的验证码相等返回true，否则返回false
        }
        return false;
    }

    static String getInCode() {
        String inCode = "";
        System.out.print("请输入验证码:> ");
        inCode = sc.nextLine();
        return inCode;
    }
}
