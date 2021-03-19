package com.it.leetcode.explore;

import java.io.*;
import java.util.Stack;

public class FileA {
    public static void main(String[] args) {
        try {
            fileProcess();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileProcess() throws IOException {
        String fileName ="/Users/dreamren/Downloads/A.txt";
        Stack<Character> stack = new Stack<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        File outFile = new File("/Users/dreamren/Downloads/ARerv.txt");
        if (!outFile.exists()) {
            try {
                outFile.createNewFile(); //如果文件不存在则创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int read = bufferedReader.read();
        while (read>0){
            char[] yin = new char[]{};

            System.out.println(read);
            if (read =='\''){
//                countYin++;
            }
            stack.push((char)read);
            read = bufferedReader.read();
        }

        /*String line = bufferedReader.readLine();
        while (line!=null){
            System.out.println(line);
            stack.push(line.getBytes());
            line = bufferedReader.readLine();
        }*/

        /*RandomAccessFile rf = new RandomAccessFile(outFile, "rw");

        long fileLength = rf.length();

        // 将本件指针移到文本末尾

        rf.seek(fileLength);

        // 文本文件追加文本，换行符

        rf.writeBytes("11111/n");

        // rf.writeBytes("1111 /r/n")

        rf.close();*/



        FileOutputStream fileOS = new FileOutputStream(outFile);
        try {

            while (!stack.isEmpty()) {
                fileOS.write(stack.pop());
            }
            fileOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bufferedReader.close();
        fileReader.close();
    }
}
