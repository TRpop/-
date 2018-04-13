public class Postfix {
    private String infix;
    private StringBuilder postfix;

    /*
     * Postfix의 생성자
     * infix를 받아온 값으로 초기화하고
     * postfix는 새로운 StringBuilder 객체를 만들어 초기화하고
     * infix를 postfix로 만들기 위해 infixToPostfix를 호출한다.
     */
    public Postfix(String string) {
        infix = string;
        postfix = new StringBuilder();
        infixToPostfix(0);
    }

    /*
     * infix로 작성된 수식을 postfix로 바꾸는 메소드
     * 받아온 인덱스값부터 그 이후를 처리한다.
     */
    private int infixToPostfix(int index) {
        StringBuilder num = new StringBuilder();	//숫자를 임시로 저장할 StringBuilder
        Stack operationStack = new Stack();	//연산자를 저장할 Stack
        for (int i = index; i < infix.toCharArray().length; ++i) {//받아온 인덱스부터 infix 스트링의 끝까지
            char ch = infix.charAt(i);	//i번째 자리에 있는 Char
            switch (ch) {
                case '(':	//i번쨰 char가 (일 경우
                    i = infixToPostfix(i+1);//(이후부터 recursive하게 다시 처리한 뒤
                    //해당 괄호가 끝난 인덱스를 받아온다.
                    break;
                case ')'://i번째 char가 )일 경우
                    makePostfix(num.toString());	//현재까지 받은 num에 든 숫자값(Operand)을 postfix에 넣어준다.
                    while (!operationStack.isEmpty()) {//연산자 스택이 빌때까지
                        makePostfix(operationStack.pop());//연산자 스택에 남은 연산자를 pop하여 postfix에 넣어준다.
                    }
                    return i;	//)가 나타난 인덱스를 반환한다.
                case '*'://i번째 Char가 *일 경우
                    //TODO
                	makePostfix(num.toString());//현재까지 받은 num에 든 숫자값(Operand)을 postfix에 넣어준다.
                	num = new StringBuilder();//num을 비워준다(다시 초기화)
                	if(!operationStack.isEmpty()){//연산자 스택이 비지 않았으면
                		if(operationStack.peek().equals("/") || operationStack.peek().equals("*")){//현재 연산자 스택의 peek값이 /, *이면
                			makePostfix(operationStack.pop());//연산자 스택의 peek값을 pop하여 postfix에 넣어준다.
                		}
                	}
                	operationStack.push("*");//연산자 스택에 *을 넣어준다.
                	break;
                	
                case '/'://i번째 Char가 /일 경우
                    //TODO
                	makePostfix(num.toString());//현재까지 받은 num에 든 숫자값(Operand)을 postfix에 넣어준다.
                	num = new StringBuilder();//num을 비워준다(다시 초기화)
                	if(!operationStack.isEmpty()){//연산자 스택이 비지 않았으면
                		if(operationStack.peek().equals("*") || operationStack.peek().equals("/")){//현재 연산자 스택의 peek값이 /, *이면
                			makePostfix(operationStack.pop());//연산자 스택의 peek값을 pop하여 postfix에 넣어준다.
                		}
                	}
                	operationStack.push("/");//연산자 스택에 /을 넣어준다.
                    break;
              
                case '+'://i번째 Char가 +일 경우
                    makePostfix(num.toString());//현재까지 받은 num에 든 숫자값(Operand)을 postfix에 넣어준다.
                    num = new StringBuilder();//num을 비워준다(다시 초기화)
                    while (!operationStack.isEmpty()) {//연산자 스택이 빌때까지(우선순위가 가장 낮기때문에)
                        makePostfix(operationStack.pop());//연산자 스택을 pop하여 postfix에 넣어준다.
                    }
                    operationStack.push("+");//연산자 스택에 +을 넣어준다.
                    break;
                case '-'://i번째 Char가 -일 경우
                    makePostfix(num.toString());//현재까지 받은 num에 든 숫자값(Operand)을 postfix에 넣어준다.
                    num = new StringBuilder();//num을 비워준다(다시 초기화)
                    while (!operationStack.isEmpty()) {//연산자 스택이 빌때까지(우선순위가 가장 낮기때문에)
                        makePostfix(operationStack.pop());//연산자 스택을 pop하여 postfix에 넣어준다.
                    }
                    operationStack.push("-");//연산자 스택에 -을 넣어준다.
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
                case '9'://i번째 Char가 숫자일 경우
                    num.append(ch);//num에 append한다.(이어 붙힌다.)
                    break;
                case ' ':
                case '\t':
                case '\n'://i번째 Char가 ' ', '\t', '\n'일 경우
                    break;//아무것도 하지 않고 끝낸다.
                default://i번째 Char가 위에것 이외의 것일 경우
                    System.out.println("[ 올바르지 않은 입력입니다. : " + ch + " ]");//에러를 출력한다.
                    break;
            }
        }//반복문이 모두 끝나고
        makePostfix(num.toString());//현재 num에 들어있는 숫자를 postfix에 먼저 넣어주고
        while (!operationStack.isEmpty()) {//연산자 스택이 빌때까지
            makePostfix(operationStack.pop());//연산자 스택에서 pop하여 postfix에 넣어준다.
        }
        return infix.toCharArray().length;//infix의 길이, 즉 마지막 인덱스+1을 반환한다.
    }

    private void makePostfix(String string) {
        if (!"".equals(string)) {//입력값이 ""이 아닐경우
            postfix.append(string).append(" ");//입력값을 postfix에 append하고 빈칸도 하나 append한다.
        }
    }

    /*
     * 제작된 postfix를 실제로 계산하는 메소드
     * 
     */
    public double calculate() {
        Stack valueStack = new Stack();	//valueStack을 만듬
        StringBuilder num = new StringBuilder();//숫자가 들어갈 num이라는 StringBuilder를 생성함.

        double result;//결과값이 들어갈 변수
        for (int i = 0; i < postfix.toString().toCharArray().length; ++i) {//0부터 postfix의 끝까지
            char ch = postfix.charAt(i);//i번째 char
            switch (ch) {
                case '*': {//i번째 char가 *인 경우
                    //TODO
                	String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack에서 두개의 값을 pop하여
                    a = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));
                    //해당 값을 곱하고 결과값을 다시 valueStack에 push한다.
                    valueStack.push(a);
                    break;
                }
                case '/': {//i번째 char가 /인 경우
                    //TODO
                	String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack에서 두개의 값을 pop하여
                    a = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));
                    //해당 값을 나누고 결과값을 다시 valueStack에 push한다.
                    valueStack.push(a);
                    break;
                }
                case '+': {//i번째 char가 +인 경우
                    String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack에서 두개의 값을 pop하여
                    a = Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
                    //해당 값을 더하고 결과값을 다시 valueStack에 push한다.
                    valueStack.push(a);
                    break;
                }
                case '-': {//i번째 char가 +인 경우
                    String b = valueStack.pop();
                    String a = valueStack.pop();//valueStack에서 두개의 값을 pop하여
                    a = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
                    //해당 값을 빼고 결과값을 다시 valueStack에 push한다.
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
                case '.'://i번째 값이 숫자인 경우 num에 append해준다.
                    num.append(ch);
                    break;
                case ' '://i번째 값이 ' '인 경우
                    if (!num.toString().equals("")) {//num이 ""가 아닐경우 
                        valueStack.push(num.toString());//num에 있는 숫자값을 valueStack에 push해준다.
                        num = new StringBuilder();//num을 비운다.(초기화 한다.)
                    }
                    break;
                default://위의 값 이외의 값이 i번째 값이면 아무것도 하지 않는다.
                    break;
            }
        }

        result = Double.valueOf(valueStack.pop());//valueStack의 마지막 값을 출력함
        return result;//결과값을 반환한다.
    }

    /*
     * infix의 getter
     */
    public String getInfix() {
        return infix;
    }

    /*
     * postfix의 getter
     */
    public String getPostfix() {
        return postfix.toString();
    }

}
