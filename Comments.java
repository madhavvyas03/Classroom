package assign_2_ap_2020310;

import java.util.* ;
public class Comments implements com{

	static ArrayList<ArrayList<String>> comment_map = new ArrayList<ArrayList<String>>() ;
	@Override
	public void addcomment(String s) {
		ArrayList<String> milap = new ArrayList<String>() ;
		milap.add(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Comment :");
		String s1 = sc.nextLine();
		milap.add(s1);
		java.util.Date date=java.util.Calendar.getInstance().getTime(); 
		milap.add(String.valueOf(date));
	}

	@Override
	public void viewcomment() {
		for (int i = 0 ; i<comment_map.size();i++) {
			System.out.println(comment_map.get(i).get(1)+" - "+comment_map.get(i).get(0));
			System.out.println(comment_map.get(i).get(2));
		}
		
	}
	
}
