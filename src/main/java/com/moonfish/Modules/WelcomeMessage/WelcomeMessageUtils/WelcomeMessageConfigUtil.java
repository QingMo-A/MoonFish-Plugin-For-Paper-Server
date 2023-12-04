package com.moonfish.Modules.WelcomeMessage.WelcomeMessageUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class WelcomeMessageConfigUtil {
    private static int LineNumber = -1;
    private static int Line = 0;
    private static String get = null;
    public static String Search(String name, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // 逐行读取文件内容，判断是否包含目标字符串
            for (int i = 1; (line = br.readLine()) != null; i++) {
                if (line.contains(name)) {
                    LineNumber = i;
                    break;
                }
            }
        } catch (IOException e) {
            getLogger().info(" " + e);
        }

        if (LineNumber != -1) {
            Line = LineNumber;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine == Line) {
                    get = line.substring(line.indexOf(":") + 1).trim();
                    break; // 找到指定行后，跳出循环
                }

                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return get;
    }

    public static void Write(String name, String text, String path) {
        int lineNumber = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // 逐行读取文件内容，判断是否包含目标字符串
            for (int i = 1; (line = br.readLine()) != null; i++) {
                if (line.contains(name)) {
                    lineNumber = i;
                    break;
                }
            }
        } catch (IOException e) {
            getLogger().info(" " + e);
        }

        if (lineNumber == -1) {
            return;
        }

        try {
            Path path1 = Paths.get(path);
            List<String> lines = Files.readAllLines(path1, StandardCharsets.UTF_8);

            String[] parts = lines.get(lineNumber - 1).split(":");
            String newLine = parts[0] + ": " + text;

            lines.set(lineNumber - 1, newLine);

            Files.write(path1, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            getLogger().warning(e.getMessage());
        }
    }
}
