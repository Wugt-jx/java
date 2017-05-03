package com.wgt.net;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/3.
 */
public class CloseUtil {
    /**
     * 关闭io流
     * @param io
     */
    public static void closeAll(Closeable...  io){
        for (Closeable temp:io){
            if (null!=temp){
                try {
                    temp.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
