package app.exercise.adt;

import app.exercise.BSKnode;
import java.util.Collection;
import java.util.Iterator;

public class BSTree<E extends BSKnode> extends java.util.AbstractCollection<E>{

    private E root;
    private E knode;

    public BSTree(E e){
        root = e;
        knode = root;
    }

    public E getKnode(){
        return knode;
    }

    public boolean add(E e){
        if(e.compareTo(knode) == 0){
            return false;
        }

        if(e.compareTo(knode) < 0){
            if(knode.getLeft() != null){
                BSTree<E> t = new BSTree<>((E)knode.getLeft());
                return t.add(e);
            }
            else{
                knode.setLeft(e);
                return true;
            }
        }
        else{
            if(knode.getRight() != null){
                BSTree<E> t = new BSTree<>((E) knode.getRight());
                return t.add(e);
            }
            else{
                knode.setRight(e);
                return true;
            }
        }
    }

    public boolean remove(Object e){

        e = (E) e;
        if(this.contains(e)){
            if(knode.compareTo(e) == 0){
                if(knode.getRight() != null ){
                    if(knode.getLeft() != null){
                        BSTreeIterator<E> it = new BSTreeIterator<>((E) knode.getRight());
                        this.remove(it.next());
                        knode = it.getlastV();
                        return true;
                    }
                    else{
                        knode = (E) knode.getRight();
                        return true;
                    }
                }
                else{
                    if(knode.getLeft() == null){
                        knode = null;
                    }
                    else{
                        knode = (E) knode.getLeft();
                        return true;
                    }
                }

            }
            else{
                if(knode.compareTo(e) < 0){
                    BSTree<E> n = new BSTree<>((E) knode.getLeft());
                    return n.remove(e);
                }
                else{
                    BSTree<E> n = new BSTree<>((E) knode.getRight());
                    return n.remove(e);
                }

            }

        }
        return false;
    }

    public int size(){
        int i = 0;
        Iterator<E> it = iterator();
        while(it.hasNext()){
            it.next();
            i++;
        }
        return i;
    }

    public boolean isEmpty(){
        return knode == null;
    }

    public boolean contains(Object o){
        o = (E) o;
        Iterator<E> it = iterator();
        int i;
        boolean res = false;
        while(it.hasNext()){
            i = it.next().compareTo(o);
            if(i == 0){
                res = true;
            }
        }
        return res;
    }

    public boolean containsAll(Collection<?> c){
        c = (BSTree) c;
        BSTreeIterator it = (BSTreeIterator) c.iterator();
        boolean res = true;
        while(it.hasNext()){
            if(!this.contains(it.next())){
                res = false;
            }
        }
        return res;
    }

    public Object[] toArray(){
        Object[] res = new Object[this.size()];
        BSTreeIterator<E> it = (BSTreeIterator) iterator();
        int i = 0;
        while(it.hasNext()){
             res[i] = it.next();
             i++;
        }
        return res;
    }

    public String toString(){
        String res = "";
        BSTreeIterator<E> it = (BSTreeIterator) iterator();
        int i = 0;
        while(it.hasNext()){
             res += it.next().getValue().toString() +" ";
             i++;
        }
        return res;
    }

    public Iterator<E> iterator(){
        return new BSTreeIterator<E>(root);
    }

}
