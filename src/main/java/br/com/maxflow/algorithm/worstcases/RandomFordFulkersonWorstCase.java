package br.com.maxflow.algorithm.worstcases;

import br.com.maxflow.algorithm.RandomFordFulkerson;
import br.com.maxflow.graph.Edge;

public class RandomFordFulkersonWorstCase extends RandomFordFulkerson {

	public RandomFordFulkersonWorstCase(int n) {
		super(n);
	}
	
	protected void worstPath(int count, int source, int sink) {
		if(count % 2 == 0) {
			graph.setParent(sink, graph.getNode(2).getEdge(0));
			graph.setParent(2, graph.getNode(1).getEdge(1));
			
		} else {
			graph.setParent(1, graph.getNode(2).getEdge(3));
		}	
	}
	
	public void createEdges(int m, int source, int sink) {
		int cap = 1000;
		
	    addEdge(source, 1, cap);
    	addEdge(source, 2, cap);
	    addEdge(1, 2, 1);    
	    addEdge(2, sink, cap);

    	int v = 1; 	
    	int w = 4;
	    if(m > 5) { 
   	    	for(int i=0; i < (m-5); i++) {
	    		addEdge(v, w, cap);	 
	    		v = w;
	    		w++;
	        }    	
	    }
	    
    	addEdge(v, sink, cap);
	}
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		int count = 0;
		
		while(true)
		{
			graph.resetParent();
			
			if (!hasPath(source,sink)) 
	            break;
			
			worstPath(count, source, sink);
				
	    	int df = Integer.MAX_VALUE;
	    	
	    	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
	   		    df = Math.min(df, edge.getCapacity() - edge.getFlow());
	   	
	       	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
	       		edge.pushFlow(df);	 
	     
	    	maxFlow += df;
	    	System.out.println(maxFlow);
	    	count++;
		}
		
		return maxFlow;
	}


}