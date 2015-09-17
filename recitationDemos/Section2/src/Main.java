
public class Main {

	public static void main(String[] args) {
		String time = args[0];
		int i = time.indexOf(":");
		String hours = time.substring(0,  i);
		String minutes = time.substring(i+1);
		System.out.println(hours);
		System.out.println(minutes);
	}

}
