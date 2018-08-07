package fr.afcepf.ai103.test;

public class ExplicationException {

	public static void main(String[] args) {
		try {
			mettreEntierDansString(-2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	 
	public static String mettreEntierDansString(int entier) throws Exception {
		if(entier < 0) {
			throw new Exception("Non tu peux pas");
		} else {
			return Integer.toString(entier);
		}
		
	}

}
