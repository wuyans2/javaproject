package temp02;
public class Student extends Person{
	public Student (String _name,String _sex){
		super (_name ,_sex);
	}
	public void doSomething(Action ac, Address addr){
		System.out.print(this.name);
		ac.act(addr);
	}
	
}

