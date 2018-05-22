package app.exercise;

import app.exercise.visualtree.DrawableTreeElement;


public class BSKnode<T extends Comparable> implements DrawableTreeElement{

    BSKnode last;
    BSKnode left;
    BSKnode right;
    T value;

    public void setValue(T v){
        value = v;
    }

    public void setLeft(BSKnode l){
        left = l;
    }

    public void setRight(BSKnode r){
        right = r;
    }

    public void setLast(BSKnode la){
        last = la;
    }

    public BSKnode(T val){
        value = val;
    }

    public BSKnode getLast(){
        return last;
    }

    public DrawableTreeElement <T > getLeft (){
        return left;
    }

    public DrawableTreeElement <T > getRight (){
        return right;
    }

    public boolean isRed (){
        return true;
    }

    public T getValue (){
        return value;
    }

    public int compareTo(Object o){
        BSKnode p = (BSKnode) o;
        return p.getValue().compareTo(this.value);
    }
}
