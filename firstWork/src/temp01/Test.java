package temp01;

public class Test {
	public static void main(String[] args){
		Student stu = new Student("��");
		Study sdy = new Study();
		Address addr = new Address();
		addr.setName("տ��");
		stu.doSomething(sdy, addr);
	}

}
