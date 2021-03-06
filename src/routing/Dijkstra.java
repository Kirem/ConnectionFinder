package routing;

import java.util.ArrayList;

public class Dijkstra {
	private ArrayList<Integer> pending;
    private ArrayList<Integer> precursor;
    private ArrayList<Double> path;
    private ArrayList<Integer> result;
    private Graph graph;
    private int justAdded, goal;


    public Dijkstra(Graph g){
        setGraph(g);
        precursor = new ArrayList<>();
        path = new ArrayList<>();
        pending = new ArrayList<>();
        result = new ArrayList<>();
    }

    public ArrayList<Integer> findShortestPath(int start, int end){
        clearIfExist();
        setLists();
        setTarget(start, end);
        while(!pending.isEmpty()){
            for(int neighbour: graph.getVertexes().get(justAdded).getNeighbours()){
                if(pending.contains(neighbour)) {
                   double newPath = path.get(justAdded) + graph.getEdgeDistance(justAdded, neighbour);
                   if(path.get(neighbour)> newPath){
                       setShorterPath(neighbour, newPath);
                   }
                }
            }
            addNextVertex();
        }
        createSolution();
        return result;
    }

    public void setGraph(Graph g){
        graph = g;
    }

    private void clearIfExist(){
        pending.clear();
        path.clear();
        precursor.clear();
        result.clear();
    }

    private void setLists(){
        for(int i=0 ; i < graph.getNumberOfVertexes() ; i++){
            precursor.add(-1);
            pending.add(i);
            path.add(Double.MAX_VALUE);
        }
    }

    private void setTarget(int start, int end){
        pending.remove(pending.indexOf(start));
        path.set(start, 0.0);
        justAdded=start;
        goal = end;
    }

    private void setShorterPath(int neighbour, double newPath){
        path.set(neighbour, newPath);
        precursor.set(neighbour, justAdded);
    }

    private void addNextVertex(){
        int smallest = findSmallestValue();
        pending.remove(pending.indexOf(smallest));
        justAdded = smallest;
    }

    private int findSmallestValue(){
        double smallestValue = Double.MAX_VALUE;
        int index = -1;
        for(int next: pending) {
            if (path.get(next) < smallestValue) {
                smallestValue = path.get(next);
                index = next;
            }
        }
        return index;
    }

    private void createSolution(){
        int previous = goal;
        while(precursor.get(previous) != -1){
            result.add(precursor.get(previous));
            previous = precursor.get(previous);
        }
    }
}
