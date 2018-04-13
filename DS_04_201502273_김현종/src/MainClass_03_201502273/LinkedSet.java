package MainClass_03_201502273;

public class LinkedSet implements LinkedSetInterface {

	/*
	 * head와 size 선언
	 * head는 첫번째 노드를 가리키고있는 노드이다.
	 * size는 현제 Set의 크기를 알려주는 필드이다.
	 */
	private Node<String> head;
	private int size;

	/*
	 * LinkedSet의 생성자
	 * head를 Value가 없는 Node로 초기화 해주고 size를 0으로 초기화해준다.
	 */
	public LinkedSet() {
		this.head = new Node<String>();
		this.size = 0;
	}

	/*
	 * private 변수인 size를 반환해주는 Getter
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/*
	 * Set에 값을 더해주는 함수
	 * 먼저 현재 받은 값과 같은 값이 Set에 들어있는지 확인한다.
	 * 만약 들어있으면 함수를 실패로 종료한다.
	 * 들어있지 않으면 현제와 직전을 가리키는 노드 두 개를 사용해 Set을 끝까지 탐색한다.
	 * 그리고 맨 마지막에 있는 노드에 다음 노드로 받은 값이 들어있는 Node를 붙혀준다.
	 * 그리고 size의 값을 1 올리고 함수를 성공으로 종료한다.
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
	 * 현재 받은값이 Set 내부에 존재하는지 검사하는 메소드이다.
	 * 노드를 하나 만들어 Set의 처음부터 끝까지 탐색하며 입력값과 같은 값이 있으면 true를 반환하고 메소드를 끝낸다.
	 * 같은값이 없으면 false를 반환하며 메소드를 끝낸다.
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
	 * 현재 Set에 들어있는 값 중 입력값과 같은 값을 제거하는 메소드이다.
	 * 현재 노드를 가리키는 노드와 이전 노드를 가리키는 노드를 선언하여 Set을 탐색한다.
	 * 탐색중에 받은 값과 같은 값이 있으면 이전의 next를 현재의 next로 설정한다.
	 * 즉, 현재 노드를 빼고 리스트를 잇는다.
	 * 그리고 Set의 size를 1 줄이고 삭제한 값을 반환하며 메소드를 끝낸다.
	 * 존재하지 않는 경우에는 null을 반환한다.
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
	 * Set을 비우는 함수이다.
	 * head의 next를 null로 설정해 Set을 비운다.
	 * 그리고 Set의 size를 0으로 바꾼다.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head.setNext(null);
		this.size = 0;
	}

	/*
	 * 본 객체를 출력하는 메소드이다.
	 */
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}

	/*
	 * 본 객체가 출력됐을경우 호출되는 함수이다.
	 * 먼저 String 변수를 선언하고 '['로 초기화한다.
	 * 그리고 리스트를 처음부터 끝까지 탐색하며 각 노드의 Value를 String 변수에 잇는다.
	 * 그리고 탐색이 끝나면 ']'를 이어주고 해당 String변수를 반환한다.
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
