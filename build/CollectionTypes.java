package build;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class CollectionTypes {


        public static void main(String args[]){
            ArrayList<String> list=new ArrayList<String>();//Creating arraylist
            list.add("Ravi");//Adding object in arraylist
            list.add("Vijay");
            list.add("Ravi");
            list.add("Ajay");

//Traversing list through Iterator
            Iterator itr=list.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }

            Vector<String> v=new Vector<String>();
            v.add("Ayush");
            v.add("Amit");
            v.add("Ashish");
            v.add("Garima");
            Iterator<String> itr2=v.iterator();
            while(itr2.hasNext()){
                System.out.println(itr2.next());
            }


            Stack<String> stack = new Stack<String>();
            stack.push("Ayush");
            stack.push("Garvit");
            stack.push("Amit");
            stack.push("Ashish");
            stack.push("Garima");
            stack.pop();
            Iterator<String> itr3=stack.iterator();
            while(itr3.hasNext()){
                System.out.println(itr3.next());
            }

            // Creating list using the ArrayList class
            List<Integer> numbers = new ArrayList<>();

            // Add elements to the list
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            System.out.println("List: " + numbers);

            // Access element from the list
            int number = numbers.get(2);
            System.out.println("Accessed Element: " + number);

            // Remove element from the list
            int removedNumber = numbers.remove(1);
            System.out.println("Removed Element: " + removedNumber);

            ArrayList<Integer> arrayList = new  ArrayList<Integer>();
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(5);
            System.out.println(arrayList);
            arrayList.add(2,9);
            System.out.println(arrayList);
            System.out.println(arrayList.get(3));
            arrayList.remove(2);
            System.out.println(arrayList);
//            arrayList.clear();
            System.out.println(arrayList);

            ArrayList<Integer> arrayList2 = (ArrayList<Integer>)arrayList.clone();

            arrayList2.add(4);
            System.out.println(arrayList);
            System.out.println(arrayList2);

            System.out.println(arrayList.contains(2));
            System.out.println(arrayList.equals(arrayList2));
            System.out.println(arrayList.indexOf(3));
            System.out.println(arrayList);
            System.out.println(arrayList.set(3,99));
            System.out.println(arrayList);
            System.out.println(arrayList.size());
            arrayList.add(5);
            arrayList.sort(Comparator.naturalOrder());
            System.out.println(arrayList);


            for(Integer element: arrayList){
                System.out.println(element);
            }

            Vector<Integer> numbersVector = new Vector<>();

            numbersVector.add(2);
            System.out.println(numbersVector);
            numbersVector.add(2);
            numbersVector.add(2);
            numbersVector.add(2);
            numbersVector.add(2);
            numbersVector.add(2);
            numbersVector.add(2);
            numbersVector.add(2);
            System.out.println(numbersVector);
            numbersVector.add(3,3);
            System.out.println(numbersVector);


            Stack<String> animals= new Stack<>();

            // Add elements to Stack
            animals.push("Dog");
            animals.push("Horse");
            animals.push("Cat");
            System.out.println("Initial Stack: " + animals);

            // Remove element stacks
            String element = animals.pop();
            System.out.println("Removed Element: " + element);

            String object = animals.peek();
            System.out.println("Element at top: " + object);

            int position = animals.search("Horse");
            System.out.println("Position of Horse: " + position);

            boolean result = animals.empty();
            System.out.println("Is the stack empty? " + result);


            Queue<Integer> queue = new LinkedList<>();

            // offer elements to the Queue
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            System.out.println("Queue: " + queue);

            // Access elements of the Queue
            int accessedNumber = queue.peek();
            System.out.println("Accessed Element: " + accessedNumber);

            // Remove elements from the Queue
            int removedNum = queue.poll();
            System.out.println("Removed Element: " + removedNum);

            System.out.println("Updated Queue: " + queue);



            PriorityQueue<Integer> pQueue = new PriorityQueue<>();


            // Using the add() method
            pQueue.add(4);
            pQueue.add(2);
            System.out.println("PriorityQueue: " + pQueue);

            // Using the offer() method
            pQueue.offer(1);
            System.out.println("Updated PriorityQueue: " + pQueue);

            int num = pQueue.peek();
            System.out.println("Accessed Element: " + num);

            Boolean results = pQueue.remove(2);
            System.out.println("Is the element 2 removed? " + results);

            // Using the poll() method
            int myNumber = pQueue.poll();
            System.out.println("Removed Element Using poll(): " + myNumber);

            Iterator<Integer> iterate = pQueue.iterator();
            while(iterate.hasNext()) {
                System.out.print(iterate.next());
                System.out.print(", ");
            }


            LinkedList<String> animal = new LinkedList<>();

            // add() method without the index parameter
            animal.add("Dog");
            animal.add("Cat");
            animal.add("Cow");
            System.out.println("LinkedList: " + animal);

            // add() method with the index parameter
            animal.add(1, "Horse");
            System.out.println("Updated LinkedList: " + animal);

        }


}
