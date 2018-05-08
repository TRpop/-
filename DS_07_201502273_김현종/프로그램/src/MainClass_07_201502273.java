
import java.util.LinkedList;
import java.util.Queue;

public class MainClass_07_201502273 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j = -1;
		
		Tree<String> tree = new Tree<String>();	//Ʈ�� ����
		
		Queue<Tree<String>> q = new LinkedList<Tree<String>>();	//���ϰ� Tree�� ��������� queue
		
		q.offer(tree);	//q�� root�� enQueue
		
		for(int i = 0; i < 10; i++){
			Tree<String> temp = q.poll();	//q���� deQueue�ؿ�
			temp.setElement("Node num " + i);	//deQueue�ؿ� Tree�� �� ����
			temp.setLeftChild(new Tree<String>());	//���� �ڽ� ����
			temp.setRightChild(new Tree<String>());	//������ �ڽ� ����
			q.offer(temp.leftChild());	//���� �ڽ� enQueue
			q.offer(temp.rightChild());	//������ �ڽ� enQueue
			j = i;	//j�� i�� ������Ʈ
		}
		
		while(!q.isEmpty()){	//q�� ��������
			j++;	//j�� �ϳ��� �÷�����
			Tree<String> temp = q.poll();	//q���� deQueue�ؿ�
			temp.setElement("Node num " + j);	//�ش� Ʈ���� �� ����
		}
		
		
		System.out.println("\nPreorder\n");
		tree.preorder(tree);	//preorder ���
		System.out.println("\nInorder\n");
		tree.inorder(tree);	//inorder ���
		System.out.println("\nPostorder\n");
		tree.postorder(tree);	//postorder ���
		System.out.println("\nLevelorder\n");
		tree.levelorder(tree);	//levelorder ���

	}

}
