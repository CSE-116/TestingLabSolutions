package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import quiz.*;
import quiz2.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class QuizTest {
    @Test
    public void basicTest(){
        BinaryTreeNode<Integer> node0 = new BinaryTreeNode<>(0,null,null);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1,null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2,null,null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3,null,null);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4,null,null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5,null,null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6,null,null);

        ArrayList<BinaryTreeNode<Integer>> allNodes = new ArrayList<>(List.of(node0, node1, node2, node3, node4, node5, node6));

        for(BinaryTreeNode<Integer> node : allNodes){
            ArrayList<Integer> list = TreeToArrayList.traverse(node);
            assertTrue(list.contains(node.getValue()));
            assertEquals(1, list.size());
        }
    }

    @Test
    public void testEmpty(){
        BinaryTreeNode<Integer> node0 = null;
        assertTrue(TreeToArrayList.traverse(node0).isEmpty());

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(null,null,null);
        assertTrue(TreeToArrayList.traverse(node1).contains(null));
    }

    @Test
    public void allRightsTest(){
        BinaryTreeNode<Integer> node0 = new BinaryTreeNode<>(0,null,null);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1,null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2,null,null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3,null,null);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4,null,null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5,null,null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6,null,null);

        //ALL RIGHT
        node0.setRight(node1);
        node1.setRight(node2);
        node2.setRight(node3);
        node3.setRight(node4);
        node4.setRight(node5);
        node5.setRight(node6);

        for(int i = 0; i < 7; i++){
            ArrayList<Integer> list = TreeToArrayList.traverse(node0);
            assertEquals(list.size(),7);
            assertTrue(list.contains(i));
        }

        BinaryTreeNode<Integer> node10 = new BinaryTreeNode<>(10,null,null);
        BinaryTreeNode<Integer> node11 = new BinaryTreeNode<>(11,null, null);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12,null,null);
        BinaryTreeNode<Integer> node13 = new BinaryTreeNode<>(13,null,null);
        BinaryTreeNode<Integer> node14 = new BinaryTreeNode<>(14,null,null);
        BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>(15,null,null);
        BinaryTreeNode<Integer> node16 = new BinaryTreeNode<>(16,null,null);

        node6.setRight(node10);
        node10.setRight(node11);
        node11.setRight(node12);
        node12.setRight(node13);
        node13.setRight(node14);
        node14.setRight(node15);
        node15.setRight(node16);

        ArrayList<Integer> list = TreeToArrayList.traverse(node0);
        assertEquals(list.size(), 14);
        for(int i = 0; i < 17; i++){
            if(i < 7) {
                assertTrue(list.contains(i));
            } else if(i < 10){
                assertFalse(list.contains(i));
            } else{
                assertTrue(list.contains(i));
            }
        }

        node16.setRight(node15);
        node15.setRight(node14);
        node14.setRight(node13);
        node13.setRight(node12);
        node12.setRight(node11);
        node11.setRight(node10);
        node10.setRight(node6);
        node6.setRight(node5);
        node5.setRight(node4);
        node4.setRight(node3);
        node3.setRight(node2);
        node2.setRight(node1);
        node1.setRight(node0);
        node0.setRight(null);

        list = TreeToArrayList.traverse(node16);
        assertEquals(list.size(), 14);
        for(int i = 0; i < 17; i++){
            if(i < 7) {
                assertTrue(list.contains(i));
            } else if(i < 10){
                assertFalse(list.contains(i));
            } else{
                assertTrue(list.contains(i));
            }
        }
    }

    @Test
    public void allLeftsTest(){
        BinaryTreeNode<Integer> node0 = new BinaryTreeNode<>(0,null,null);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1,null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2,null,null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3,null,null);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4,null,null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5,null,null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6,null,null);

        //ALL LEFT
        node0.setLeft(node1);
        node1.setLeft(node2);
        node2.setLeft(node3);
        node3.setLeft(node4);
        node4.setLeft(node5);
        node5.setLeft(node6);

        for(int i = 0; i < 7; i++){
            ArrayList<Integer> list = TreeToArrayList.traverse(node0);
            assertEquals(list.size(), 7);
            assertTrue(list.contains(i));
        }

        BinaryTreeNode<Integer> node10 = new BinaryTreeNode<>(10,null,null);
        BinaryTreeNode<Integer> node11 = new BinaryTreeNode<>(11,null, null);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12,null,null);
        BinaryTreeNode<Integer> node13 = new BinaryTreeNode<>(13,null,null);
        BinaryTreeNode<Integer> node14 = new BinaryTreeNode<>(14,null,null);
        BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>(15,null,null);
        BinaryTreeNode<Integer> node16 = new BinaryTreeNode<>(16,null,null);

        node6.setLeft(node10);
        node10.setLeft(node11);
        node11.setLeft(node12);
        node12.setLeft(node13);
        node13.setLeft(node14);
        node14.setLeft(node15);
        node15.setLeft(node16);

        ArrayList<Integer> list = TreeToArrayList.traverse(node0);
        assertEquals(list.size(), 14);
        for(int i = 0; i < 17; i++){
            if(i < 7) {
                assertTrue(list.contains(i));
            } else if(i < 10){
                assertFalse(list.contains(i));
            } else{
                assertTrue(list.contains(i));
            }
        }

        node16.setLeft(node15);
        node15.setLeft(node14);
        node14.setLeft(node13);
        node13.setLeft(node12);
        node12.setLeft(node11);
        node11.setLeft(node10);
        node10.setLeft(node6);
        node6.setLeft(node5);
        node5.setLeft(node4);
        node4.setLeft(node3);
        node3.setLeft(node2);
        node2.setLeft(node1);
        node1.setLeft(node0);
        node0.setLeft(null);

        list = TreeToArrayList.traverse(node16);
        assertEquals(list.size(), 14);
        for(int i = 0; i < 17; i++){
            if(i < 7) {
                assertTrue(list.contains(i));
            } else if(i < 10){
                assertFalse(list.contains(i));
            } else{
                assertTrue(list.contains(i));
            }
        }
    }

    @Test
    public void testMultiples(){
        //LEFT SUBTREE
        ArrayList<Integer> expected = new ArrayList<>(List.of(8,8,9,9,18,19,19,50,60,60,60,60));
        BinaryTreeNode<Integer> node50 = new BinaryTreeNode<>(50, new BinaryTreeNode<>(60,null,null),null);
        BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9, new BinaryTreeNode<>(19,null,null), node50);
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8,node9, new BinaryTreeNode<>(9,new BinaryTreeNode<>(60,null,null),null));

        //RIGHT SUBTREE
        BinaryTreeNode<Integer> node18 = new BinaryTreeNode<>(18, new BinaryTreeNode<>(19, null,null), new BinaryTreeNode<>(60, new BinaryTreeNode<>(60,null,null),null));

        //ALL TOGETHER
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8, node8,node18);


        ArrayList<Integer> actual = TreeToArrayList.traverse(root);
        assertEquals(expected.size(),actual.size());

        for(int num : expected){
            assertTrue(actual.contains(num));
            actual.remove(actual.indexOf(num));
        }
    }

    @Test
    public void testNormalTree(){
        ArrayList<Integer> expected = new ArrayList<>(List.of(7,14,2,6,12,12,14,23,6,3,5,11));
        //LEFT SUBTREE
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12, new BinaryTreeNode<>(12, new BinaryTreeNode<>(23,null,null),null),new BinaryTreeNode<>(14,null,null));
        BinaryTreeNode<Integer> node14 = new BinaryTreeNode<>(14,new BinaryTreeNode<>(2,new BinaryTreeNode<>(6,null,null),null),node12);

        //RIGHT SUBTREE
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, new BinaryTreeNode<>(5,null,new BinaryTreeNode<>(11,null,null)),new BinaryTreeNode<>(3,null,null));

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, node14, node6);

        ArrayList<Integer> actual = TreeToArrayList.traverse(node7);

        assertEquals(expected.size(),actual.size());

        for(int num : expected){
            assertTrue(actual.contains(num));
            actual.remove(actual.indexOf(num));
        }

    }
}
