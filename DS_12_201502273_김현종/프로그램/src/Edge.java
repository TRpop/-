public class Edge {
    private int src;
    private int dst;
    private int weight;

    /*
     * Edge�� Constructor
     * src, dst, weight�� �޾� �ʱ�ȭ�Ѵ�.
     */
    public Edge(int src, int dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    /*
     * src�� getter
     */
    public int getSrc() {
        return src;
    }

    /*
     * dst�� getter
     */
    public int getDst() {
        return dst;
    }

    /*
     * weight�� getter
     */
    public int getWeight() {
        return weight;
    }
}
