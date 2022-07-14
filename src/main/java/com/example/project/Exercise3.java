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
        ArrayList<String> r= new ArrayList<String>();
        r.add(lst.get(0));
        r.add(lst.get(1));
        for(int i= 2; i<lst.size(); i++){
            r.add(lst.get(i));
            if(lst.get(i-2).compareTo(lst.get(i-1))> 0 && lst.get(i).compareTo(lst.get(i-2))> 0){
                r.remove(r.size()-1);
                r.remove(r.size()-1);
            }
        }
        return r.size()==1;
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
