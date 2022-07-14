package com.example.project;
import java.util.ArrayList;
import java.util.HashMap;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstSimilares(tree1, tree2));
        
    }

    public <T extends Comparable<T>> boolean bstSimilares(BST<T> a1, BST<T> a2){
        ArrayList<String> lst1= lista(a1.postOrder());
        ArrayList<String> lst2= lista(a2.postOrder());
        HashMap<String, String> hash= new HashMap<String, String>();
        if (lst1.size() != lst2.size())
            return false;
        else{
            for (int i= 0; i< lst1.size(); i++) {
                hash.put(lst1.get(i), lst2.get(i));
            }
        }
        ArrayList<String> lstpre1= lista(a2.preOrder());
        ArrayList<String> lstpre2= lista(a2.preOrder());
        for (int i= 0; i< lstpre1.size(); i++) {
            if(!lstpre2.get(i).equals(hash.get(lstpre1.get(i))))
                return false;
        }
        return true;
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
