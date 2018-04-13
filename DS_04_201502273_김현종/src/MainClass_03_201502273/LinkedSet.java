package MainClass_03_201502273;

public class LinkedSet implements LinkedSetInterface {

	/*
	 * head�� size ����
	 * head�� ù��° ��带 ����Ű���ִ� ����̴�.
	 * size�� ���� Set�� ũ�⸦ �˷��ִ� �ʵ��̴�.
	 */
	private Node<String> head;
	private int size;

	/*
	 * LinkedSet�� ������
	 * head�� Value�� ���� Node�� �ʱ�ȭ ���ְ� size�� 0���� �ʱ�ȭ���ش�.
	 */
	public LinkedSet() {
		this.head = new Node<String>();
		this.size = 0;
	}

	/*
	 * private ������ size�� ��ȯ���ִ� Getter
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/*
	 * Set�� ���� �����ִ� �Լ�
	 * ���� ���� ���� ���� ���� ���� Set�� ����ִ��� Ȯ���Ѵ�.
	 * ���� ��������� �Լ��� ���з� �����Ѵ�.
	 * ������� ������ ������ ������ ����Ű�� ��� �� ���� ����� Set�� ������ Ž���Ѵ�.
	 * �׸��� �� �������� �ִ� ��忡 ���� ���� ���� ���� ����ִ� Node�� �����ش�.
	 * �׸��� size�� ���� 1 �ø��� �Լ��� �������� �����Ѵ�.
	 */
	@Override
	public boolean add(String string) {
		// TODO Auto-generated method stub
		if(this.contains(string)){
			return false;
		}else{
			Node<String> pre = this.head;
			Node<String> cur = this.head.getNext();
			while(cur != null){
				pre = cur;
				cur = cur.getNext();
			}
			pre.setNext(new Node<String>(string));
			this.size++;
			return true;
		}
	}

	/*
	 * ���� �������� Set ���ο� �����ϴ��� �˻��ϴ� �޼ҵ��̴�.
	 * ��带 �ϳ� ����� Set�� ó������ ������ Ž���ϸ� �Է°��� ���� ���� ������ true�� ��ȯ�ϰ� �޼ҵ带 ������.
	 * �������� ������ false�� ��ȯ�ϸ� �޼ҵ带 ������.
	 */
	@Override
	public boolean contains(String string) {
		// TODO Auto-generated method stub
		Node<String> cur = this.head.getNext();
		while (cur != null) {

			if (cur.getValue().equals(string)) {
				return true;
			}

			cur = cur.getNext();
		}
		return false;
	}

	/*
	 * ���� Set�� ����ִ� �� �� �Է°��� ���� ���� �����ϴ� �޼ҵ��̴�.
	 * ���� ��带 ����Ű�� ���� ���� ��带 ����Ű�� ��带 �����Ͽ� Set�� Ž���Ѵ�.
	 * Ž���߿� ���� ���� ���� ���� ������ ������ next�� ������ next�� �����Ѵ�.
	 * ��, ���� ��带 ���� ����Ʈ�� �մ´�.
	 * �׸��� Set�� size�� 1 ���̰� ������ ���� ��ȯ�ϸ� �޼ҵ带 ������.
	 * �������� �ʴ� ��쿡�� null�� ��ȯ�Ѵ�.
	 */
	@Override
	public String remove(String string) {
		// TODO Auto-generated method stub
		Node<String> pre = this.head;
		Node<String> cur = this.head.getNext();

		while (cur != null) {

			if (cur.getValue().equals(string)) {
				pre.setNext(cur.getNext());

				this.size--;
				return string;
			}

			pre = cur;
			cur = cur.getNext();
		}

		return null;
	}

	/*
	 * Set�� ���� �Լ��̴�.
	 * head�� next�� null�� ������ Set�� ����.
	 * �׸��� Set�� size�� 0���� �ٲ۴�.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head.setNext(null);
		this.size = 0;
	}

	/*
	 * �� ��ü�� ����ϴ� �޼ҵ��̴�.
	 */
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}

	/*
	 * �� ��ü�� ��µ������ ȣ��Ǵ� �Լ��̴�.
	 * ���� String ������ �����ϰ� '['�� �ʱ�ȭ�Ѵ�.
	 * �׸��� ����Ʈ�� ó������ ������ Ž���ϸ� �� ����� Value�� String ������ �մ´�.
	 * �׸��� Ž���� ������ ']'�� �̾��ְ� �ش� String������ ��ȯ�Ѵ�.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "[ ";
		Node<String> temp = this.head.getNext();
		while(temp != null){
			string += temp.getValue() + " ";
			temp = temp.getNext();
		}
		string += "]";
		return string;
	}
	
	

}
