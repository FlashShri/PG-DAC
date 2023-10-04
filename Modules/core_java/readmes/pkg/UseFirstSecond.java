import firstpkg.*;
import firstpkg.subpkg.Second;

public class UseFirstSecond{
	public static void main(String[] args) {
		First f = new First();
		f.myFun();

		Second s = new Second();
		s.myFun();

		Third t = new Third();
		t.myFun();
	}
}