import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class DoubleLinkedList implements ILinkedList {


    private Node head;
    private Node tail;
    private int size;
    class Node{
        private int element;
        private Node next;
        private Node prev;
        public Node(int element,Node next,Node prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }
    
    public void add(int index, Object element){
        Node node = new Node((int)element,null,null);
        Node tmp1 = head;
        Node tmp2;
        for(int i=1;i<index;i++){
            tmp1 = tmp1.next;
        }
        tmp2 = tmp1.prev;
        tmp2.next = node;
        node.prev = tmp2;
        tmp1.prev = node;
        node.next = tmp1;
    }
    
    public void add(Object element){
        Node node = new Node((int)element,null,null);
        if(head == null){
            head = tail = node;
        }
        else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    public Object get(int index) {
        Node arwd = head;
        for(int i=1;i<index;i++){
            arwd = arwd.next;
        }
        return arwd.element;
    }
    
    public void set(int index, Object element) {
        Node node = new Node((int)element,null,null);
        Node tmp = head;
        for(int i=1;i<index;i++){
            tmp = tmp.next;
        }
        Node aftrTmp = tmp.next;
        Node bfrTmp = tmp.prev;
        aftrTmp.prev = node;
        bfrTmp.next = node;
        node.next = aftrTmp;
        node.prev = bfrTmp;
    }
    
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
    public int size() {
        return size;
    }
    
    public ILinkedList sublist(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sublist'");
    }
    
    public boolean contains(Object o) {
        Node srchNd = new Node(0,null,null);
        srchNd = head;
        while(srchNd!= null){
            if(srchNd.element == (int)o){
                return true;
            }
            else
                srchNd = srchNd.next;
        }
        return false;
    }

    public static void main(String[] args) {
        
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().replaceAll("\\[|\\]","");
        String[] s = s1.split(", ",0);
        for(int i=0;i<s.length;i++){
            try{
                list.add(Integer.parseInt(s[i]));
            }
            catch(NumberFormatException e){
                break;
            }
        }
        sc.close();
        list.set(3, 13);;
        Node node = list.head;
        while(node != null){
            System.out.println(node.element);
            node = node.next;
        }
        /*
        String s2 = sc.nextLine();
        switch(s2){
                case("add"):
                    String lastElement = sc.nextLine();
                
                    break;
                case("addToIndex"):
                    int addIndex = sc.nextInt();
                    sc.nextLine();
                    String valueOfAddedElement = sc.nextLine();
                
                    break;
                case("get"):
                    int getIndex = sc.nextInt();
                
                    break;
                case("set"):
                    int setIndex = sc.nextInt();
                    sc.nextLine();
                    String valueOfSetElement = sc.nextLine();
                
                    break;
                case("clear"):
                    
                    break;
                case("isEmpty"):
                    
                    break;
                case("remove"):
                    int removeIndex = sc.nextInt();
                
                    break;
                case("sublist"):
                    int startIndex = sc.nextInt();
                    int endIndex = sc.nextInt();
                    break;
                case("contains"):
                    String valueOfMissingElement = sc.nextLine();
                    break;
            default:
                return;   
        } */ 
    }
}