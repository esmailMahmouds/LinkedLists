import javax.swing.plaf.synth.SynthOptionPaneUI;

public class list {
        
	node head;
	node tail;
	int size;
	public list(node head,node tail)
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
	
	public void addlast(node newNode)
	{
		if(isEmpty())
		{
			head=tail=newNode;
		}
		else
		{
			newNode.setNext(null);
		    tail.setNext(newNode);
		    tail=newNode;
		}
		size++;
	}
	
	public void removeFrist()
	{
		node p;
		if(isEmpty())
		{
			System.out.println("Error"); 
			return;
		}
		else 
		{
			if(head==tail)
				tail=null;  // if the list contain one node then tail & head point to null 
			p=head;
			head=head.getNext();
			p.setNext(null);
			size--;
		}
	}
	
	public void removeLast()
	{
		node p=head;
		if(isEmpty())
		{
			System.out.println("Error"); 
			return;
		}
		else if(head ==tail)
		{
			head=tail=null;
			size--;
		}
		else 
		{				
			for(int i=1;i<size && size !=2 ;i++)
			 	  p=p.getNext();
			tail=p;
			p.setNext(null);
			size--;
		}
	}
	
	public void addtoindex(int index, node newNode)
	{
		if(index >size-1 || index<0)
		{
			System.out.println("Error");
		    return;
		} 
		if(index==0)
	    	 addFrist(newNode);
	     else if(index==size-1)
	          addlast(newNode);
	     else
	     {
	     node p=get(index);
	     node n=get(index-1);
	     n.next=newNode;
	     newNode.next=p;
	     size++;
	     }
	}
	
	public node get(int index)
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
	
	public void clear()
	{
		head=null;
		tail=null;
		size=0;
	}
	
	public void set(int index,node newNode)
	{
		if(index >size-1 || index<0)
		{
			System.out.println("Error");
		    return;
		}
		node p=get(index);
	    node n=get(index-1);
	    newNode.next=p.next;
	    if(index !=0 && index !=size-1)
	    	n.next=newNode;
	    if(index==0)
	    	head=newNode;
	    if(index==size-1)
	    	tail=newNode;
	}
	
	public boolean isEmpty()
	{
		if(head==null && tail==null && size==0)
			return true;
		else 
			return false;
	}
	public int size()
	{
		return size;
	}
	
	public list sublist(int fromIndex,int toIndex)
	{
		list sub =new list(null, null);
		node p=get(fromIndex);
		sub.addFrist(p);
		for(int i=0;i<toIndex-1;i++)
		{
			//System.out.println("here "+i);
			p=p.next;
			//System.out.println(p);
			sub.addlast(p);
		}
		return sub;
	}
	public boolean contain(Object o)
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
	public void display()
	{
		node n=head;
		System.out.print("[");
		for(int i=0;i<size && n != null ;i++)
		{
			System.out.print(n.getVal());
			if(i != size-1)
				System.out.print(",");
		      n=n.next;
		}
		System.out.println("]");
			
	}
}
