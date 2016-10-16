public class TaxiService{
	private Graph roadmap = new Graph();
	private Myset<Taxi> taxilist = new Myset();
	private int ptime=0;
	public TaxiService() {
		
	}

	public void performAction(String actionstring) throws Exception {
		//System.out.println("action to be performed: " + actionMessage);
		//....
		System.out.println(actionstring+ " : ");
	String [] tokens =actionstring.split("\\s+");
	int i=0;
		 String methodname=tokens[0];
		 switch(methodname){
			 case "edge" :
			  i=Integer.parseInt(tokens[3]);
					edge(tokens[1],tokens[2],i);
					break;
			 case "taxi" :
					taxi(tokens[1],tokens[2]);
					break;
			 case "customer" :
			   i=Integer.parseInt(tokens[3]);
					customer(tokens[1],tokens[2],i);
					System.out.println("");
					break;
			 case "printTaxiPosition" :
			  i=Integer.parseInt(tokens[1]);
					printTaxiPosition(i);
					System.out.println("");
					break;
			 default:
			  throw new Exception("no such method exists");
					
		 }
		 
	}
	private void edge(String src , String dest, int weight){
		roadmap.addEdge(src,dest,weight);
		//roadmap.printGraph();
	}
	private void taxi(String name, String position){
		Vertex test=new Vertex(position);
		if(roadmap.isnVertex(test))
		{
			System.out.println("Error- Taxi can not be added since vertex does not exist");
			return;
		}
		Taxi temp=new Taxi(name,position);
		taxilist.Insert(temp);
	}
	private void customer(String src , String dest, int time){
		if(ptime>time){
			System.out.println("Request for the time "+time+" can not be processed.");
			return;
		}
		System.out.println("Available taxis:");
		Time(time);
		Vertex as = new Vertex(src);
			Vertex bs= new Vertex(dest);
						MyLinkedList<Vertex> temp1;
						if( roadmap.isnVertex(bs)|| roadmap.isnVertex(as)){
					System.out.println("No Taxi can be alloted to you.");
						return;					
						}
		int[] temp = new int[taxilist.Size()];
		for(int i=1;i<=taxilist.Size();i++){
			if(taxilist.getElementati(i).getTime()!=0){
				temp[i-1]=Integer.MAX_VALUE ;
				continue;
			}
			if(taxilist.getElementati(i).getCurrent().equals(as))
			{
				temp[i-1]=taxilist.getElementati(i).getTime();
				System.out.print("Path of "+taxilist.getElementati(i).name +": ");
				System.out.print(as+".");
				System.out.println("  time taken is "+temp[i-1]+" units");
				continue;
			}
			 temp1 = roadmap.minpath(taxilist.getElementati(i).getCurrent(),as);
			 
			System.out.print("Path of "+taxilist.getElementati(i).name +": ");
			if(temp1==null)
			{ System.out.println("No path exists for taxi");
			  temp[i-1]=Integer.MAX_VALUE ;
			  continue;}
			temp[i-1]=taxilist.getElementati(i).getTime()+roadmap.result(as);
			for(int j=1;j<=temp1.size;j++)
			{
				if(temp1.getElementati(j)==as)
					System.out.print(temp1.getElementati(j)+".");
				else
				System.out.print(temp1.getElementati(j)+", ");
			}
			System.out.println("  time taken is "+temp[i-1]+" units");
		}
		int min=Integer.MAX_VALUE;
		int mini=-1;
		for(int i=0;i<temp.length;i++){
			if(temp[i]<min){
				min=temp[i];
				mini=i;
			}
		}
		if(min==Integer.MAX_VALUE)
		{
			System.out.println("No Taxi can be alloted for customer");
			return;
		}
		System.out.println("** Chose " + taxilist.getElementati(mini+1).name +" to service the customer request ***");
		
		System.out.print("Path of customer: ");
		temp1 = roadmap.minpath(as,bs);
		if(temp1==null){
			System.out.println("Taxi can not go to that destination");
			return;
		}
		taxilist.getElementati(mini+1).setTime(min);
		for(int j=1;j<=temp1.size;j++)
			{
				
				if(temp1.getElementati(j)==bs)
					System.out.print(temp1.getElementati(j)+".");
				else
				System.out.print(temp1.getElementati(j)+", ");
			}
		System.out.println(" time taken is " + roadmap.result(bs)+" units");
		taxilist.getElementati(mini+1).setTime(taxilist.getElementati(mini+1).getTime()+roadmap.result(bs));
		taxilist.getElementati(mini+1).setCurrent(bs);
	}
	
	private void printTaxiPosition(int time){
		if(ptime>time){
			System.out.println("Request for the time "+time+" can not be processed.");
			return;
		}
		Time(time);
		for(int i=1;i<=taxilist.Size();i++)
			if(taxilist.getElementati(i).getTime()==0)
				System.out.println(taxilist.getElementati(i));
		
	}
	
	private void Time(int t){
		while(ptime!=t){
			ptime++;
			for(int i=1;i<=taxilist.Size();i++)
				taxilist.getElementati(i).TimeUpdate();
		}
	}
	
}
