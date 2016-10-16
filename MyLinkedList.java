public class MyLinkedList<X>{
public  class Node<X>
 	{  private X element;
 	   private Node<X> next; 
       public Node(X e, Node<X> n) 
  	       {  
  		 element = e; 
  		 next = n;  
  		 	} 
  	 public X getElement()
  	 	 {
  	 	 return element;
  	 	 	  } 
  	 public Node<X> getNext()
  	  	 {
  	  	 return next; } 
  	  	
	 public void setNext(Node<X> n)
  	  		 { next = n; } 
 	}
 public Node<X> head = null;  
 public Node<X> tail = null; 
 public int size = 0; 
 
 public MyLinkedList() {} 
 
  public int size() { return size; } 
  
 public boolean isEmpty() { return size == 0; } 
 
  public X first() { 
  	 	 if (isEmpty())
  	 	 	 return null; 
  	 	 	 return head.getElement(); 
  	 	 	 	 } 
				 
   public X last() {  
   	if (isEmpty()) 
  	 	return null; 
  	 	 return tail.getElement(); 
  	  } 
	  
  public void addFirst(X e) { 
  
  	 	 head = new Node(e, head);
  	 	 if (size == 0)  
  	 	 	tail = head;
  	 	    size++;  

  	 	 	  	} 
				
  	public void addLast(X e) { 
  	 	 Node<X> newest = new Node(e, null);
  	 	 if (isEmpty()) 
		 { head = newest; 
		 tail=newest;}
  	 	  tail.setNext(newest); 
  	 	  tail = newest; 
		  size++;
  	 	 	 	 } 
				 
       public X removeFirst() { 
       	if (isEmpty()) 
       	return null; 
       	 X answer = head.getElement(); 
       	  head = head.getNext();  size--; 
       	 if (size == 0)  tail = null; 
       	 	 return answer; 
       	 	 	 } 
				 
     public void remove(X e) throws Exception {
     	if(size==0)
			throw new Exception("Element not found");
     	
		Node<X> mynode =head;
		if(mynode.getElement()==e){
			head=mynode.getNext();
			
			size--;
			return;
		}
		else{
			Node<X> cnode =null;
			while(mynode.getElement()!=e && mynode!=null){
				cnode=mynode;
				mynode=mynode.getNext();
			}
			if(mynode.getElement()==e)
			{cnode.setNext(mynode.getNext());
		size--;
		}
		}
		
       }
	   
      public X getElementati(int n){
      	if(n>size)
      		return null;
      		Node<X> mynode=head;
      	for(int i=2;i<=n;i++){
      		mynode=mynode.getNext();
      	}
      	return mynode.getElement();
      }
	  public boolean IsMember(X e){
     	if(size==0)
			return false;
		int i=1;
     	Node mynode=head;
     	
		  while(i<size)
		  {
			  if(mynode.getElement()==e)
				return true;
		    mynode=mynode.getNext();
			i++;
		  }
		  if(mynode.getElement()==e)
			  return true;
		  return false;
       }
}