import java.util.Scanner;

public class Teacher extends Person {
	final int NAM_DANG_DAY = 2021;
	private int namBatDau;
	private String ChuyenMon;
	private int thamNien;

	/**
	 * @return the namBatDau
	 */
	public int getNamBatDau() {
		return namBatDau;
	}

	/**
	 * @return the chuyenMon
	 */
	public String getChuyenMon() {
		return ChuyenMon;
	}

	/**
	 * @return the thapNien
	 */
	public int getThamNien() {
		return thamNien;
	}

	/**
	 * @param namBatDau the namBatDau to set
	 */
	public void setNamBatDau(int namBatDau) {
		this.namBatDau = namBatDau;
	}

	/**
	 * @param chuyenMon the chuyenMon to set
	 */
	public void setChuyenMon(String chuyenMon) {
		ChuyenMon = chuyenMon;
	}

	public Teacher() {

	}

	public Teacher(String hoTen, int namSinh, String noiSinh, String diaChi, int namBD, String chuyenMon) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.namBatDau = namBD;
		this.ChuyenMon = chuyenMon;

	}

	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.println("năm bắt đầu: ");
		this.namBatDau = Integer.parseInt(scan.nextLine());
		boolean flag = true;
		do {
			System.out.println("Chuyên Môn ((tự Nhiên , Xã Hội)) :");
			this.ChuyenMon = scan.nextLine();
			if (this.ChuyenMon.equalsIgnoreCase("Tự Nhiên") || this.ChuyenMon.equalsIgnoreCase("Xã Hội")) {

				flag = false;
			}
		} while (flag);

	}

	@Override
	public void xuat() {

		super.xuat();
		System.out.println("năm bắt đầu: " + this.namBatDau + "\t chuyên Ngành: " + this.ChuyenMon + "\tThập Niên: "
				+ this.thamNien);

	}

	@Override
	public void xuatTenNoiNamSinh() {

		System.out.println("Teacher - \t\t\tName: " + this.hoTen + "\t\t\tBirth Year: " + this.namSinh
				+ "\t\t\t Born Position: " + this.noiSinh);

	}

	public void tinhThamNien() {
		this.thamNien = NAM_DANG_DAY - this.namBatDau;

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
		text += "|" + formatNumCell(this.namBatDau);
		text += "|" + formatNumCell(this.thamNien);
		text += "|" + formatTextCell(this.ChuyenMon) + "||";
		System.out.println(text);

	}

}
