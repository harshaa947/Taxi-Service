import java.util.* ;
public class Graph{
	// Graph Class
	
 //Evertex class 
 
 // Adjacency class
 public class Adjacency {
	
	 public MyLinkedList<Evertex> edgelist = new MyLinkedList();
 
 public String toString(){
	 String temp="";
	 for(int i=1;i<=edgelist.size;i++)
		 temp+=edgelist.getElementati(i)+" ";
	 return temp;
 }
 public Adjacency(){
	 
}
}
// graph methods and variables
 
 private HashMap<Vertex,Adjacency> myedges = new HashMap<Vertex,Adjacency>();
 


 public Graph(){
	 
 }
 public void addEdge(String as , String bs, int number){
	 Vertex a = new Vertex(as);
	 Vertex b = new Vertex(bs);
	 if(myedges.containsKey(a))
		 myedges.get(a).edgelist.addFirst(new Evertex(b,number));
	 else{
		 Adjacency temp = new Adjacency();
			temp.edgelist.addFirst(new Evertex(b,number));
			myedges.put(a,temp);
	 }
	 if(myedges.containsKey(b))
		 myedges.get(b).edgelist.addFirst(new Evertex(a,number));
	 else{
		 Adjacency temp = new Adjacency();
			temp.edgelist.addFirst(new Evertex(a,number));
			myedges.put(b,temp);
	 }
 }
private  Myset<Vertex>  permanent;
 private Myset<Vertex>  temporary ;
private  HashMap<Vertex,Integer> distance;
private  HashMap<Vertex,Vertex> shortnode;
  
 public  MyLinkedList<Vertex> minpath(Vertex src, Vertex Destination){
	 MyLinkedList<Vertex> path = new MyLinkedList();
	 
	// declarations
     permanent = new Myset();
	 temporary = new Myset();
	 distance = new HashMap<Vertex,Integer>();
	 shortnode = new HashMap<Vertex,Vertex>();
	 // adding first node
	 permanent.Insert(src);
	 distance.put(src,0);
	 while(!permanent.IsEmpty()){
		Vertex temp =  getMinimum(permanent);
		try{
			
		permanent.Delete(temp);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		temporary.Insert(temp);
		updateNeighbours(temp);
	 }
	Vertex temp1=Destination;
	if(!shortnode.containsKey(temp1))
		return null;
	else{
		path.addFirst(temp1);
		while(shortnode.containsKey(temp1)){
			
			temp1=shortnode.get(temp1);
			path.addFirst(temp1);
		}
	}
	//System.out.println(shortnode);
	return path;
 }
 private Vertex getMinimum(Myset<Vertex> vertexes){
	 Vertex temp = null;
	 for(int i=1;i<=vertexes.Size();i++){
		 Vertex temp1=vertexes.getElementati(i);
		 if(temp==null)
			 temp=temp1;
		 else if(getDistance(temp)>getDistance(temp1))
			 temp=temp1;
	 }
	// System.out.println("called min" + temp);
	 return temp;
 }
 private void updateNeighbours (Vertex v){
	// System.out.println("called " + v);
	// if(!myedges.containsKey(v))
	//	 return;
	 MyLinkedList<Evertex> list = myedges.get(v).edgelist;
	 for(int i=1;i<=list.size;i++){
		 
		 Evertex temp = list.getElementati(i);
		 if(temporary.IsMember(temp.vertex))
			 continue;
		 int newDistance = getDistance(v) + temp.weight ;
		 if(getDistance(temp.vertex)>newDistance){
			 distance.put(temp.vertex,newDistance);
			 shortnode.put(temp.vertex,v);
			 permanent.Insert(temp.vertex);
		 }
	 }
 }
 private int getDistance(Vertex v){
	 if(distance.containsKey(v)){
		 return distance.get(v);
	 }
	 else return Integer.MAX_VALUE;
 }
 public void printGraph(){
	 System.out.println(myedges);
 }
 public int result(Vertex v){
	 if(distance.get(v)!=null)
	 return distance.get(v);
 else return 0;
 }

public boolean isnVertex (Vertex v){
	return !myedges.containsKey(v) ;
}
}