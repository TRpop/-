
import java.util.LinkedList;
import java.util.Queue;

public class MainClass_07_201502273 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j = -1;
		
		Tree<String> tree = new Tree<String>();	//트리 생성
		
		Queue<Tree<String>> q = new LinkedList<Tree<String>>();	//편리하게 Tree를 만들기위한 queue
		
		q.offer(tree);	//q에 root를 enQueue
		
		for(int i = 0; i < 10; i++){
			Tree<String> temp = q.poll();	//q에서 deQueue해옴
			temp.setElement("Node num " + i);	//deQueue해온 Tree의 값 지정
			temp.setLeftChild(new Tree<String>());	//왼쪽 자식 생성
			temp.setRightChild(new Tree<String>());	//오른쪽 자식 생성
			q.offer(temp.leftChild());	//왼쪽 자식 enQueue
			q.offer(temp.rightChild());	//오른쪽 자식 enQueue
			j = i;	//j를 i로 업데이트
		}
		
		while(!q.isEmpty()){	//q가 빌때까지
			j++;	//j를 하나씩 늘려가며
			Tree<String> temp = q.poll();	//q에서 deQueue해옴
			temp.setElement("Node num " + j);	//해당 트리의 값 지정
		}
		
		
		System.out.println("\nPreorder\n");
		tree.preorder(tree);	//preorder 출력
		System.out.println("\nInorder\n");
		tree.inorder(tree);	//inorder 출력
		System.out.println("\nPostorder\n");
		tree.postorder(tree);	//postorder 출력
		System.out.println("\nLevelorder\n");
		tree.levelorder(tree);	//levelorder 출력

	}

}
