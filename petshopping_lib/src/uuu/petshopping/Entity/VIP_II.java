package uuu.petshopping.Entity;

import java.time.LocalDate;

public class VIP_II {
	private String id; // Required, ROCID
	private String email; // Required, Unique Index, Regex
	private String phone; // Required, Unique Index, Regex
	private String password; // Required, 6~20英數字, 大小寫有別
	private String name; // Required, 2~20英數字
	private char gender; // Required, F, M, O
	private LocalDate birthday; // Required, 12以上
	private String address = ""; // Optional
	private boolean subscribed; // Optional
	private int discount; // Optional

	public VIP_II() {
		super();
	}
	public VIP_II(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public VIP_II(String id, String password, String name, int discount) {
		this(id, password, name);
		this.setDiscount(discount);
	}

	public static final String ROC_ID_PATTERN = "^[A-Z][1289](\\d){8}$";

	public void setId(String id){
		if(checkId(id))
			this.id = id;
		else{
			this.id = "未設定帳戶id";
			System.err.println("未有設定合格帳戶");
		}
	}
	public String getId(){
		return this.id;
	}
	public boolean checkId(String id){
		if(id != null && id.matches(ROC_ID_PATTERN)){
			char firstChar = id.charAt(0);
			int sum = 0;
			switch(firstChar){
				default:
					return false;
				case 'B', 'N', 'Z':
					sum = 0;
					break;
				case 'A', 'M', 'W':
					sum = 1;
					break;
				case 'L', 'K', 'Y':
					sum = 2;
					break;
				case 'J', 'V', 'X':
					sum = 3;
					break;
				case 'H', 'U':
					sum = 4;
					break;
				case 'G', 'T':
					sum = 5;
					break;
				case 'F', 'S':
					sum = 6;
					break;
				case 'E', 'R':
					sum = 7;
					break;
				case 'D', 'Q', 'O':
					sum = 8;
					break;
				case 'C', 'I', 'P':
					sum = 9;
					break;
			}
			for(int i = 1, j = 8; i < 10; i++, j--){
				sum = sum + (id.charAt(i) - 48) * (j == 0 ? 1 : j);
			}
			return sum % 10 == 0;
		}else
			return false;
	}

	public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	public void setEmail(String email){
		if(email == null){
			this.email = "尚未設定email";
			System.err.println("客戶郵件尚未設定");
			// TODO throw new XXX Exception
		}else if(email.matches(EMAIL_PATTERN)){
			this.email = email;
		}else{
			this.email = "設定email不符合格式";
			System.err.println("設定的郵件不符合格式");
			// TODO throw new XXX Exception
		}
	}
	public String getEmail(){
		return this.email;
	}

	public static final String PHONE_PATTERN = "^(\\d){4}((-)?(\\d){3}){2}";

	public void setPhone(String phone){
		if(phone == null){
			this.phone = "尚未設定電話號碼";
			System.err.println("客戶未設定電話號碼");
			// TODO throw new XXX Exception
		}else if(phone.matches(PHONE_PATTERN)){
			this.phone = phone;
		}else{
			this.phone = "設定電話不符合格式";
			System.err.println("客戶設定電話不符合格式");
			// TODO throw new XXX Exception
		}
	}
	public String getPhone(){
		return this.phone;
	}

	public static final int MIN_PWD_LENGTH = 6, MAX_PWD_LENGTH = 20;

	public void setPassword(String password){
		if(password != null && MIN_PWD_LENGTH <= password.length() && password.length() <= MAX_PWD_LENGTH){
			this.password = password;
		}else{
			this.password = "密碼設定不符合格式";
			System.err.println("客戶設定密碼未符合格式");
			// TODO throw new XXX Exception
		}
	}
	public String getPassword(){
		return this.password;
	}

	public static final int MIN_NAME_LENGTH = 2, MAX_NAME_LENGTH = 20;

	public void setName(String name){
		if(name != null && MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH)
			this.name = name;
		else{
			this.name = "未設定姓名";
			System.err.println("客戶未設定姓名");
			// TODO throw new XXX Exception
		}
	}
	public String getName(){
		return this.name;
	}
	public void setGender(char gender){
		if(gender == 'F' || gender == 'M' || gender == 'O')
			this.gender = gender;
		else
			System.err.println("設定性別不符合格式需求");
		// TODO throw new XXX Exception
	}
	public char getGender(){
		return this.gender;
	}
	public void setBirthday(int year, int month, int day){
		LocalDate date = LocalDate.of(year, month, day);
		this.setBirthday(date);
	}
	
	// ISO-8601 date String
	public void setBirthday(String dateString){
		LocalDate date = LocalDate.parse(dateString);
		this.setBirthday(date);
	}
	public void setBirthday(LocalDate date){
		if(date != null && LocalDate.now().getYear() - date.getYear() >= 12)
			this.birthday = date;
		else
			System.err.printf("會員生日(%s)未滿12歲不符合規定\n", date);
	}
	public LocalDate getBirthday(){
		return this.birthday;
	}
	public int getAge(){
		if(this.birthday != null){
			int age = LocalDate.now().getYear() - this.birthday.getYear();
			return age;
		}
		return -1; // TODO throw new XXX Exception
	}
	public void setAddress(String address){
		if(address == null)
			address = "";
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setSubscribed(boolean subscribed){
		this.subscribed = subscribed;
	}
	public boolean isSubscribed(){
		return this.subscribed;
	}

	public static final int MIN_DIS_SPEC = 1, MAX_DIS_SPEC = 15;

	public void setDiscount(int discount){
		if(MIN_DIS_SPEC <= discount && discount <= MAX_DIS_SPEC)
			this.discount = discount;
		else
			System.err.printf("VIP折扣不正確,應介於%s ~%s%%之間\n", MIN_DIS_SPEC, MAX_DIS_SPEC);
	}
	public int getDiscount(){
		return this.discount;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "\n[會員帳號: " + this.id + ", 會員郵件: " + this.email + ", 會員電話: "
				+ this.phone + ", 會員密碼: " + this.password + ", 會員姓名: " + this.name + ", 會員性別: " + this.gender + ", 生日: "
				+ this.birthday + (this.birthday != null ? ("age: " + this.getAge() + "歲") : "無法計算年齡") + ", \n會員地址: "
				+ this.address + ", 是否訂閱會員: " + this.isSubscribed() + ", 會員折扣: " + this.discount + "]";
	}
}
