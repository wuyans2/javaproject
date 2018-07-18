package temp01;

public class Student {
	private String name;
	public String getName()
	{
		return name;
	}
	public void SetName(String name){
		this.name =name;
	}
	public Student(String _name){
		name = _name;
	}
	public void doSomething(Study sdy,Address addr){
		System.out.print(this.name);
		sdy.study(addr);
	}

}
