
public class MyStaticFinalAbstractProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           English english=new English();
           english.use();
           english.spoke();
           english.mouth();
	}

}
interface Language{
	void use();
}
abstract class ProgrammingLanguage implements Language{
	abstract void write();
}
abstract class ProceduralProgramming extends ProgrammingLanguage{
	abstract void procedure();
}
class Cpp extends ProceduralProgramming{
	public void use() {
		System.out.println("Using  CPP Language");
	}
	void write() {
		System.out.println("Writing CPP Language");
	}
	void procedure() {
		System.out.println("CPP Language uses procedural Approach");
	}
}
abstract class ObjectOrientedProgramming extends ProgrammingLanguage{
	abstract void oops();
}
class Java extends ObjectOrientedProgramming{
    public void use() {
    	System.out.println("Using  Java Language");
	}
	void write() {
		System.out.println("Writing  Java Language");
	}
	void oops() {
		System.out.println("Java Language uses OOPs approach");
	}
}
abstract class SpokenLanguage implements Language{
	abstract void spoke();
}
abstract class OralLanguage extends SpokenLanguage{
	abstract void mouth();
}
class English extends OralLanguage{
    public void use() {
    	System.out.println("Using English Language");
	}
	void spoke() {
		System.out.println("Speaking English Language");
	}
	void mouth() {
		System.out.println("Englsh Language uses Mouth");
	}
}
abstract class SignLanguage extends SpokenLanguage{
	abstract void gesture();
}
class ISL extends SignLanguage{
    public void use() {
    	System.out.println("Using ISL Language");
	}
	void spoke() {
		System.out.println("Speaking ISL Language");
	}
	void gesture() {
		System.out.println("ISL Language uses Gesture");
	}
}



