package kadai_028;
import java.util.HashMap;
import java.util.Scanner;


public class Jyanken_Chapter28 {
	public String getMyChoice() {
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println("グーはrockのrを入力しましょう");
		System.out.println("チョキはscissorsのsを入力しましょう");
		System.out.println("パーはpaperのpを入力しましょう");
		Scanner scanner = new Scanner(System.in);
		String myHand="hand";
		do {
			
			
			myHand = scanner.nextLine();
			switch(myHand) {
			case "r":
				break;
			case "s":
				break;
			case "p":
				break;
			default:
				{
					System.out.println(myHand+"は正しいじゃんけんの手ではありません");
					myHand="hand";
				}
			
			}
		} while (myHand =="hand");
		
		return myHand;
		
	}
	public String getRandom() {
		String oppHand="hand";
		int a = (int)(Math.floor(Math.random()*3)+1);
		switch(a) {
		case 1:oppHand="r";
			break;
		case 2:oppHand="s";
		    break;	
		case 3:oppHand="p";
		    break;    
		}
		return oppHand;
	}
	public void playGame() {
		HashMap<String,String> hands = new HashMap<String,String>();
		hands.put("r","グー");
		hands.put("s","チョキ");
		hands.put("p","パー");
		
		String myHand=hands.get(getMyChoice());
		String oppHand=hands.get(getRandom());
		System.out.println("自分の手は"+myHand+"、対戦相手の手は"+oppHand);
		if(myHand==oppHand) {
			System.out.println("あいこです");
		}else{
			if(myHand=="グー") {
				if(oppHand=="チョキ") {
					System.out.println("自分の勝ちです");
				}else {
					System.out.println("自分の負けです");
				}
			}else if(myHand=="チョキ") {
				if(oppHand=="パー") {
					System.out.println("自分の勝ちです");
				}else {
					System.out.println("自分の負けです");
				}
			}else if(myHand=="パー") {
				if(oppHand=="グー") {
					System.out.println("自分の勝ちです");
				}else {
					System.out.println("自分の負けです");
				}
			}
		}
		
	}

}
