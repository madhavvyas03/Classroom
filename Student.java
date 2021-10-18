package assign_2_ap_2020310;
import java.util.* ;
import java.util.Map.Entry;
public class Student implements change{
	static int a ;
	Map<Integer, ArrayList<String>> submissions = new HashMap<Integer,ArrayList<String>>() ;
	static Map<Integer, Map<String, Integer>> assessments = new HashMap<Integer, Map<String, Integer>>();
	static Map<Integer, Map<String, String>> opmapping = new HashMap<Integer, Map<String, String>>();
	@Override
	public void printinst() {
		System.out.println("1. View lecture materials\r\n"
				+ "2. View assessments\r\n"
				+ "3. Submit assessment\r\n"
				+ "4. View grades\r\n"
				+ "5. View comments\r\n"
				+ "6. Add comments\r\n"
				+ "7. Logout");
	}

	@Override
	public String enterid() {
		System.out.println("Students:\r\n"
				+ "0 - S0\r\n"
				+ "1 - S1\r\n"
				+ "2 - S2");
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose id:");
		a = sc.nextInt();
		if (a==0) {
			System.out.println("Welcome I1");
			
			return "S0" ;
		}
		else if(a==1) {
			System.out.println("Welcome I1");
			
			return "S1";
		}
		else if(a==2) {
			System.out.println("Welcome I1");
			
			return "S2";
		}
		
		return "wrong";
	}

	@Override
	public void viewlecturemat() {
		// TODO Auto-generated method stub
		Instructor i = new Instructor();
		i.viewlecturemat();
		
	}

	@Override
	public void viewassessments() {
		// TODO Auto-generated method stub
		Instructor i = new Instructor();
		i.viewassessments();
		
	}
	public static void main() {
		Student s = new Student();
		Comments c = new Comments();
		String g = s.enterid();
		Scanner sc = new Scanner(System.in);
		default_ass();
		System.out.println(s.assessments);
		if (g=="wrong") {
			System.out.println("Enter valid Id ");
			s.enterid();
		}
		for (int x = 0 ; x<Integer.MAX_VALUE ; x++){
			s.printinst();
			int f = sc.nextInt();
			if (f==1) {
				s.viewlecturemat();
			}
			else if (f==2) {
				Instructor i = new Instructor();
				i.viewassessments();
			}
			else if (f==3) {
				System.out.println("Pending Assignments");
				int count=0;
				if (g=="S0") {
					for (Entry<String, Integer> set : s.assessments.get(0).entrySet()) {
						if (set.getValue()==null) {
							System.out.println("ID: "+count+" Question: "+set.getKey());
						}
						else {
							System.out.println("ID: "+count+" Assignment: "+set.getKey()+"Max Marks: "+set.getValue());
						}
						count++;
					}
				}
				else if (g=="S1") {
					for (Entry<String, Integer> set : s.assessments.get(1).entrySet()) {
						if (set.getValue()!=null) {
							System.out.println("ID: "+count+"Question: "+set.getKey());
						}
						else {
							System.out.println("ID: "+count+"Assignment: "+set.getKey()+"Max Marks: "+set.getValue());
						}
						count++;
					}
				}
				else if (g=="S2") {
					for (Entry<String, Integer> set : s.assessments.get(2).entrySet()) {
						if (set.getValue()!=null) {
							System.out.println("ID: "+count+"Question: "+set.getKey());
						}
						else {
							System.out.println("ID: "+count+"Assignment: "+set.getKey()+"Max Marks: "+set.getValue());
						}
						count++;
					}	
				}
				
				methodpending(g);
				System.out.println(Student.opmapping);
			}
			else if (f==4) {
				if (g=="S0") {
					System.out.println("Graded submissions : ");
					for(String mapping : s.opmapping.get(0).keySet()) {
						if (Instructor.grade_0.containsKey(mapping)) {
							System.out.println("Submission: "+s.opmapping.get(0).get(mapping));
							System.out.println("Marks Scored: "+Instructor.grade_0.get(mapping));
							System.out.println("Graded by: "+Instructor.grade_by0.get(mapping));
						}
					}
					System.out.println(" :: Ungraded Submissions :: ");
					System.out.println("here for 0");
					for(String mapping : Student.opmapping.get(0).keySet()) {
						System.out.println("here for");
						if(s.submissions.get(0).contains(mapping)==false){
							if (Instructor.grade_0.containsKey(mapping)) {
							}
							else {
								if(Instructor.quizquestions.contains(mapping)) {
								}
								else {
									System.out.println("Submission :"+s.opmapping.get(0).get(mapping));
								}
							}
							
						}
						
					}
				}
				else if (g=="S1") {
					System.out.println(" :: Graded submissions :: ");
					for(String mapping : s.opmapping.get(1).keySet()) {
						if (Instructor.grade_1.containsKey(mapping)) {
							System.out.println("Submission: "+s.opmapping.get(1).get(mapping));
							System.out.println("Marks Scored: "+Instructor.grade_1.get(mapping));
							System.out.println("Graded by: "+Instructor.grade_by1.get(mapping));
						}
					}
					System.out.println(" :: Ungraded Submissions :: ");
					for(String mapping : s.opmapping.get(1).keySet()) {
						if(s.submissions.get(1).contains(mapping)==false){
							if (Instructor.grade_1.containsKey(mapping)) {
							}
							else {
								if(Instructor.quizquestions.contains(mapping)) {
								}
								else {
									System.out.println("Submission :"+s.opmapping.get(1).get(mapping));
								}
							}	
						}
					}
				}
				else if (g=="S2") {
					System.out.println(" :: Graded submissions :: ");
					for(String mapping : s.opmapping.get(2).keySet()) {
						if (Instructor.grade_2.containsKey(mapping)) {
							System.out.println("Submission: "+s.opmapping.get(2).get(mapping));
							System.out.println("Marks Scored: "+Instructor.grade_2.get(mapping));
							System.out.println("Graded by: "+Instructor.grade_by2.get(mapping));
						}
					}
					System.out.println(" :: Ungraded Submissions :: ");
					for(String mapping : s.opmapping.get(2).keySet()) {
						if(s.submissions.get(2).contains(mapping)==false){
							if (Instructor.grade_2.containsKey(mapping)) {
							}
							else {
								if(Instructor.quizquestions.contains(mapping)) {
								}
								else {
									System.out.println("Submission :"+s.opmapping.get(2).get(mapping));
								}
							}	
						}	
					}
				}
			}
			else if (f==5) {
				c.viewcomment();
			}
			else if (f==6) {
				c.addcomment(g);
			}
			else if (f==7) {
				
				return ; 
			}
		
		}
		
	}

	private static void methodpending(String g) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID of Assessment :");
		int x = Integer.parseInt(sc.nextLine());
		Student s = new Student();
		int count=0;
		if (g.matches("S0")) {
			ArrayList<String> up = new ArrayList<String>();
			if (s.submissions.containsKey(0)){
				up = s.submissions.get(0);
			}
			for (Entry<String, Integer> set : s.assessments.get(0).entrySet()) {
				if (count==x) {
					if (set.getValue()!=null) {
						System.out.print("Enter filename of assignment: ");
						String input = sc.nextLine();
						if (input.contains(".zip")) {
							Map<String,String> temp = new HashMap<String,String>() ;
							if (s.opmapping.containsKey(0)) {
								temp=s.opmapping.get(0);
								temp.put(set.getKey(), input);
								
							}
							else {
								temp.put(set.getKey(), input);
							}
							s.opmapping.put(0, temp);
							up.add(set.getKey());
							s.submissions.put(1,up);
							return;
							
						}
						else {
							System.out.println("Wrong type of file ");
							
							return;
						}
						
					}
					else {
						System.out.print(set.getKey());
						String as = sc.nextLine();
						Map<String,String> temp = new HashMap<String,String>() ;
						if (s.opmapping.containsKey(0)) {
							temp=s.opmapping.get(0);
							temp.put(set.getKey(), as);
							s.opmapping.put(0, temp);
						}
						else {
							temp.put(set.getKey(), as);
							s.opmapping.put(0, temp);
						}
						up.add(set.getKey());
						s.submissions.put(1,up);
						return ; 
					}
					
				}
				
			}
		}
		else if (g.matches("S1")) {
			count=0;
			ArrayList<String> up = new ArrayList<String>();
			if (s.submissions.containsKey(1)){
				up = s.submissions.get(1);
			}
			for (Map.Entry<String,Integer> set : s.assessments.get(1).entrySet()) {
				if (count==x) {
					if (set.getValue()!=null) {
						System.out.print("Enter filename of assignment: ");
						String input = sc.nextLine();
						if (input.contains(".zip")) {
							Map<String,String> temp = new HashMap<String,String>() ;
							if (s.opmapping.containsKey(0)) {
								temp=s.opmapping.get(0);
								temp.put(set.getKey(), input);
							}
							else {
								temp.put(set.getKey(), input);
							}
							s.opmapping.put(1, temp);
							up.add(set.getKey());
							s.submissions.put(1,up);
						}
						else {
							System.out.println("Wrong type of file ");
							
							return;
						}
						
					}
					else {
						System.out.print(set.getKey()+" ?");
						String a = sc.nextLine();
						Map<String,String> temp = new HashMap<String,String>() ;
						if (s.opmapping.containsKey(1)) {
							temp=s.opmapping.get(1);
							temp.put(set.getKey(), a);
						}
						else {
							temp.put(set.getKey(), a);
						}
						
						s.opmapping.put(1, temp);
						up.add(set.getKey());
						s.submissions.put(1,up);
					}
					
					
				}
				
			}
		}
		else if (g.matches("S2")) {
			count=0;
			ArrayList<String> up = new ArrayList<String>();
			if (s.submissions.containsKey(2)){
				up = s.submissions.get(2);
			}
			
			for (Entry<String, Integer> set : s.assessments.get(2).entrySet()) {
				if (count==x) {
					if (set.getValue()!=null) {
						System.out.print("Enter filename of assignment: ");
						String input = sc.nextLine();
						if (input.contains(".zip")) {
							Map<String,String> temp = new HashMap<String,String>() ;
							if (s.opmapping.containsKey(0)) {
								temp=s.opmapping.get(0);
								temp.put(set.getKey(), input);
							}
							else {
								temp.put(set.getKey(), input);
							}
							s.opmapping.put(0, temp);
							s.submissions.put(1,up);
							up.add(set.getKey());
						}
						else {
							System.out.println("Wrong type of file ");
							
							return;
						}
						
					}
					else {
						System.out.print(set.getKey()+" ?");
						String a = sc.nextLine();
						Map<String,String> temp = new HashMap<String,String>() ;
						if (s.opmapping.containsKey(2)) {
							temp=s.opmapping.get(2);
							temp.put(set.getKey(), a);
						}
						else {
							temp.put(set.getKey(), a);
						}
						s.opmapping.put(2, temp);
						up.add(set.getKey());
						s.submissions.put(1,up);
					}
				}
			}
		}
		else {
			System.out.println("java ");
		}
		
	}
	static void default_ass() {
		Student s = new Student();
		Map<String,Integer> temp = new HashMap<String,Integer>();
		Map<String,Integer> temp1 = new HashMap<String,Integer>();
		Map<String,Integer> temp2 = new HashMap<String,Integer>();
		temp = Instructor.assignments ;
		temp1 = Instructor.assignments ;
		temp2 = Instructor.assignments ;
		ArrayList<String> n = new ArrayList<String>();
		for (String e : Instructor.assignments.keySet()) {
			n.add(e);
		}
		for (String x : Instructor.quizquestions) {
			temp.put(x,null);
		}
		s.assessments.put(0, temp);
		s.assessments.put(1, temp1);
		s.assessments.put(2, temp2);
	}
	public static <K, V> Map<K, V> copyMap(Map<K, V> original)
    {
        return new HashMap<>(original);
    }
}
