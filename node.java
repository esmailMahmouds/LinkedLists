
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
