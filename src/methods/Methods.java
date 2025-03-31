package methods;

import java.util.ArrayList;
import java.util.HashMap;

public class Methods {
    public LinkedListNode<Integer> IncreasingLinkedListNode(ArrayList<Integer> list){
        if(list.isEmpty()){
            return null;
        }

        if(list.size() == 1){
            return new LinkedListNode<>(list.get(0), null);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        LinkedListNode<Integer> head = new LinkedListNode<>(list.get(0), null);
        LinkedListNode<Integer> tail = head;

        for (int i = 1; i < list.size(); i++) {
            tail.setNext(new LinkedListNode<>(list.get(i), null));
            tail = tail.getNext();
        }

        return head;
    }

    public int UniqueValuesInHashMap(HashMap<String, Integer> map){
        return 0;
    }

    public boolean OneNodeLinkedList(LinkedListNode<String> node){
        return false;
    }

    public double AverageOfLinkedList(LinkedListNode<Integer> LLN){
        return 0.0;
    }
}
