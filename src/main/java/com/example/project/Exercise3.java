package com.example.project;
import java.util.ArrayList;

public class Exercise3 {

    public static void main(String[] args) {
        Exercise3 obj = new Exercise3();

        BST<Integer> tree = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree.insert(value);
        }

        System.out.print(obj.bstEstrictamenteBinario(tree));
        
    }

    public <T extends Comparable<T>> boolean bstEstrictamenteBinario(BST<T> a){
        ArrayList<String> lst= lista(a.preOrder());
        if(lst.size() % 2==0 || lst.size()== 1)
            return false;
        return revisar(lst);
    }

    public static boolean revisar( ArrayList<String> lst){
        if(lst.size()==1)
            return true;
        ArrayList<String> lst1= new ArrayList<String>();
        ArrayList<String> lst2= new ArrayList<String>();
        String str;
        for (int i= 1; i< lst.size(); i++) {
            str= lst.get(i);
            if(str.compareTo(lst.get(0))< 0)
                lst1.add(str);
            else
                lst2.add(str);
        }
        if(lst2.isEmpty())
            return false;  
        return revisar(lst1) && revisar(lst2);
    }
    
    public static ArrayList<String> lista(String p){
        ArrayList<String> lst= new ArrayList<String>();
        while(p.indexOf(" ")>= 0){
            lst.add(p.substring(0, p.indexOf(" ")));
            p= p.substring(p.indexOf(" ")+ 1);
        }
        return lst;
    }
}
