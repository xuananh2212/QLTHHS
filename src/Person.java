import java.util.Scanner;

public  abstract class Person implements NhapXuat {
	protected String hoTen;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;
	

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @return the namSinh
	 */
	public int getNamSinh() {
		return namSinh;
	}

	/**
	 * @return the noiSinh
	 */
	public String getNoiSinh() {
		return noiSinh;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @param namSinh the namSinh to set
	 */
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	/**
	 * @param noiSinh the noiSinh to set
	 */
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Person() {

	}

	/**
	 * @param hoTen
	 * @param namSinh
	 * @param noiSinh
	 * @param diaChi
	 */
	protected Person(String hoTen, int namSinh, String noiSinh, String diaChi) {

		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	public void nhap(Scanner scan) {
		System.out.print("Họ và Tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Năm Sinh: ");
		this.namSinh = Integer.parseInt(scan.nextLine());
		System.out.print("Nơi Sinh: ");
		this.noiSinh = scan.nextLine();
		System.out.print("Địa chỉ: ");
		this.diaChi = scan.nextLine();

	}

	public void xuat() {

		System.out.print("Họ Và Tên : " + this.hoTen + "\tNăm sinh: " + this.namSinh + "\tNơi Sinh: " + this.noiSinh
				+ "\tĐịa chỉ: " + this.diaChi);

	}
	// method này có chức năng xuất ra chức vụ Student hay Teacher
	public abstract void xuatTenNoiNamSinh();
	

}
