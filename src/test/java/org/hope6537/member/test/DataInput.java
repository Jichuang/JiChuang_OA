package org.hope6537.member.test;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Hope6537 on 2015/1/22.
 */
public class DataInput {

    public static void main(String[] args) throws Exception {
        /**
         * 1.txt
         * ----------
         * 1 2
         */
        Scanner scanner = new Scanner(new FileReader(new File("D:\\1.txt")));
        DataGet obj = new DataGet();
        Class aClass = obj.getClass();
        Method inputMethod = aClass.getMethod("getInput", Scanner.class);
        Method outputMethod = aClass.getMethod("validateOutput", String.class);
        inputMethod.invoke(obj, scanner);
        //[2] Wrong Answer 这里也可以IO获取字符串
        boolean res = (boolean) outputMethod.invoke(obj, "[3]");
        if (res) {
            System.out.println("Accept");
        } else {
            System.out.println("Wrong Answer");
        }

    }
}
