public class Edge {
    private int src;
    private int dst;
    private int weight;

    /*
     * Edge의 Constructor
     * src, dst, weight를 받아 초기화한다.
     */
    public Edge(int src, int dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    /*
     * src의 getter
     */
    public int getSrc() {
        return src;
    }

    /*
     * dst의 getter
     */
    public int getDst() {
        return dst;
    }

    /*
     * weight의 getter
     */
    public int getWeight() {
        return weight;
    }
}
