package kadai_018;

public class KatoExec_Chapter18 {

	public static void main(String[] args) {
		KatoTaro_Chapter18 Taro = new KatoTaro_Chapter18();
		KatoIchiro_Chapter18 Ichiro = new KatoIchiro_Chapter18();
		KatoHanako_Chapter18 Hanako = new KatoHanako_Chapter18();
		
		Taro.setGivenName("太郎");
		Ichiro.setGivenName("一郎");
		Hanako.setGivenName("花子");
		
		Taro.execIntroduce();
		System.out.println();
		Ichiro.execIntroduce();
		System.out.println();
		Hanako.execIntroduce();

	}

}
