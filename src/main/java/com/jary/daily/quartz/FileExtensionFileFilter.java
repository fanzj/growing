package com.jary.daily.quartz;

import java.io.File;
import java.io.FileFilter;

/**
 * @author fanzhengjie
 * @create 2018/1/4 下午5:20
 * @description
 */
public class FileExtensionFileFilter implements FileFilter {

    private String extension;//文件后缀

    public FileExtensionFileFilter(String extension){
        this.extension = extension;
    }

    @Override
    public boolean accept(File pathname) {
        //如果file是个目录
        if(pathname.isDirectory()) return false;

        // Lowercase the filename for easier comparison
        String LCaseFilename = pathname.getName().toLowerCase();    //文件名转换为小写

        return (pathname.isFile() && (LCaseFilename.indexOf(extension) > 0));
    }
}
