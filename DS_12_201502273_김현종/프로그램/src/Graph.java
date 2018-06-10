import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Graph {
    private int[][] edge;
    private int size;

    public Graph(int size) {
        this.size = size;
        this.edge = new int[size][size];
    }

    public int size(){
        return size;
    }

    public void addEdge(int src, int dst) {
      // TODO
    	this.edge[src][dst] = 1;
    }

    public void removeEdge(int src, int dst) {
      // TODO
    	this.edge[src][dst] = 0;
    }

    public void readGraph(File file) throws IOException {
        if (file == null) {
            String currentPath = Paths.get(".", "src").toString();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File(currentPath));
            jFileChooser.showOpenDialog(new JFrame());
            file = jFileChooser.getSelectedFile();
        }
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            this.size = Integer.parseInt(br.readLine());
            this.edge = new int[size][size];
            for (int i = 0; i < size; ++i) {
                String[] temps = br.readLine().split(" ");
                for (int j = 0; j < temps.length; ++j) {
                    edge[i][j] = Integer.parseInt(temps[j]);
                }
            }
            System.out.println("File selected!");
        } else {
            System.out.println("No file Selected");
        }
    }
    public void print() {
        System.out.println("This Graph ::\n");
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(edge[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bfs(int vertex) {
      // TODO
    	boolean[] isFounds = new boolean[this.size];
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(vertex);
    	while(!q.isEmpty()){
    		int curr = q.poll();
    		System.out.print(curr + " -> ");
			isFounds[curr] = true;
			
    		for(int i = 0; i < this.size; i++){
    			if(!isFounds[i] && this.edge[curr][i] != 0){
    				q.add(i);
    				isFounds[i] = true;
    			}
    		}
    	}
    }

    public void dfs(boolean[] isFounds, int vertex) {
      // TODO
    	isFounds[vertex] = true;
    	System.out.print(vertex + " -> ");
    	
    	for(int i = 0; i < this.size; i++){
    		if(!isFounds[i] && this.edge[vertex][i] != 0){
    			dfs(isFounds, i);
    		}
    	}
    }

    public void kruskalAlgorithm() {
      // TODO
    	PriorityQueue<Edge> pq = new PriorityQueue<Edge>(this.size, new Comparator<Edge>(){

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				if(o1.getWeight() > o2.getWeight()){
					return 1;
				}else{
					return -1;
				}
				
			}
    	});
    	
    	for(int i = 0; i < this.size; i++){
    		for(int j = i + 1; j < this.size; j++){
    			if(this.edge[i][j] != 0){
        			pq.add(new Edge(i, j, this.edge[i][j]));
    			}
    		}
    	}
    	int foundVertex = 1;
    	
    	
    	int[] union = new int[this.size];
    	for(int i = 0; i < union.length; i++){
    		union[i] = -1;
    	}
    	int totalCost = 0;
    	while(foundVertex != this.size && !pq.isEmpty()){
    		Edge curr = pq.poll();
    		if(!isInUnion(union, curr)){
    			union(union, curr);
    			foundVertex++;
    			totalCost += curr.getWeight();
    			System.out.println(curr.getSrc() + "\t->\t" + curr.getDst() + ":\t" + curr.getWeight());
    		}
    	}
    }

    public void primAlgorithm(int start){
      // TODO
    	boolean[] found = new boolean[this.size];
    	int[] cost = new int[this.size];
    }
    
    private boolean isInUnion(int[] union, Edge edge){
		int tempDst = edge.getDst();
    	int tempSrc = edge.getSrc();
    	
		while(union[tempSrc] >= 0){
			tempSrc = union[tempSrc];
   		}
		
		while(union[tempDst] >= 0){
			tempDst = union[tempDst];
   		}
		return tempSrc == tempDst;
    }
    
    private void union(int[] union, Edge edge){
    	int src = edge.getSrc();
    	int dst = edge.getDst();
    	
    	int tempSrc = src;
		while(union[tempSrc] >= 0){
			tempSrc = union[tempSrc];
   		}
		
		int tempDst = dst;
		while(union[tempDst] >= 0){
			tempDst = union[tempDst];
   		}
		
		if(union[tempDst] < union[tempSrc]){
			union[tempSrc] += union[tempDst];
			union[tempDst] = tempSrc;
		}else{
			union[tempDst] += union[tempSrc];
			union[tempSrc] = tempDst;
		}
    }
}
