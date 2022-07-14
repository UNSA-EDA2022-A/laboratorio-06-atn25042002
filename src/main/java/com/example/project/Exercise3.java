import java.util.ArrayList;
package com.example.project;

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
        if(a.size % 2==0 || lst.size()== 1)
            return false;
        ArrayList<String> r= new ArrayList<String>();
        r.add(lst.get(0));
        r.add(lst.get(1));
        for(int i= 2; i<lst.size(); i++){
            if(lst.get(i-2).compareTo(lst.get(i-1))> 0 && lst.get(i).compareTo(lst.get(i-2))> 0){
                r.remove(r.size()-1);
                r.remove(r.size()-1);
            }
            else{
                r.add(lst.get(i));
            }
        }
        return r.size()==0;
    }
}
