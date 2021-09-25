import java.util.Scanner;

public class Student extends Person {
	private float math;
	private float english;
	private float literature;
	private float diemTB;
	private String xepLoai;

	/**
	 * @return the math
	 */
	public float getMath() {
		return math;
	}

	/**
	 * @return the english
	 */
	public float getEnglish() {
		return english;
	}

	/**
	 * @return the literature
	 */
	public float getLiterature() {
		return literature;
	}

	/**
	 * @return the diemTB
	 */
	public float getDiemTB() {
		return diemTB;
	}

	/**
	 * @return the xepLoai
	 */
	public String getXepLoai() {
		return xepLoai;
	}

	/**
	 * @param math the math to set
	 */
	public void setMath(float math) {
		this.math = math;
	}

	/**
	 * @param english the english to set
	 */
	public void setEnglish(float english) {
		this.english = english;
	}

	/**
	 * @param literature the literature to set
	 */
	public void setLiterature(float literature) {
		this.literature = literature;
	}

	public Student() {

	}

	public Student(String hoTen, int namSinh, String noiSinh, String diaChi, float math, float english,
			float literature) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.math = math;
		this.english = english;
		this.literature = literature;

	}

	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Math: ");
		this.math = Float.parseFloat(scan.nextLine());
		System.out.print("English: ");
		this.english = Float.parseFloat(scan.nextLine());
		System.out.print("literature: ");
		this.literature = Float.parseFloat(scan.nextLine());

	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("math: " + this.math + "\tEnglish: " + this.english + "literature: " + this.literature
				+ "\tDiểm TB: " + this.diemTB + "Xếp loại: " + this.xepLoai);

	}

	@Override
	public void xuatTenNoiNamSinh() {

		System.out.println("Student - \t\t\tName: " + this.hoTen + "\t\t\tBirth Year: " + this.namSinh
				+ "\t\t\t Born Position: " + this.noiSinh);

	}

	public void TinhDTB() {

		this.diemTB = (this.math + this.english + this.literature) / 3;
	}

	public void XepLoai() {

		if (this.diemTB > 9) {
			this.xepLoai = "Xuất Sắc";
		} else if (this.diemTB >= 8) {

			this.xepLoai = "giỏi";
		} else if (this.diemTB >= 7) {

			this.xepLoai = "khá";
		} else if (this.diemTB >= 5) {

			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}

	}
	
	private String formatNumCell(Number num) {

		String paddLight = "%5s";
		String paddRight = "%-8s";

		return String.format(paddLight, " ") + String.format(paddRight, " " + num);
	}

	private String formatTextCell(String text) {

		String paddLight = "%-12s";
		return String.format(paddLight, " " + text);

	}

	public void formatRow() {
		String text;
		text = "||" + formatTextCell(this.hoTen);
		text += "|" + formatNumCell(this.namSinh);
		text += "|" + formatTextCell(this.noiSinh);
		text += "|" + formatTextCell(this.diaChi);
		text += "|" + formatNumCell(this.math);
		text += "|" + formatNumCell(this.english);
		text += "|" + formatNumCell(this.literature);
		
		double tT =  (Math.round(this.diemTB * 100.0)/100.0);
		text +="|" + formatNumCell(tT);
		text += "|" + formatTextCell(this.xepLoai)+"||";
		System.out.println(text);

	}

}
