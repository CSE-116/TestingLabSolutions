package test;

import methods.*;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {

    @Test
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
        Tests tests = new Tests();

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

    @Test
    public void testMethod2(){

    }

    @Test
    public void testMethod3(){

    }

    @Test
    public void testMethod4(){

    }

    @Test
    public void testMethod5(){

    }


}
