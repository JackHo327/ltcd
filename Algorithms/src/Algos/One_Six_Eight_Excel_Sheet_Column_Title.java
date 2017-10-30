package Algos;

public class One_Six_Eight_Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {

		if (n > 0) {
			n--;
			String r = String.valueOf((char) (n % 26 + 65));
			return convertToTitle(n / 26) + r;
		} else {
			return "";
		}

		// turn the above logic into one line code
		// return n == 0 ? "": convertToTitle(--n/26)+String.valueOf((char) (n %
		// 26 + 65));
	}

}
