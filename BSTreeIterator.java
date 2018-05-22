package app.exercise.adt;

import app.exercise.visualtree.DrawableTreeElement;
import app.exercise.BSKnode;

public class BSTreeIterator<E extends BSKnode> implements java.util.Iterator{

    private E root;
    private E lastV = null;

    public BSTreeIterator(E obj){
        root = obj;
    }

    public E getRoot(){
        return root;
    }

    public void setLastV(E lV){
        lastV = lV;
    }

    public E getlastV(){
        return lastV;
    }

    public boolean hasNext(){
        if(lastV != null){
            BSTreeIterator<E> n = new BSTreeIterator<>(lastV);
            n.setLastV(lastV);
            return (n.next() != null);
        }
        else{
            return true;
        }
    }

    public E next(){
        if(lastV != null){
            if(root.getLeft() != null){
                if(((E) root.getLeft()).compareTo(lastV) <= 0){
                    if(root.compareTo(lastV) <= 0){
                        if(root.getRight() != null){
                            BSTreeIterator<E> n = new BSTreeIterator<E>((E) root.getRight());
                            n.setLastV(lastV);
                            E x = n.next();
                            this.setLastV(x);
                            return x;
                        }
                        else{
                            return null;
                        }
                    }
                    else{
                        lastV = root;
                        return root;
                    }
                }
                else{
                    BSTreeIterator<E> n = new BSTreeIterator<E>((E) root.getLeft());
                    n.setLastV(lastV);
                    E x = n.next();
                    this.setLastV(x);
                    return x;
                }
            }
            else{
                lastV = root;
                return root;
            }
        }
        else{
            if(root.getLeft() != null){
                System.out.println();
                BSTreeIterator<E> n = new BSTreeIterator<E>((E) root.getLeft());
                E x = n.next();
                lastV = x;
                return x;
            }
            else{
                lastV = root;
                return root;
            }
        }

    }

}
