package finalexam;
import algs4.*;
import java.util.Random;
/* 
* <Tsvety Sotonov>
*<ExpectedDiCycle>
*/
public class ExpectedDiCycle 
{
	public static boolean neighbors(Digraph G, int v, int w) {
		for (int u: G.adj(v)) {
			if (u == w) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Vertices \tAverage # of"			
				+ "\nin graph	edges to cycle" );
		
		final int graphCount = 4096;
		for (int vertexCount = 32; vertexCount <= 4096; vertexCount *= 2) {
			Random r = new Random();
			int edgeCount = 0;
			for (int i = 0; i < graphCount; i++) {
				Digraph G = new Digraph(vertexCount);
				while (true) {
					DirectedCycle cycle = new DirectedCycle(G);
					if (cycle.hasCycle()) {
						break;
					}
					
					int v, w;
					do {
						v = r.nextInt(vertexCount);
						w = r.nextInt(vertexCount);
					} while (neighbors(G, v, w));
					G.addEdge(v, w);
					edgeCount++;
				}
			}
			double average = 1.0*edgeCount/graphCount;
			StdOut.println(vertexCount + "\t\t" + average);
		}
	}
}





