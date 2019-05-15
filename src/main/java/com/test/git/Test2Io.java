package com.test.git;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Test2Io {
    public static void main(String[] args) {

        notUseCache();

        useCache();



    }

    private static void useCache() {
        try {
            FileInputStream fis = new FileInputStream("e://");
            FileOutputStream fos = new FileOutputStream("e://");

            //增加缓存使用
            BufferedOutputStream out = new BufferedOutputStream(fos);
            byte[] buffer = new byte[512];
            while (fis.read(buffer) != -1) {
                out.write(buffer);
            }


        } catch (Exception e) {

        } finally {

        }

        //耗时：125ms
    }

    private static void notUseCache() {
        try {
            FileInputStream fis = new FileInputStream("e://");
            FileOutputStream fos = new FileOutputStream("e://");

            int read = -1;
            while ((read = fis.read()) != -1) {
                fos.write(read);
            }

        } catch (Exception e) {

        } finally {

        }

        //耗时：194985ms
    }
}
