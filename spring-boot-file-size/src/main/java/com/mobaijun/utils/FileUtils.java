package com.mobaijun.utils;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/11/8 15:46
 * ClassName:FileUtils
 * 类描述： 文件类
 */
public class FileUtils {

    private final static Formatter f = new Formatter(System.out);
    private final static String STRF = "%-10s%7s %11s %10s   %-20s\n";

    @Data
    static class Node {
        String fileName;
        String permission;
        TreeInfo treeInfo;

        private Node(String fileName, String permission, TreeInfo treeInfo) {
            this.fileName = fileName;
            this.permission = permission;
            this.treeInfo = treeInfo;
        }
    }

    private static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();
        public List<File> unReachables = new ArrayList<File>();
        public long size = 0;

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
            unReachables.addAll(other.unReachables);
            size += other.size;
        }
    }

    public static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        if (startDir.isDirectory()) {
            File[] files = startDir.listFiles();
            if (files != null) {
                for (File item : files) {
                    if (!item.canRead()) {
                        result.unReachables.add(item);
                        continue;
                    }
                    if (item.isDirectory()) {
                        result.dirs.add(item);
                        result.addAll(recurseDirs(item, regex));
                    } else {
                        if (!item.canRead()) {
                            result.unReachables.add(item);
                            continue;
                        }
                        if (item.getName().matches(regex)) {
                            result.files.add(item);
                            result.size += item.length();
                        }
                    }
                }
            } else {
                result.unReachables.add(startDir);
            }
        } else {
            if (startDir.canRead()) {
                if (startDir.getName().matches(regex)) {
                    result.files.add(startDir);
                    result.size += startDir.length();
                }
            } else {
                result.unReachables.add(startDir);
            }
        }
        return result;
    }


    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static String getPermission(File file) {
        String d = file.isDirectory() ? "d" : "-";
        String r = file.canRead() ? "r" : "-";
        String w = file.canWrite() ? "w" : "-";
        String x = file.canExecute() ? "x" : "-";
        return d + r + w + x;
    }

    /**
     * 标题
     */
    public static void printTitle() {
        f.format(STRF, "Permission", "Size", "FileCount", "DirCount", "FileName");
        f.format("--------------------------------------------------------------\n");
    }

    public static void printSingleLine(Node node) {
        f.format(STRF, node.permission, showSize(node.treeInfo.size), node.treeInfo.files.size(), node.treeInfo.dirs.size(), node.fileName);
    }

    private static void printTail() {
        f.format("--------------------------------------------------------------\n");
    }

    public static String showSize(long size) {
        String result = "";
        if (size / 1024 >= 1) {
            if (size / 1024 / 1024 < 1) {
                result = String.format("%.2fK", 1.0 * size / 1024);
            } else if (size / 1024 / 1024 >= 1 && size / 1024 / 1024 / 1024 < 1) {
                result = String.format("%.2fM", 1.0 * size / 1024 / 1024);
            } else {
                result = String.format("%.2fG", 1.0 * size / 1024 / 1024 / 1024);
            }

        } else {
            result = String.format("%dB", size);
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String dir = ".";
        if (args.length == 1) {
            dir = args[0];
        }
        int fileCnt = 0, dirCnt = 0;
        long totalSize = 0;
        File topFile = new File(dir);
        printTitle();
        for (File file : Objects.requireNonNull(topFile.listFiles())) {
            Node node = new Node(file.getName(), getPermission(file), walk(file));
            printSingleLine(node);
            fileCnt += node.treeInfo.files.size();
            dirCnt += node.treeInfo.dirs.size();
            if (node.permission.startsWith("d")) dirCnt += 1;
            totalSize += node.treeInfo.size;
        }
        printTail();
        long end = System.currentTimeMillis();
        System.out.printf("%s has %d dirs, %d files, total %s.\n"
                        + "Takes %.2f seconds.%n", topFile.getAbsoluteFile(), dirCnt, fileCnt, showSize(totalSize),
                (end - start) / 1000.0);
    }

}
