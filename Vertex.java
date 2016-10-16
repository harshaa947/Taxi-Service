public class Vertex {
	 public int id=0;
	 public String vername="";
	 public Vertex(){
		 
	}
	public Vertex(String name){
		vername=name;
	}
	public boolean equals(Object obj){
        
        if (obj instanceof Vertex) {
            Vertex pp = (Vertex) obj;
            return (pp.vername.equals(this.vername) );
        } else {
            return false;
        }
    }
	public int hashCode(){
		return vername.hashCode();
	}
	public String toString(){
		return vername;
	}
	}