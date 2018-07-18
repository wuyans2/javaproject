package temp02;

public class Test {
	public static void main(String[] args){
		Student stu = new Student ("张同学","男");
		Teacher tea = new Teacher ("王老师","女");
		Study sdy = new Study();
		Teach tch = new Teach();
		Address addr1 = new Address();
		Address addr2 = new Address();
		addr1.setName("湛江");
		addr2.setName("南海");
		stu.doSomething(sdy, addr1);
		System.out.println();
		tea.doSomething(tch, addr2);
	}

}
