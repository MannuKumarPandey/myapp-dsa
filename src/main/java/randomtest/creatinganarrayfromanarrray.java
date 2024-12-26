package randomtest;

public class creatinganarrayfromanarrray {

	public static void main(String[] args) {
	
		System.out.println(makeFancyString("leeetcode"));

	}

	public static String makeFancyString(String s) {
		StringBuilder sb = new StringBuilder(s);

		int len = s.length();

		int i = 0;
		while (i < len) {
			int temp = i;
			int localFreq = 0;

			while (temp < len - 1) {
				if (sb.charAt(temp) == sb.charAt(temp + 1)) {
					localFreq++;
					temp++;
				}
				if (localFreq == 3) {
					sb.deleteCharAt(temp);
					localFreq--;
				}
				
			}
			i++;
		}

		return sb.toString();
	}

}
