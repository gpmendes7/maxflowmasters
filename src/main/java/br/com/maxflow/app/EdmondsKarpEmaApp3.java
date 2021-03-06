package br.com.maxflow.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		int k = Integer.parseInt(sc.next());
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(k-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(k, k, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
		System.out.println("number of steps: " + edmondsKarpEma.steps());
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(edmondsKarpEma.steps() + "\n");
		fw.close();
		
		sc.close();
	}

}
