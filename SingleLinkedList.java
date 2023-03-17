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


public class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    public class node {
        Object val;
        node next;
        public node(Object val,node next)
        {
            this.val=val;
            this.next=next;
        }
        public Object getVal()
        {
            return val;
        }
        public node getNext()
        {
            return next;
        }
        public void setVal(int newVal)
        {
            val=newVal;
        }
        public void setNext(node newNext)
        {
            next=newNext;
        }
    }
    node head;
    node tail;
    int size;
    public SingleLinkedList()
    {
        head=null;
        tail=null;
        size=0;
    }
    public void addFrist(node newNode)
    {
       if(isEmpty())
       {
           head=tail=newNode;
       }
       else
       {
          newNode.setNext(head); //make newNode point to old head node 
          head=newNode;           //make head point to newNode
       }
       size++;    
    }
    public node getNode(int index)
    {
        if(index >size-1 || index<0)
        {
            System.out.println("Error");
            return null;
        }
        node p=head;
        for(int i=0;i<index;i++)
            p=p.getNext();
        return p;
    }
    public void add(Object element)
    {
        node newNode=new node(element,null);
        if(isEmpty())
        {
            head=tail=newNode;
        }
        else
        {
            //newNode.setNext(null); newNode.next=null
            tail.setNext(newNode); 
            tail=newNode;
        }
        size++;
    }
    public void add(int index, Object element)
    {
          node newNode= new node(element,null);
           if(index >size-1 || index<0)
            {
                System.out.println("Error");
                return;
            } 
            if(index==0)
                 addFrist(newNode);
             else
             {
             node p=getNode(index);
             node n=getNode(index-1);
             n.next=newNode;
             newNode.next=p;
            if(index==size-1)
                tail=newNode;     
             size++;
             }
    }
    public Object get(int index)
    {
        if(index >size-1 || index<0)
        {
            System.out.println("Error");
            return null;
        }
        node p=head;
        for(int i=0;i<index;i++)
            p=p.getNext();
        return p.getVal();
    }
    public void set(int index,Object element)
    {
         node newNode= new node(element,null);
        if(index >size-1 || index<0)
        {
            System.out.println("Error");
            return;
        }
        node p=getNode(index);
        
        newNode.next=p.next;
        if(index !=0 && index !=size-1)
        {
            node n=getNode(index-1);
            n.next=newNode;
        }
            
        if(index==0)
            head=newNode;
        if(index==size-1)
            tail=newNode;
    }
    public void clear()
    {
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty()
    {
        if(head==null)
            return true;
        else 
            return false;
    }
    public void remove(int index)
    {
        if(isEmpty())
        {
            System.out.println("Error"); 
            return;
        }
        node p=getNode(index);
        
        if(index !=0)
        {
            node n=getNode(index-1);
            n.setNext( p.getNext() );
        }
            
        else
            head=p.getNext();
        p.setNext(null);
        if(index== size-1 && size !=1 )
        {
            node n=getNode(index-1);
            tail=n;
        }
            
        size--;
    }
    public int size()
    {
        return size;
    }
    public ILinkedList sublist(int fromIndex,int toIndex)
    {
        ILinkedList sub =new SingleLinkedList();
        node p=head;
        for(int i=0;i<size;i++)
        {
            if(i>=fromIndex && i<=toIndex) {
                sub.add(p.val);
            }
            p=p.next;
        }
        return sub;
    }

    public boolean contains(Object o)
    {
        node p=head;
        for(int i=0;i<size;i++)
        {
            if(p.getVal()==o)
                return true;
            p=p.getNext();
        }
        return false;
    }
    public void display(node n)
    {
        //node n=head;
        System.out.print("[");
        for(int i=0;i<size && n != null ;i++)
        {
            System.out.print(n.getVal());
            if(i != size-1 && n.next !=null)
                System.out.print(", ");
              n=n.next;
        }
        System.out.println("]");
            
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        SingleLinkedList list=new SingleLinkedList();
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\[|\\]","");
        String[] s =str.split(", ");
        for(int i=0;i<s.length;i++)
        {
            try {
                list.add(Integer.parseInt(s[i]));
            }
            catch(NumberFormatException e) {
                break;
            }
        }
        String s2 = sc.nextLine();
        switch(s2){
            case("add"):
                int lastElement = sc.nextInt();
                list.add(lastElement);
                list.display(list.head);
                break;
            case("addToIndex"):
                int addIndex = sc.nextInt();
                int valueOfAddedElement = sc.nextInt();
                if(addIndex<list.size && addIndex>=0){
                    list.add(addIndex, valueOfAddedElement);
                    list.display(list.head);}
                else
                    System.out.println("Error");
                break;
            case("get"):
                int getIndex = sc.nextInt();
                if(getIndex<list.size && getIndex>=0)
                    System.out.println(list.get(getIndex));
                else
                    System.out.println("Error");
                break;
            case("set"):
                int setIndex = sc.nextInt();
                int valueOfSetElement = sc.nextInt();
                if(setIndex<list.size && setIndex>=0){
                    list.set(setIndex, valueOfSetElement);
                    list.display(list.head);
                }
                else
                    System.out.println("Error");
                break;
            case("clear"):
                list.clear();
                System.out.println("[]");
                break;
            case("isEmpty"):
                if(list.isEmpty()==true){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
                break;
            case("remove"):
                int removeIndex = sc.nextInt();
                if(removeIndex<list.size && removeIndex>=0){
                    list.remove(removeIndex);
                    list.display(list.head);
                }
                else
                    System.out.println("Error");
                break;
            case("size"):
                System.out.println(list.size());
                break;
            case("sublist"):
                int startIndex = sc.nextInt();
                int endIndex = sc.nextInt();
                if(startIndex<list.size && endIndex<list.size && startIndex<=endIndex && startIndex>=0){
                    SingleLinkedList sblst = (SingleLinkedList) list.sublist(startIndex, endIndex);
                    list.display(sblst.head);
                }
                else
                    System.out.println("Error");
                break;
            case("contains"):
                int valueOfMissingElement = sc.nextInt();
                if(list.contains(valueOfMissingElement)==true){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
                break;
            default:
                sc.close();
                return;   
    }
}
}
