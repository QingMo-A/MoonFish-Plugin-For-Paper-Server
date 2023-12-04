package com.moonfish.Main.Utils;

import com.moonfish.Config;

import java.io.File;
import java.io.FileWriter;

import static org.bukkit.Bukkit.getLogger;

public class CreateUtil {
    public static void CreateFolder(String Path) {
        File CreateFolder = new File(Path);
    }

    public static void CreateFolder(String Path, String CreatedSuccessfullyText, String Created) {
        File CreateFolder = new File(Path);

        //检测插件文件夹状态
        if (!CreateFolder.exists()) {
            if (CreateFolder.mkdirs()) {
                getLogger().info(CreatedSuccessfullyText);
            }
        } else {
            getLogger().info(Created);
        }
    }

    public static void CreateFile(String Path, String FileName) {
        File CreateFile = new File(Path, FileName);
    }

    public static void CreateFile(String Path, String FileName, String CreatedSuccessfullyText, String CreationFailedText, String Created, String text) {
        File CreateFile = new File(Path, FileName);

        if (!CreateFile.exists()) {
            // 如果文件不存在，则创建一个新文件
            try {
                CreateFile.createNewFile();
                getLogger().info(CreatedSuccessfullyText);
                // 创建一个FileWriter对象
                FileWriter Write = new FileWriter(CreateFile);

                // 将数据写入文件
                Write.write(text);

                // 关闭FileWriter
                Write.close();
            } catch (Exception e) {
                getLogger().info(CreationFailedText + ": " + e);
                getLogger().info(Path);
            }
        } else {
            getLogger().info(Created);
        }
    }
}
