package com.os.jutils;

import org.junit.Test;

public class ZipUtilsTest {  
  
    /** 
     *   
     */  
    @Test  
    public void test() throws Exception {  
        // 压缩文件  
        //ZipUtils.compress("c:\\test.txt");  
        // 压缩目录  
        ZipUtils.compress("E:\\安装介质","E:\\test");  
        
    }  
}  