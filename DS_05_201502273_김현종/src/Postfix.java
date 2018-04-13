public class Postfix {
    private String infix;
    private StringBuilder postfix;

    /*
     * Postfix�� ������
     * infix�� �޾ƿ� ������ �ʱ�ȭ�ϰ�
     * postfix�� ���ο� StringBuilder ��ü�� ����� �ʱ�ȭ�ϰ�
     * infix�� postfix�� ����� ���� infixToPostfix�� ȣ���Ѵ�.
     */
    public Postfix(String string) {
        infix = string;
        postfix = new StringBuilder();
        infixToPostfix(0);
    }

    /*
     * infix�� �ۼ��� ������ postfix�� �ٲٴ� �޼ҵ�
     * �޾ƿ� �ε��������� �� ���ĸ� ó���Ѵ�.
     */
    private int infixToPostfix(int index) {
        StringBuilder num = new StringBuilder();	//���ڸ� �ӽ÷� ������ StringBuilder
        Stack operationStack = new Stack();	//�����ڸ� ������ Stack
        for (int i = index; i < infix.toCharArray().length; ++i) {//�޾ƿ� �ε������� infix ��Ʈ���� ������
            char ch = infix.charAt(i);	//i��° �ڸ��� �ִ� Char
            switch (ch) {
                case '(':	//i���� char�� (�� ���
                    i = infixToPostfix(i+1);//(���ĺ��� recursive�ϰ� �ٽ� ó���� ��
                    //�ش� ��ȣ�� ���� �ε����� �޾ƿ´�.
                    break;
                case ')'://i��° char�� )�� ���
                    makePostfix(num.toString());	//������� ���� num�� �� ���ڰ�(Operand)�� postfix�� �־��ش�.
                    while (!operationStack.isEmpty()) {//������ ������ ��������
                        makePostfix(operationStack.pop());//������ ���ÿ� ���� �����ڸ� pop�Ͽ� postfix�� �־��ش�.
                    }
                    return i;	//)�� ��Ÿ�� �ε����� ��ȯ�Ѵ�.
                case '*'://i��° Char�� *�� ���
                    //TODO
                	makePostfix(num.toString());//������� ���� num�� �� ���ڰ�(Operand)�� postfix�� �־��ش�.
                	num = new StringBuilder();//num�� ����ش�(�ٽ� �ʱ�ȭ)
                	if(!operationStack.isEmpty()){//������ ������ ���� �ʾ�����
                		if(operationStack.peek().equals("/") || operationStack.peek().equals("*")){//���� ������ ������ peek���� /, *�̸�
                			makePostfix(operationStack.pop());//������ ������ peek���� pop�Ͽ� postfix�� �־��ش�.
                		}
                	}
                	operationStack.push("*");//������ ���ÿ� *�� �־��ش�.
                	break;
                	
                case '/'://i��° Char�� /�� ���
                    //TODO
                	makePostfix(num.toString());//������� ���� num�� �� ���ڰ�(Operand)�� postfix�� �־��ش�.
                	num = new StringBuilder();//num�� ����ش�(�ٽ� �ʱ�ȭ)
                	if(!operationStack.isEmpty()){//������ ������ ���� �ʾ�����
                		if(operationStack.peek().equals("*") || operationStack.peek().equals("/")){//���� ������ ������ peek���� /, *�̸�
                			makePostfix(operationStack.pop());//������ ������ peek���� pop�Ͽ� postfix�� �־��ش�.
                		}
                	}
                	operationStack.push("/");//������ ���ÿ� /�� �־��ش�.
                    break;
              
                case '+'://i��° Char�� +�� ���
                    makePostfix(num.toString());//������� ���� num�� �� ���ڰ�(Operand)�� postfix�� �־��ش�.
                    num = new StringBuilder();//num�� ����ش�(�ٽ� �ʱ�ȭ)
                    while (!operationStack.isEmpty()) {//������ ������ ��������(�켱������ ���� ���⶧����)
                        makePostfix(operationStack.pop());//������ ������ pop�Ͽ� postfix�� �־��ش�.
                    }
                    operationStack.push("+");//������ ���ÿ� +�� �־��ش�.
                    break;
                case '-'://i��° Char�� -�� ���
                    makePostfix(num.toString());//������� ���� num�� �� ���ڰ�(Operand)�� postfix�� �־��ش�.
                    num = new StringBuilder();//num�� ����ش�(�ٽ� �ʱ�ȭ)
                    while (!operationStack.isEmpty()) {//������ ������ ��������(�켱������ ���� ���⶧����)
                        makePostfix(operationStack.pop());//������ ������ pop�Ͽ� postfix�� �־��ش�.
                    }
                    operationStack.push("-");//������ ���ÿ� -�� �־��ش�.
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9'://i��° Char�� ������ ���
                    num.append(ch);//num�� append�Ѵ�.(�̾� ������.)
                    break;
                case ' ':
                case '\t':
                case '\n'://i��° Char�� ' ', '\t', '\n'�� ���
                    break;//�ƹ��͵� ���� �ʰ� ������.
                default://i��° Char�� ������ �̿��� ���� ���
                    System.out.println("[ �ùٸ��� ���� �Է��Դϴ�. : " + ch + " ]");//������ ����Ѵ�.
                    break;
            }
        }//�ݺ����� ��� ������
        makePostfix(num.toString());//���� num�� ����ִ� ���ڸ� postfix�� ���� �־��ְ�
        while (!operationStack.isEmpty()) {//������ ������ ��������
            makePostfix(operationStack.pop());//������ ���ÿ��� pop�Ͽ� postfix�� �־��ش�.
        }
        return infix.toCharArray().length;//infix�� ����, �� ������ �ε���+1�� ��ȯ�Ѵ�.
    }

    private void makePostfix(String string) {
        if (!"".equals(string)) {//�Է°��� ""�� �ƴҰ��
            postfix.append(string).append(" ");//�Է°��� postfix�� append�ϰ� ��ĭ�� �ϳ� append�Ѵ�.
        }
    }

    /*
     * ���۵� postfix�� ������ ����ϴ� �޼ҵ�
     * 
     */
    public double calculate() {
        Stack valueStack = new Stack();	//valueStack�� ����
        StringBuilder num = new StringBuilder();//���ڰ� �� num�̶�� StringBuilder�� ������.

        double result;//������� �� ����
        for (int i = 0; i < postfix.toString().toCharArray().length; ++i) {//0���� postfix�� ������
            char ch = postfix.charAt(i);//i��° char
            switch (ch) {
                case '*': {//i��° char�� *�� ���
                    //TODO
                	String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack���� �ΰ��� ���� pop�Ͽ�
                    a = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));
                    //�ش� ���� ���ϰ� ������� �ٽ� valueStack�� push�Ѵ�.
                    valueStack.push(a);
                    break;
                }
                case '/': {//i��° char�� /�� ���
                    //TODO
                	String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack���� �ΰ��� ���� pop�Ͽ�
                    a = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));
                    //�ش� ���� ������ ������� �ٽ� valueStack�� push�Ѵ�.
                    valueStack.push(a);
                    break;
                }
                case '+': {//i��° char�� +�� ���
                    String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack���� �ΰ��� ���� pop�Ͽ�
                    a = Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
                    //�ش� ���� ���ϰ� ������� �ٽ� valueStack�� push�Ѵ�.
                    valueStack.push(a);
                    break;
                }
                case '-': {//i��° char�� +�� ���
                    String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack���� �ΰ��� ���� pop�Ͽ�
                    a = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
                    //�ش� ���� ���� ������� �ٽ� valueStack�� push�Ѵ�.
                    valueStack.push(a);
                    break;
                }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.'://i��° ���� ������ ��� num�� append���ش�.
                    num.append(ch);
                    break;
                case ' '://i��° ���� ' '�� ���
                    if (!num.toString().equals("")) {//num�� ""�� �ƴҰ�� 
                        valueStack.push(num.toString());//num�� �ִ� ���ڰ��� valueStack�� push���ش�.
                        num = new StringBuilder();//num�� ����.(�ʱ�ȭ �Ѵ�.)
                    }
                    break;
                default://���� �� �̿��� ���� i��° ���̸� �ƹ��͵� ���� �ʴ´�.
                    break;
            }
        }

        result = Double.valueOf(valueStack.pop());//valueStack�� ������ ���� �����
        return result;//������� ��ȯ�Ѵ�.
    }

    /*
     * infix�� getter
     */
    public String getInfix() {
        return infix;
    }

    /*
     * postfix�� getter
     */
    public String getPostfix() {
        return postfix.toString();
    }

}
