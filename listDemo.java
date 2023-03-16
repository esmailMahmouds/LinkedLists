import java.util.Scanner;

public class listDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    String str = sc.nextLine().replaceAll("\\[|\\]","");
	    String[] s =str.split(", ");
	    list num=new list(null, null);
		for(int i=0;i<s.length;i++)
			num.addlast(new node(Integer.parseInt(s[i]),null));
		sc.close();
		num.display();
//		list sub=new list(null,null);
//		node p=num.head;
//		node temp;
//		for(int i=0;i<10;i++)
//		{
//			//System.out.println("here "+i);
//			sub.display();
//			p=p.getNext();
//			temp=p;
//			System.out.println(p.getVal());
//			sub.addFrist(temp);
//			
//		}	
//		sub.display();
	}

}
