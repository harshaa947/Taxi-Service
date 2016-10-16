public class Taxi {
	public String name="";
	private Vertex current ;
	private int Time=0;
	public Taxi(){
		
		current=new Vertex();
	}
	public Taxi(Vertex v){
		
		current=v;
	}
	public Taxi(String a,String v){
		name=a;
		current=new Vertex(v);
	}
	public void setTime(int t){
		Time=t;
	}
	public int getTime(){
		return Time;
	}
	public Vertex getCurrent(){
		return current;
		
	}
	public boolean isAvailable(){
		return Time==0 ;
	}
	public void setCurrent(Vertex v){
		current=v;
	}
	public void TimeUpdate(){
		if(Time!=0)
			Time--;
	}
	public String toString(){
		//return name +" " + Time +" " +current ;
		return name +": " +current ;
	}
}