package com.example.project;

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
        if(a1.root().data().compareTo(a2.root().data())==0)
            return nodeSimilares(a1.root().left(), a2.root().left()) && nodeSimilares(a1.root().right(), a2.root().right());
        return false;
    }

    public <T extends Comparable<T>> boolean nodeSimilares(Node<T> n1, Node<T> n2){
        if(n1.data().compareTo(n2.data())==0)
            return nodeSimilares(n1.left(), n2.left()) && nodeSimilares(n1.right(), n2.right());
        return false;
    }
}
