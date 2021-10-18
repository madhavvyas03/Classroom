package assign_2_ap_2020310;
import java.util.*;
class Instructor implements change{
	
	static Map<String, ArrayList<String>> materials = new HashMap<String,ArrayList<String>>();
	static Map<String, ArrayList<String>> materialsvid = new HashMap<String,ArrayList<String>>();
	static Map<String,Integer> assignments = new HashMap<String,Integer>();
	static ArrayList<String> quizquestions = new ArrayList<String>() ;
	static Map<String,Integer> grade_0 = new HashMap<String,Integer>();
	static Map<String,Integer> grade_1 = new HashMap<String,Integer>();
	static Map<String,Integer> grade_2 = new HashMap<String,Integer>();
	static Map<String,String> grade_by0 = new HashMap<String,String>();
	static Map<String,String> grade_by1 = new HashMap<String,String>();
	static Map<String,String> grade_by2 = new HashMap<String,String>();
	static int c;
	@Override
	public String enterid(){
		Scanner sc =new Scanner(System.in);
		System.out.println("Instructors:\r\n"
				+ "0 - I0\r\n"
				+ "1 - I1");
		System.out.println("Choose Id");
		c=sc.nextInt();
		if (c==0) {
			return "I0" ;
		}
		else if(c==1) {
			return "I1";
		}
		
		return "wrong";
		
	}
	@Override
	public void printinst() {
		System.out.println("INSTRUCTOR MENU\r\n"
				+ "1. Add class material\r\n"
				+ "2. Add assessments\r\n"
				+ "3. View lecture materials\r\n"
				+ "4. View assessments\r\n"
				+ "5. Grade assessments\r\n"
				+ "6. Close assessment\r\n"
				+ "7. View comments\r\n"
				+ "8. Add comments\r\n"
				+ "9. Logout");
	}
	public static void pseudo(){
		Scanner sc =new Scanner(System.in);
		Instructor i = new Instructor();
		Comments c = new Comments();
		String g = i.enterid();
		if (g=="wrong") {
			System.out.println("Enter valid Id ");
			i.enterid();
		}
		else {
			System.out.println("Welcome "+g);
		}
		for (int x = 0 ; x<Integer.MAX_VALUE ; x++){
			i.printinst();
			int a = sc.nextInt();
			
			if (a==1) {
				addclassmaterial();
			}
			else if (a==2) {
				addassessments();
			}
			else if (a==3) {
				i.viewlecturemat();
			}
			else if (a==4) {
				i.viewassessments();
			}
			else if (a==5) {
				i.gradeassessments(g);
			}
			else if (a==6) {
				i.closeassessments();
			}
			else if (a==7) {
				c.viewcomment();
			}
			else if (a==8) {
				c.addcomment(g);
			}
			else if(a==9){
				
				return ;
			}
			
		}
		
	}
	private static void addclassmaterial(){
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
			System.out.println("1. Add Lecture Slide\r\n"+ "2. Add Lecture Video");
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<String> content = new ArrayList<String>() ;
			if (n == 1) {
				
				System.out.print("Enter topic of slides: ");
				String a = sc.nextLine();
				System.out.print("Enter number of slides: ");
				int numslides = sc.nextInt();
				content.add(String.valueOf(c));
				java.util.Date date=java.util.Calendar.getInstance().getTime(); 
				content.add(String.valueOf(date));
				content.add(String.valueOf(numslides));
				System.out.println("Enter Content of Slides");
				for (int po =0 ; po<numslides ; po++) {
					int kp = po+1;
					System.out.print("Content of slide "+kp+" :");
					String con = sc.next();
					String con2 = sc.next();
					con=con+" "+con2;
					content.add(con);
				}
				materials.put(a,content);
			}
			if (n==2){
				System.out.print("Enter topic of Lecture:");
				String a = sc.nextLine();
				System.out.print("Enter Filename of Video");
				String s = sc.nextLine();
				content.add(String.valueOf(c));
				java.util.Date date=java.util.Calendar.getInstance().getTime(); 
				content.add(String.valueOf(date));
				content.add(s);
				if (s.contains(".mp4")){
					materialsvid.put(a,content);
				}
				else {
					System.out.println("The file should be of format '.mp4'");
				}
			}
	}
	private static void addassessments() {
		Scanner sc =new Scanner(System.in);
		System.out.println("1. Add Assignment\r\n"+ "2. Add Quiz");
		int n = Integer.parseInt(sc.nextLine());
		if (n == 1) {
			
			System.out.print("Enter Problem Statement ");
			String str= sc.nextLine(); 
			System.out.print("Enter Max Marks ");
			int maxmarks = sc.nextInt();
			assignments.put(str,maxmarks);
			}
		if (n==2){
			System.out.print("Enter Quiz Question : ");
			String str = sc.nextLine();
			quizquestions.add(str);
			}
		
		}
	public void viewassessments() {
		int count;
		count = 0 ;
		for (String i : assignments.keySet()) {
			if (assignments.get(i)!=null) {
				System.out.println("ID:"+count+" Assignment: "+i+" Max Marks: "+assignments.get(i));
				count++;
			}
			
		}
		for (String j : quizquestions ) {
			System.out.println("ID:"+count+" Question : "+j);
			count++;
		}
	}
	private void closeassessments() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("List of Open Assignments");
		Instructor i = new Instructor();
		i.viewassessments();
		System.out.println("Enter id of assignment to close: ");
		int input = sc.nextInt();
		int as=assignments.size()-1;
		if (input>as){
			quizquestions.remove(input);
		}
		else {
			int f = 0 ;
			for (Map.Entry<String, Integer> set : assignments.entrySet()) {
				if(f==input) {
					assignments.remove(set.getKey());
					break;
				}
				f++;
			}
		}
		
	}
	private void gradeassessments(String inst) {
		Scanner sc = new Scanner(System.in);
		Instructor i = new Instructor();
		Student s = new Student();
		System.out.println("List of Assessments");
		i.viewassessments();
		System.out.print("Enter ID of assessment to view submissions: ");
		int g = sc.nextInt();
		int as=assignments.size()-1;
		String real=null;
		if (g>as){
			real = quizquestions.get(g);
		}
		else {
			int f = 0 ;
			for (Map.Entry<String, Integer> set : assignments.entrySet()) {
				if(f==g) {
					real = set.getKey();
					break;
				}
				f++;
			}	
		}
		int wet = 0;
		System.out.println("Choose From These Ungraded Submissions");
		for(int j : s.submissions.keySet()) {
			if (s.submissions.get(j).contains(real)) {
				if (j==0) {
					System.out.println(wet+". S0");
				}
				else if (j==0) {
					System.out.println(wet+". S1");
				}
				else if (j==0) {
					System.out.println(wet+". S2");
				}
				j++;
			}
		}
		int choice = sc.nextInt();
		choice++;
		System.out.println("Submissions : "+s.opmapping.get(choice).get(real));
		System.out.println("Max Marks :"+assignments.get(real));
		System.out.print("Marks Scored :");
		int marks = sc.nextInt();
		if (choice==0) {
			grade_0.put(real,marks);
			grade_by0.put(real,inst);
		}
		else if (choice==1) {
			grade_1.put(real,marks);
			grade_by1.put(real,inst);
		}
		else if (choice==2) {
			grade_2.put(real,marks);
			grade_by2.put(real,inst);
		}
		
		
	}
		
	/**
	 *
	 */
	public void viewlecturemat() {
		for (Map.Entry<String, ArrayList<String>> set : materials.entrySet()) {
			ArrayList<String> mil = new ArrayList<String>() ;
			mil=set.getValue();
			int i=Integer.parseInt(mil.get(0));
			int count = 1 ; 
			int j = set.getValue().size();
			String g;
			System.out.println("Title :"+set.getKey());
			for (int h =3;h<j;h++) {
				System.out.println("Slide "+count+": "+mil.get(h));
				count++;
			}
			System.out.println("Number of Slides :"+ mil.get(2));
			System.out.println("Date of upload: "+mil.get(1));
			if (i==0) {
				g = "I0" ;
			}
			else {
				g="I1";
			}
			System.out.println("Uploaded by :"+g);
			System.out.println(" ");
		}
		for (Map.Entry<String, ArrayList<String>> set : materialsvid.entrySet()) {
			ArrayList<String> mil = new ArrayList<String>() ;
			mil=set.getValue();
			int i=Integer.parseInt(mil.get(0));
			System.out.println("Title of the Video :"+set.getKey());
			System.out.println("Video File :"+mil.get(2));
			System.out.println("Date of upload: "+mil.get(1));
			String g;
			if (i==0) {
				g = "I0" ;
			}
			else {
				g="I1";
			}
			System.out.println("Uploaded by :"+g);
			System.out.println(" ");
		}
	}
}
