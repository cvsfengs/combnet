package com.comb.commons.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/10/17.
 */
public class Comment {
    public static void main(String[] args) throws IOException {

        FileReader fl = new FileReader("E:\\ideaworkspace\\xcore\\src\\main\\java\\com\\xuser\\language\\pojo\\Language.java");//File name

        BufferedReader bf = new BufferedReader(fl);

        List<String> list = new ArrayList<String>();

        String context = null;

        StringBuffer sb = null;

        do{
            context = bf.readLine();
            if(context == null){
                break;
            }
            if(context.trim().startsWith("//")){
                list.add(context.trim());
                continue;
            }else if(context.trim().startsWith("/**")){
                if(sb != null){
                    list.add(sb.toString());
                }
                sb = new StringBuffer();
                sb.append(context);
            }else if(context.trim().startsWith("*/")){
                sb.append(context);
                list.add(sb.toString());
            }else if(context.trim().startsWith("*")){
                sb.append(context);
            }
        }while(context != null);

        for(String item: list){
            System.out.println(item);
        }
    }
}
