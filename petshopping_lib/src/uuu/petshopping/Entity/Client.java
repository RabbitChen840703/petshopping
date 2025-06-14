package uuu.petshopping.Entity;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import uuu.petshopping.Exception.PETDataInvalidException;
public class Client{
	private String id; // Primary Key
	private String password; // required 6~20
	private String name; // required, 2~20字元
	private String Email; // required
	private String Address; // optional
	private String phone; // required
	private char gender; // required F M O
	private LocalDate birthday; // required

	public Client(){
		super();
	}
	public Client(String id, String password, String name){
		this.setId(id);
		this.setPassword(name);
		this.setName(name);
	}
	public Client(String id, String password, String name, String email){
		this(id, password, name);
		this.setEmail(email);
	}

	public static final String ID_PATTERN = "^[A-Z][1289][0-9]{8}$";

	public void setId(String id){
		if(checkId(id))
			this.id = id;
		else{
			String errMsg = String.format("你輸入的id: %s不正確\n", id);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public boolean checkId(String id){
		if(id != null && id.matches(ID_PATTERN)){
			int sum = 0;
			switch(id.charAt(0)){
				default:
					return false;
				case 'B', 'N', 'Z':
					sum = 0;
					break;
				case 'A', 'M', 'W':
					sum = 1;
					break;
				case 'K', 'L', 'Y':
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
				case 'D', 'O', 'Q':
					sum = 8;
					break;
				case 'C', 'I', 'P':
					sum = 9;
					break;
			}
			for(int i = 1, j = 8; i < 10; i++, j--){
				sum = sum + (id.charAt(i) - 48) * (j == 0 ? 1 : j);
				// System.out.printf("sum: %s\n", sum);
			}
			return sum % 10 == 0;
		}else return false;
	}
	public String getId(){
		return id;
	}

	public static final int MIN_PWD_LENGTH = 6, MAX_PWD_LENGTH = 20;

	public void setPassword(String pwd){ // TODO 規定密碼長度，含有特殊字元與大小寫加數字
		if(pwd != null && MIN_PWD_LENGTH <= pwd.length() && pwd.length() <= MAX_PWD_LENGTH)
			this.password = pwd;
		else{
			String errMsg = String.format("請設定%s~%s個字元作為密碼\\n", MIN_PWD_LENGTH, MAX_PWD_LENGTH);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getPassword(){
		return password;
	}

	public static final int MIN_NAME_LENGTH = 2, MAX_NAME_LENGTH = 20;

	public void setName(String name){
		if(name != null && MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH)
			this.name = name;
		else{
			String errMsg = String.format("會員姓名:[%s] 不正確，須為%d~%d個字。\n", name, MIN_NAME_LENGTH, MAX_NAME_LENGTH);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getName(){
		return name;
	}
	
	public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	public void setEmail(String email){
		if(email != null && email.matches(EMAIL_PATTERN))
			this.Email = email;
		else{
			String errMsg = String.format("你輸入的email: %s並不正確 %s\n", email);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getEmail(){
		return Email;
	}
	public void setAddress(String address){
		if(address == null) address = "";
		this.Address = address;
	}
	public String getAddress(){
		return Address;
	}

	public static final String PHONE_PATTERN = "^[0-9]{4}([-]?[0-9]{3}){2}$";

	public void setPhone(String phone){
		if(phone != null && phone.matches(PHONE_PATTERN))
			this.phone = phone;
		else{
			String errMsg = String.format("您的電話不符合格式: %s\n", phone, PHONE_PATTERN);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getPhone(){
		return phone;
	}

	public static final char MALE = 'M', FEMALE = 'F', OTHER = 'O';

	public void setGender(char gender){
		if(gender == MALE || gender == FEMALE || gender == OTHER)
			this.gender = gender;
		else{
			String errMsg = String.format("性別資料請輸入: %s/%s/%s \n", FEMALE, MALE, OTHER);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public char getGender(){
		return gender;
	}

	public static final int MIN_AGE = 12;

	public void setBirthday(int year, int month, int day){
		try{
			LocalDate date = LocalDate.of(year, month, day);
			this.setBirthday(date);
		}catch (DateTimeException e){
			String errMsg = String.format("年輸入生日資料:[%s,%s,%s] 不正確", year, month, day);
			throw new PETDataInvalidException(errMsg);
		}
	}
	// 將String型態且符合iso-8601的dateString參數 轉成LocalDate物件
	public void setBirthday(String dateString){// dateString==null 或不符合iso-8601
		try{
			LocalDate date = LocalDate.parse(dateString);
			this.setBirthday(date);
		}catch (DateTimeParseException | NullPointerException e){
			String errMsg = String.format("您輸入生日資料:[%s] 不正確，不得為null且須符合iso-8601。\n", dateString);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public void setBirthday(LocalDate date){ // 標準setter
		if(date != null && LocalDate.now().getYear() - date.getYear() >= MIN_AGE)
			this.birthday = date;
		else{
			String errMsg = String.format("會員必須年滿%d歲，生日(%s)不合規則\n", MIN_AGE, date);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public LocalDate getBirthday(){
		return birthday;
	}
	public int getAge(){
		if(this.birthday != null && LocalDate.now().getYear() > this.birthday.getYear()){
			int age = LocalDate.now().getYear() - this.birthday.getYear();
			return age;
		}else throw new PETDataInvalidException("無法計算年齡");
	}
	@Override
	public String toString(){
		return getClass().getSimpleName() + "[會員帳號: " + this.id + ", 會員密碼: " + this.password + ", 會員姓名: " + this.name + ", 會員郵件: "
				+ this.Email + ", 會員地址: " + this.Address + ",\n會員電話: " + this.phone + ", 會員性別: " + this.gender + ", 會員生日: "
				+ this.birthday + (this.birthday != null ? (",age: " + this.getAge()) : ", 無法計算年紀!") + "]";
	}
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj instanceof Client){
			boolean rtn = (this.id != null && this.id.equals(((Client) obj).id));
			return rtn;
		}
		return false;
	}
//	@Override
//	public boolean equals(Object obj){
//		if(this == obj) return true;
//		if(obj == null) return false;
//		if(this.getClass() != obj.getClass()) return false;
//		Client other = (Client) obj;
//		if(this.id == null){
//			if(other.id != null) return false;
//		}else if(!this.id.equals(other.id)) return false;
//		return true;
//	}
//	@Override
//	public boolean equals(Object obj){
//		if(this == obj) return true;
//		if(obj == null) return false;
//		if(this.getClass() != obj.getClass()) return false;
//		Client other = (Client) obj;
//		return Objects.equals(this.id, other.id);
//	}
}
