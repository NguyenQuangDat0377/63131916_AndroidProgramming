package ntu.a63131916;


public class TinhchisoBMI {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập chiều cao của bạn（m）： ");
		double tall = scanner.nextDouble();
		System.out.println("Nhập cân nặng của bạn(kg)：");
		int weight = scanner.nextInt();
		
		double bmi_result = bmi_count(tall,weight);
		System.out.println("Chỉ số BMI hiện tại của bạn là："+bmi_result);
		bmi_lank(bmi_result);
	}
	
	public static double bmi_count(double tall,int weight){
		return weight/(tall*tall);
	}
	
	public static void bmi_lank(double bmi_result){
		if (bmi_result < 18.5)
			System.out.println("Bạn nhẹ cân ！");
		else if(bmi_result < 24)
			System.out.println("Cân nặng của bạn lý tưởng, hãy tiếp tục duy trì！");
		else if(bmi_result < 27)
			System.out.println("Bạn thừa cân ！");
		else if(bmi_result < 30)
			System.out.println("Bạn hơi bị béo phì！");
		else if(bmi_result < 35)
			System.out.println("Bạn béo phì ở mức thường！");
		else
			System.out.println("Cảnh báo: bạn bị béo phì ở mức nguy hiểm ！");
	}
}