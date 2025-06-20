package kadai_021;

public class DictionaryExec_Chapter21 {

	public static void main(String[] args) {
		Dictionary_Chapter21 dict = new Dictionary_Chapter21();
		String[] fruits = {"apple","banana","grape","orange"};
		
		for (String fruit:fruits) {
			String fJapanese =dict.dictionary.get(fruit);
			if (fJapanese==null) {
				System.out.println(fruit+"は辞書に存在しません");				
			}else {
				System.out.println(fruit+"の意味は"+fJapanese);
			}
			
		}
		

	}

}
