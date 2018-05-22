import app.excercise.algebra.CompRational;
import app.exercise.BSKnode;
import app.exercise.adt.BSTree;
import app.exercise.adt.BSTreeIterator;
import app.exercise.visualtree.RedBlackTreeDrawer;
import java.util.Random;

public class BSTreeTester{

    public static void main(String[] args){
        if(args.length % 2 != 0){
            System.out.println("Die Anzahl der Argumente muss gerade sein");
            return;
        }
        Object[] numbers = new Object[args.length/2];
        int j = 0;
        for(int i = 0;i < args.length ;i += 2){
            numbers[j] = (Object) new CompRational(Integer.parseInt(args[i]),Integer.parseInt(args[i+1]));
            j++;
        }

        Object[] knodes = new Object[args.length/2];
        for(int i = 0;i < args.length/2 ;i++){
            knodes[i] = (Object) new BSKnode<CompRational>((CompRational) numbers[i]);
        }

        RedBlackTreeDrawer<BSKnode> drawer = new RedBlackTreeDrawer<BSKnode>();

        BSTree<BSKnode> bsBaum = new BSTree((BSKnode) knodes[0]);
        for(int i = 1;i < numbers.length;i++){
            bsBaum.add((BSKnode) knodes[i]);
        }

        System.out.println(bsBaum.getKnode().getLeft().getValue());

        BSTree<BSKnode> sekBaum1 = new BSTree((BSKnode) knodes[numbers.length/2]);
        BSTree<BSKnode> sekBaum2 = new BSTree((BSKnode) knodes[numbers.length/2]);
        for(int i = 0;i < numbers.length/2;i++){
            sekBaum1.add((BSKnode) knodes[i]);
            sekBaum2.add((BSKnode) knodes[numbers.length -1 -i]);
        }

        System.out.println(bsBaum);
        System.out.println(sekBaum1);
        System.out.println(sekBaum2);

        System.out.println(bsBaum.containsAll(sekBaum1));
        System.out.println(bsBaum.containsAll(sekBaum2));

        System.out.println(bsBaum.contains(knodes[0]) + " " +bsBaum.contains(knodes[numbers.length -1]) +" "+ bsBaum.remove(knodes[0]) +" "+ bsBaum.remove(knodes[numbers.length-1]));

        Random rand = new Random();
        int n = 0;
        while(n < 100){
            CompRational x = new CompRational(rand.nextInt(),rand.nextInt());
            BSKnode<CompRational> y= new BSKnode<CompRational>(x);
            if((x.compareTo((CompRational) numbers[0]) >= 0 )&&( x.compareTo((CompRational) numbers[numbers.length-1]) <0) ){
                if(bsBaum.contains(y)){
                    bsBaum.remove(y);
                }
                n++;
            }
        }

    }
}
