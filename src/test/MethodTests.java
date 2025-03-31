package test;

import methods.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MethodTests {

    @org.junit.Test
    public void testMethod1(){
        HashMap<LinkedListNode<Integer>, ArrayList<Integer>> map = new HashMap<>();

        //EMPTY TEST CASE
        map.put(null,new ArrayList<>());

        //TEST CASE WITH ONE LINKED LIST NODE
        map.put(new LinkedListNode<>(10,null), new ArrayList<>(List.of(10)));

        //TEST WITH SEVERAL NODES
        LinkedListNode<Integer> node100 = new LinkedListNode<>(100, null);
        LinkedListNode<Integer> node10 = new LinkedListNode<>(10, node100);
        LinkedListNode<Integer> node8 = new LinkedListNode<>(8, node10);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5, node8);
        LinkedListNode<Integer> node5Again = new LinkedListNode<>(5, node5);
        LinkedListNode<Integer> node0 = new LinkedListNode<>(0, node5Again);
        LinkedListNode<Integer> head = new LinkedListNode<>(-1,node0);

        map.put(head,new ArrayList<>(List.of(5,8,10,100,0,-1,5)));

        Methods methods = new Methods();
        MethodTests tests = new MethodTests();

        for(LinkedListNode<Integer> node : map.keySet()){
            LinkedListNode<Integer> actual = methods.IncreasingLinkedListNode(map.get(node));
            assertTrue(tests.methodHelper(node,actual));
        }
    }

    public boolean methodHelper(LinkedListNode<Integer> node1, LinkedListNode<Integer> node2){
        if(node1 == null ^ node2 == null){
            //the ^ is an exclusive or operator. Basically, if one is null but not the other,
            //the method will return false.
            return false;
        }
        if(node1 == null && node2 == null) {
            return true;
        }
        assertEquals(node1.getValue(), node2.getValue());
        return methodHelper(node1.getNext(),node2.getNext());
    }

    @org.junit.Test
    public void testMethod2(){
        Methods methods = new Methods();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //TESTING ALL UNIQUE
        map.put(5, new ArrayList<>(List.of(1,2,3,4,5)));
        //TESTING EMPTY
        map.put(0, new ArrayList<>());
        //TESTING ALL SAME
        map.put(1, new ArrayList<>(List.of(5,5,5,5,5,5,5,5,5,5,5)));
        //TESTING MIXED
        map.put(3,new ArrayList<>(List.of(1,1,1,1,1,1,2,2,2,2,3,3,3,3,2,2,2,1,1,1,1)));

        for(int key : map.keySet()){
            int num = methods.UniqueElementsInArrayList(map.get(key));
            assertEquals(key, num);
        }
    }

    @org.junit.Test
    public void testMethod3(){
        Methods methods = new Methods();

        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        //TESTING EMPTY
        map.put(0,new HashMap<>());

        //TESTING ALL SAME
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Hello,", 1);
        map1.put("how", 1);
        map1.put("are", 1);
        map1.put("you", 1);
        map1.put("doing", 1);
        map1.put("today,", 1);
        map1.put("my", 1);
        map1.put("friend?", 1);
        map1.put(":D", 1);

        map.put(1,map1);

        //TESTING ALL UNIQUE
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("how",-1);
        map2.put("are", 3);
        map2.put("you", 4);
        map2.put("doing", 5);
        map2.put("today,", 6);
        map2.put("my", 7);
        map2.put("friend?", 8);
        map2.put(":D", 9);

        map.put(8, map2);

        //TESTING MIXED
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("how",-4);
        map3.put("are", 3);
        map3.put("you", -4);
        map3.put("doing", -4);
        map3.put("today,", 6);
        map3.put("my", 7);
        map3.put("friend?", 6);
        map3.put(":D", -4);

        map.put(4, map3);

        for(int num : map.keySet()){
            int actual = methods.UniqueValuesInHashMap(map.get(num));
            assertEquals(num,actual);
        }
    }

    @org.junit.Test
    public void testMethod4(){
        Methods methods = new Methods();

        HashMap<LinkedListNode<String>, Boolean> map = new HashMap<>();
        //EMPTY LL
        map.put(null, true);

        //ONE NODE LL
        map.put(new LinkedListNode<>("Hello world", null), true);

        //MORE THAN ONE NODE LLN
        map.put(new LinkedListNode<>("Hello", new LinkedListNode<>("World", null)), false);

        for(LinkedListNode<String> node : map.keySet()){
            boolean bool = methods.OneNodeLinkedList(node);
            assertEquals(bool, map.get(node));
        }
    }

    @org.junit.Test
    public void testMethod5(){
        Methods methods = new Methods();
        HashMap<Double, LinkedListNode<Integer>> map = new HashMap<>();

        //EMPTY LL
        map.put(0.0,null);

        //ONE NODE
        map.put(8.0, new LinkedListNode<>(8, null));

        //MULTIPLE NODES (EASY NUMBERS)
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node1);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3, node2);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4,node3);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5, node4);

        map.put(3.0, node5);

        //UGLy NUMBER TEST
        map.put(4.1666, new LinkedListNode<>(10, node5));

        //NEGATIVE NUMBERS
        map.put(2.0, new LinkedListNode<>(-3, node5));

        for(double avg : map.keySet()){
            double actual = methods.AverageOfLinkedList(map.get(avg));
            assertEquals(avg, actual,.001);
        }
    }
}
