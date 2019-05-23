package com.xxx;

import java.util.*;

/**
 * d
 *
 * @author guodq
 * @create 2018-11-30 上午11:01
 */

public class NewTest{
    public static void main(String[] args) {
        Objects.equals(2,2);
        @SuppressWarnings("resource")
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String s=scan.nextLine();
            s=s.replaceAll("\\{", "(");
            s=s.replaceAll("\\[", "(");
            s=s.replaceAll("\\}", ")");
            s=s.replaceAll("\\]", ")");
            ArrayList<String> list=new ArrayList<>();
            char[] c=s.toCharArray();
            int i=0;
            while(i<c.length){
                int k=0;
                while(k+i<c.length && c[i+k]>='0' && c[i+k]<='9'){
                    k++;
                }
                if(k!=0){
                    list.add(String.copyValueOf(c, i, k));
                    i=i+k;
                }
                else{
                    list.add(String.copyValueOf(c, i, 1));
                    i++;
                }
            }
            ArrayList<String> list1=new ArrayList<>();
            for(int j=0; j<list.size(); j++){
                if(list.get(j).equals("-")){
                    if(j==0){
                        list1.add("0");
                    }
                    else{
                        if(list.get(j-1).equals("(")){
                            list1.add("0");
                        }
                    }
                }
                list1.add(list.get(j));
            }

            System.out.println(computeNum(list1));
        }

    }

    public static String[] getPostfixExpression(ArrayList<String> list){
        Stack<String> s1=new Stack<>();
        Stack<String> s2=new Stack<>();
        int i=0;
        while(i<list.size()){
            if(list.get(i).equals("(")){
                s2.add(list.get(i));
                i++;
                continue;
            }
            if(list.get(i).equals("+") || list.get(i).equals("-")){
                while(!s2.isEmpty() && !s2.peek().equals("(")){
                    s1.add(s2.pop());
                }
                s2.add(list.get(i));
                i++;
                continue;
            }
            if(list.get(i).equals("*") || list.get(i).equals("/")){
                while(!s2.isEmpty() && (s2.peek().equals("*") || s2.peek().equals("/"))){
                    s1.add(s2.pop());
                }
                s2.add(list.get(i));
                i++;
                continue;
            }
            if(list.get(i).equals(")")){
                while(!s2.isEmpty() && !s2.peek().equals("(")){
                    s1.add(s2.pop());
                }
                s2.pop();
                i++;
                continue;
            }
            s1.add(list.get(i));
            i++;
        }
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
        String[] c=new String[s1.size()];
        for(int j=c.length-1; j>=0; j--){
            c[j]=s1.pop();
        }
        return c;
    }
    public static int computeNum(ArrayList<String> list){
        String[] c=getPostfixExpression(list);
        Stack<Integer> s=new Stack<>();
        for(int i=0; i<c.length; i++){
            int t1, t2;
            if(c[i].equals("+")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2+t1);
                continue;
            }
            if(c[i].equals("-")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2-t1);
                continue;
            }
            if(c[i].equals("*")){
                t1=s.pop();
                t2=s.pop();
                s.add(t2*t1);
                continue;
            }
            if(c[i].equals("/")){
                t1=s.pop();
                t2=s.pop();
                //小数需要处理，本题都是整除的，如果不是整数的话，可以将栈中的元素类型修改为double类型的
                s.add(t2/t1);
                continue;
            }
            s.add(Integer.parseInt(c[i]));
        }
        return s.pop();
    }


    public static class RuleC{
        private List<Integer> status;

        private List<Integer> payStatus;


    }
}
