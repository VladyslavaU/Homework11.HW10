import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//сделала перегруженный метод, т.к. для возврата коллекции надо написать,
//какую именно коллекцию вернуть. Писала только для этих двух, т.к. в других
//коллекциях данные и так не повторяются
        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("One");
        stringArray.add("Two");
        stringArray.add("Two");
        System.out.println("Initial ArrayList: " + stringArray);
        System.out.println("After removing duplicates:");
        System.out.println(removeDuplicates(stringArray));
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("One");
        stringLinkedList.add("Two");
        stringLinkedList.add("Two");
        System.out.println("Initial LinkedList: " + stringLinkedList);
        System.out.println("After removing duplicates");
        System.out.println(removeDuplicates(stringLinkedList));
        System.out.println("----------------------------------------------");

        System.out.println("Finding a square root");
        System.out.println("Square root of 5: " + sqrt(5));
        System.out.println("Square root of 121: " + sqrt(121));
        System.out.println("------------------------------------------------");


        String[] strings = {"One", "Two", "Tree", "Four", "Five"};
        ArrayIterator iterator = new ArrayIterator(strings);

        System.out.println("Current element (first): " + iterator.getCurrent());
        iterator.moveToNext();
        System.out.println("Next element (second): " + iterator.getCurrent());


        iterator.moveToStart();
        //я так и не поняла, как распечатать используя только while, без вгнезденного if
        //видела, как работает сам итератор с hasNext(), точно так же проверяю, печатаю и передвигаю
        //но у последнего элемента !hasNext(), т.е. он не распечатается. если сразу распечатывать следующий,
        //то он не напечатает первый...
        System.out.println("----------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrent());
            iterator.moveToNext();
            if (!iterator.hasNext()) {
                System.out.println(iterator.getCurrent());
            }
        }
        System.out.println("-----------------------");

        iterator.moveToStart();

        System.out.println("Deleting element One");
        String toRemove = "One";
        while (iterator.hasNext()) {
            if (iterator.getCurrent().equals(toRemove)) {
                iterator.remove();
                break;
            }
            iterator.moveToNext();
        }
        System.out.println("Array after deletion");
        System.out.println(Arrays.toString(strings));
        System.out.println("-----------------------------");
    }

    public static ArrayList removeDuplicates(ArrayList coll) {
        HashSet temp = new HashSet<>(coll);
        return new ArrayList<>(temp);
    }


    public static LinkedList removeDuplicates(LinkedList coll) {
        HashSet temp = new HashSet<>(coll);
        return new LinkedList<>(temp);
    }

    public static double sqrt(int number) { //по формуле Ньютона
        double approximate = number;
        double zeroX = 2;
        while (approximate * approximate != number) {
            approximate = (zeroX + number / zeroX) / 2;
            if (approximate == zeroX) {
                break;
            }
            zeroX = approximate;
        }
        return approximate;
    }


}
