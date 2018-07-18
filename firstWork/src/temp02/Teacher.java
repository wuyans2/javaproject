package temp02;

public class Teacher extends Person{
	public Teacher (String _name,String _sex){
		super (_name ,_sex);
	}
	public void doSomething (Action ac,Address addr){
		System.out.print(this.name );
		ac.act(addr);
	}

}
