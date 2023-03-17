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
            case('R'):
                for(int i=0; i<terms.length; i++){
                    R.add(terms[i][0],terms[i][1]);
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
            case('R'):
                return R.printList();
            default:
                return null;
        }
    }

    public void clearPolynomial(char poly) {
        switch(poly){
            case('A'):
                A.clear();
                break;
            case('B'):
                B.clear();
                break;
            case('C'):
                C.clear();
                break;
            default:
                break;
        }
    }

    public float evaluatePolynomial(char poly, float value) {
        float val = 0;
        switch(poly){
            case('A'):
                for(int i = 0;i<A.size();i++) {
                    int[] tmp = A.get(i);
                    val += tmp[0]*Math.pow(value,tmp[1]);    
                }
                break;
            case('B'):
                for(int i = 0;i<B.size();i++) {
                    int[] tmp = B.get(i);
                    val += tmp[0]*Math.pow(value,tmp[1]);    
                }
                break;
            case('C'):
                for(int i = 0;i<B.size();i++) {
                    int[] tmp = B.get(i);
                    val += tmp[0]*Math.pow(value,tmp[1]);    
                }
                break;
            default:
                break;
        }
        return val;
    }
    public int[][] add(char poly1, char poly2){
        int[][] result = null;
        int k=0;
        if(poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A'){
            if(A.size >= B.size){
                result = new int[A.size][2];
                for(int i = 0;i<A.size;i++){
                    int[] a = A.get(i);
                    int[] b = B.get(0);
                    if(a[1]!=b[1]){
                        result[k][0] = a[0];
                        result[k][1] = a[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<B.size;i++){
                    int[] a = A.get(k);
                    int[] b = B.get(i);
                    result[k][0]=a[0]+b[0];
                    result[k][1]=a[1];
                    k++;
                }
            }
            else{
                result = new int[B.size][2];
                for(int i = 0;i<B.size;i++){
                    int[] b = B.get(i);
                    int[] a = A.get(0);
                    if(a[1]!=b[1]){
                        result[k][0] = b[0];
                        result[k][1] = b[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<A.size;i++){
                    int[] a = A.get(i);
                    int[] b = B.get(k);
                    result[k][0]=a[0]+b[0];
                    result[k][1]=b[1];
                    k++;
                }
            }
        }
        else if(poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A'){
            if(A.size > C.size){
                result = new int[A.size][2];
                for(int i = 0;i<A.size;i++){
                    int[] a = A.get(i);
                    int[] c = C.get(0);
                    if(a[1]!=c[1]){
                        result[k][0] = a[0];
                        result[k][1] = a[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<C.size;i++){
                    int[] a = A.get(k);
                    int[] c = C.get(i);
                    result[k][0]=a[0]+c[0];
                    result[k][1]=a[1];
                    k++;
                }
            }
            else{
                result = new int[C.size][2];
                for(int i = 0;i<C.size;i++){
                    int[] a = A.get(0);
                    int[] c = C.get(i);
                    if(a[1]!=c[1]){
                        result[k][0] = c[0];
                        result[k][1] = c[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<A.size;i++){
                    int[] a = A.get(i);
                    int[] c = C.get(k);
                    result[k][0]=a[0]+c[0];
                    result[k][1]=c[1];
                    k++;
                }
            }
        }
        else if(poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B'){
            if(B.size > C.size){
                for(int i = 0;i<B.size;i++){
                    int[] b = B.get(i);
                    int[] c = C.get(0);
                    if(b[1]!=c[1]){
                        result[k][0] = b[0];
                        result[k][1] = b[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<C.size;i++){
                    int[] b = B.get(k);
                    int[] c = C.get(i);
                    result[k][0]=b[0]+c[0];
                    result[k][1]=b[1];
                    k++;
                }
            }
            else{
                result = new int[C.size][2];
                for(int i = 0;i<C.size;i++){
                    int[] b = B.get(0);
                    int[] c = C.get(i);
                    if(b[1]!=c[1]){
                        result[k][0] = c[0];
                        result[k][1] = c[1];
                        k++;
                    }
                    else{
                        break;
                    }
                }
                for(int i = 0;i<B.size;i++){
                    int[] b = B.get(i);
                    int[] c = C.get(k);
                    result[k][0]=b[0]+c[0];
                    result[k][1]=c[1];
                    k++;
                }
            }
        }
        else if(poly1 == poly2){
            if(poly1 == 'A'){
                result = new int [A.size][2];
                for(int i = 0;i<A.size;i++){
                    int[] a = A.get(i);
                    result[i][0] = 2*a[0];
                    result[i][1] = a[1]; 
                }
            }
            else if(poly1 == 'B'){
                result = new int [B.size][2];
                for(int i = 0;i<B.size;i++){
                    int[] b = B.get(i);
                    result[i][0] = 2*b[0];
                    result[i][1] = b[1]; 
                }
            }
            else{
                result = new int [C.size][2];
                for(int i = 0;i<C.size;i++){
                    int[] c = C.get(i);
                    result[i][0] = 2*c[0];
                    result[i][1] = c[1]; 
                }
            }
        }
        return result;
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
                char idst = sc.nextLine().charAt(0);
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
                solver.setPolynomial(idst, terms);
                break;
            case("print"):
                char idpr = sc.nextLine().charAt(0);
                System.out.println(solver.print(idpr));   
                break;
            case("add"):
                char idad1 = sc.nextLine().charAt(0);
                char idad2 = sc.nextLine().charAt(0);
                solver.setPolynomial('R',solver.add(idad1,idad2));
                System.out.println(solver.print('R'));
                break;
            case("sub"):
                            
                break;
            case("mult"):
                                
                break;
            case("clear"):
                char idcr = sc.nextLine().charAt(0);
                solver.clearPolynomial(idcr);
                System.out.println("[]");
                break;
            case("eval"):
                char idev = sc.nextLine().charAt(0);
                float value = sc.nextFloat();
                if(value == Math.round(value))
                   System.out.printf("%d",(int)solver.evaluatePolynomial(idev,value));
                else
                   System.out.printf("%f",solver.evaluatePolynomial(idev,value));                
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
    
    public int[] get(int index){
        Node arwd = head;
        for(int i=0;i<index;i++){
            if(arwd.next!=null){
                arwd = arwd.next;
            }
        }
        int arr[] = {arwd.cof,arwd.exp};
        return arr;
    }
    
    public void set(int index,int cof,int exp){
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
    
    public void clear(){
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void remove(int index){
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
    
    public int size(){
        return size;
    }
    
    public DoubleLinkedList sublist(int fromIndex, int toIndex){
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
            else if(node.cof != 0)
                eq += String.format("%d",node.cof);
        }
        else if(node.exp == 1){
            if(node.cof == 1)
                eq += "x";
            else if(node.cof == -1)
                eq += "-x";
            else if(node.cof != 0)
                eq += String.format("%dx",node.cof);
        }
        else{
            if(node.cof == 1)
                eq += String.format("x^%d",node.exp);
            else if(node.cof == -1)
                eq += String.format("-x^%d",node.exp);
            else if(node.cof != 0)
                eq += String.format("%dx^%d",node.cof,node.exp);
        }
        while(node.next != null){
            node = node.next;
            if(node.exp == 0){
                if(node.cof == 1)
                    eq += "+1";
                else if(node.cof == -1)
                    eq += "-1";
                else if(node.cof != 0)
                    eq += String.format("%+d",node.cof);
            }
            else if(node.exp == 1){
                if(node.cof == 1)
                    eq += "+x";
                else if(node.cof == -1)
                    eq += "-x";
                else if(node.cof != 0)
                    eq += String.format("%+dx",node.cof);
            }
            else{
                if(node.cof == 1)
                    eq += String.format("+x^%d",node.exp);
                else if(node.cof == -1)
                    eq += String.format("-x^%d",node.exp);
                else if(node.cof != 0)
                    eq += String.format("%+dx^%d",node.cof,node.exp);
            }
        }
        return eq;    
    }
}
