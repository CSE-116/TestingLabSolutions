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

        //I used bubble sort because it's easy and I know how to do it,
        //but you can use any sorting algorithm you want! :)
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


    public int UniqueElementsInArrayList(ArrayList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }

        ArrayList<Integer> uniqueList = new ArrayList<>();

        for(int i : list){
            if(!uniqueList.contains(i)){
                uniqueList.add(i);
            }
        }
        return uniqueList.size();
    }

    public int UniqueValuesInHashMap(HashMap<String, Integer> map){
        if(map.isEmpty()){
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(String key : map.keySet()){
            if(!list.contains(map.get(key))){
                list.add(map.get(key));
            }
        }
        return list.size();
    }

    public boolean OneNodeLinkedList(LinkedListNode<String> node){
        if(node == null || node.getNext() == null){
            return true;
        }
        return false;
    }

    public double AverageOfLinkedList(LinkedListNode<Integer> LLN){
        if(LLN == null){
            return 0.0;
        }

        int sum = 0;
        int count = 0;

        while(LLN!=null){
            sum += LLN.getValue();
            count++;
            LLN = LLN.getNext();
        }
        double avg = (double) sum / count;
        return avg;
    }
}
