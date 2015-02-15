package jp.atlas.elasticsearch.sample;

public class StringUtils {

	private StringUtils(){}
	
	/**
	 * 文字列を数値に変換
	 * @param num 数値文字列
	 * @param defultNum 変換できない場合に返却する数値
	 * @return　数値
	 */
	public static int parse(String num, int defultNum) {
		if (num == null) {
			return defultNum;
		}
		int i = 0;
		try {
			i = Integer.parseInt(num.trim());
		} catch (NumberFormatException e) {
			i = defultNum;
		}
		return i;
	}
}
