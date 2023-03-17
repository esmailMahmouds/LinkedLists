import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPolynomialSolver {
    /**
    * Set polynomial terms (coefficients & exponents)
    * @param poly: name of the polynomial
    * @param terms: array of [coefficients][exponents]
    */
    void setPolynomial(char poly, int[][] terms);
  
    /**
    * Print the polynomial in ordered human readable representation
    * @param poly: name of the polynomial
    * @return: polynomial in the form like 27x^2+x-1
    */
    String print(char poly);
  
    /**
    * Clear the polynomial
    * @param poly: name of the polynomial
    */
      void clearPolynomial(char poly);
  
    /**
    * Evaluate the polynomial
    * @param poly: name of the polynomial
    * @param value: the polynomial constant value
    * @return the value of the polynomial
    */
    float evaluatePolynomial(char poly, float value);
  
    /**
    * Add two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial
    */
    int[][] add(char poly1, char poly2);
  
    /**
    * Subtract two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial*/
    int[][] subtract(char poly1, char poly2);
  
    /**
    * Multiply two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return: the result polynomial
    */
    int[][] multiply(char poly1, char poly2);
}

public class PolynomialSolver implements IPolynomialSolver{
    
    static DoubleLinkedList A = new DoubleLinkedList();
    static DoubleLinkedList B = new DoubleLinkedList();
    static DoubleLinkedList C = new DoubleLinkedList();
    static DoubleLinkedList R = new DoubleLinkedList();

    public void setPolynomial(char poly, int[][] terms) {
    
        switch(poly){
            case('A'):
                for(int i=0; i<terms.length; i++){
                        A.add(terms[i][0],terms[i][1]);
                }
                break;
            case('B'):
                for(int i=0; i<terms.length; i++){
                    B.add(terms[i][0],terms[i][1]);
                }
                break;
            case('C'):
                for(int i=0; i<terms.length; i++){
                    C.add(terms[i][0],terms[i][1]);
                }
                break;
            default:
                break;
        }
    }

    public String print(char poly) {
        switch(poly){
            case('A'):
                return A.printList();
            case('B'):
                return B.printList();
            case('C'):
                return C.printList();
            default:
                return null;
        }
    }

    public void clearPolynomial(char poly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearPolynomial'");
    }

    public float evaluatePolynomial(char poly, float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluatePolynomial'");
    }

    public int[][] add(char poly1, char poly2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    public int[][] subtract(char poly1, char poly2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtract'");
    }
    public int[][] multiply(char poly1, char poly2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }

    public static void main(String[] args) {
    
        PolynomialSolver solver = new PolynomialSolver();
        Scanner sc = new Scanner(System.in);
        do{
          String ky = sc.nextLine();
          switch(ky){
           case("set"):
                char id = sc.nextLine().charAt(0);
                String s1 = sc.nextLine().replaceAll("\\[|\\]","");
                String[] s = s1.split(",",0);
                int[][] terms = new int[s.length][2];
                for(int i=0,k=s.length-1;i<s.length;i++){
                    try{
                        terms[i][0]=Integer.parseInt(s[i]);
                        terms[i][1]=k--;
                    }
                    catch(NumberFormatException e){
                        break;
                    }
                }
                solver.setPolynomial(id, terms);
                System.out.println(solver.print(id));
                break;
            case("print"):
                    
                break;
            case("add"):
                        
                break;
            case("sub"):
                            
                break;
            case("mult"):
                                
                break;
            case("clear"):
                                
                break;
            case("eval"):
                                
                break;
            default:
                break;
          }
        }while(sc.hasNextLine());

    }
}

class DoubleLinkedList{

    private Node head;
    private Node tail;
    public int size;
    class Node{
        private int cof;
        private int exp;
        private Node next;
        private Node prev;
        public Node(int cof,int exp,Node next,Node prev){
            this.cof = cof;
            this.exp = exp;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    public void add(int index,int cof, int exp){
        Node node = new Node(cof,exp,null,null);
        Node tmp1 = head;
        Node tmp2;
        for(int i=0;i<index;i++){
            tmp1 = tmp1.next;
        }
        tmp2 = tmp1.prev;
        tmp2.next = node;
        node.prev = tmp2;
        tmp1.prev = node;
        node.next = tmp1;
        size++;
    }
    
    public void add(int cof, int exp){
        Node node = new Node(cof,exp,null,null);
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
    
    public void set(int index,int cof,int exp) {
        Node node = new Node(cof,exp,null,null);
        Node tmp = head;
        for(int i=0;i<index;i++){
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
        Node tmp = head;
        for(int i=0;i<index;i++){
            tmp = tmp.next;
        }
        Node aftrTmp = tmp.next;
        Node bfrTmp = tmp.prev;
        aftrTmp.prev = bfrTmp;
        bfrTmp.next = aftrTmp;
        size--;
    }
    
    public int size() {
        return size;
    }
    
    public DoubleLinkedList sublist(int fromIndex, int toIndex) {
        DoubleLinkedList Sblst = new DoubleLinkedList(); 
        Node begTmp = head;
        for(int i=0;i<size;i++){
           if(i>=fromIndex && i<=toIndex){
                Sblst.add(begTmp.cof,begTmp.exp);
            }
            begTmp = begTmp.next;
        }
        return Sblst;
    }

    public String printList(){
        String eq = "";
        Node node = head;
        if(node.exp == 0){
            if(node.cof == 1)
                eq += "1";
            else if(node.cof == -1)
                eq += "-1";
            else
                eq += String.format("%d",node.cof);
        }
        else if(node.exp == 1){
            if(node.cof == 1)
                eq += "x";
            else if(node.cof == -1)
                eq += "-x";
            else
                eq += String.format("%dx",node.cof);
        }
        else{
            if(node.cof == 1)
                eq += String.format("x^%d",node.exp);
            else if(node.cof == -1)
                eq += String.format("-x^%d",node.exp);
            else
                eq += String.format("%dx^%d",node.cof,node.exp);
        }
        while(node.next != null){
            node = node.next;
            if(node.exp == 0){
                if(node.cof == 1)
                    eq += "+1";
                else if(node.cof == -1)
                    eq += "-1";
                else
                    eq += String.format("%+d",node.cof);
            }
            else if(node.exp == 1){
                if(node.cof == 1)
                    eq += "+x";
                else if(node.cof == -1)
                    eq += "-x";
                else
                    eq += String.format("%+dx",node.cof);
            }
            else{
                if(node.cof == 1)
                    eq += String.format("+x^%d",node.exp);
                else if(node.cof == -1)
                    eq += String.format("-x^%d",node.exp);
                else
                    eq += String.format("%+dx^%d",node.cof,node.exp);
            }
        }
        return eq;    
    }
}
