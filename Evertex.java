public class Evertex implements Comparable{
	  public Vertex vertex=new Vertex();
	  public int weight =Integer.MAX_VALUE;
	 public Evertex(){
		 
	 }
	 public Evertex(Vertex v ,int a){
		 weight=a;
		 vertex=v;
	 }
	  public boolean equals(Object obj){
        
        if (obj instanceof Evertex) {
            Evertex pp = (Evertex) obj;
            return (pp.vertex.equals(this.vertex) && pp.weight == this.weight);
        } else {
            return false;
        }
    }

	 public int compareTo(Object other) {
	  Evertex otherObject =(Evertex) other ;
	  if(weight>otherObject.weight)
		  return 1;
	  else if(weight==otherObject.weight) 
return 0;
else return -1;		  
  }
  public int hashCode(){
		return vertex.vername.hashCode();
	}
	public String toString(){
		return vertex.vername +" "+weight;
	}
 }