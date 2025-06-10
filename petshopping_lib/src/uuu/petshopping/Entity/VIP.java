package uuu.petshopping.Entity;

public class VIP extends Client {
	private int discount; // Required, 1~15% off
	public static final int MIN_DIS_SPEC = 1, MAX_DIS_SPEC = 15;

	public void setDiscount(int discount){
		if(MIN_DIS_SPEC <= discount && discount <= MAX_DIS_SPEC)
			this.discount = discount;
		else
			System.err.printf("折扣必須介於%s ~ %s%%之間\n", MIN_DIS_SPEC, MAX_DIS_SPEC);
		// TODO throw new XXX Exception
	}
	public int getDiscount(){
		return this.discount;
	}
	public String getDiscountString(){
		int discount = 100 - this.discount;
		if(discount % 10 == 0) discount = discount / 10;
		return discount + "折";
	}
	@Override
	public String toString(){
		return super.toString() + "[discount: " + this.discount + "% off, 即為" + this.getDiscountString() + "]";
	}
}
