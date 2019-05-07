package com.xiecl.myShop.web.admin.web.json;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class sqlsTest {

    public static boolean IsPopOrder(int[] pushA,int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        String a="select * from custoper c1 left join CustInfo c2 on c1.custid=c2.custid where c2.custname='新民烘焙万达'";
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.empty() ? true : false;
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
}
