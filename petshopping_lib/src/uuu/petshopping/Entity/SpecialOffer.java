package uuu.petshopping.Entity;

public class SpecialOffer extends Product {
	private int discount; // Required 1~90% off
	public static final int MIN_DIS_SPEC = 1, MAX_DIS_SPEC = 90;

	public SpecialOffer() {
		super();
	}
	public SpecialOffer(int id, String name, double unitPrice) {
		super(id, name, unitPrice);
	}
	public SpecialOffer(int id, String name, double unitPrice, int discount) {
		super(id, name, unitPrice);
		this.setDiscount(discount);
	}
	public double getListPrice(){
		return super.getUnitPrice();
	}
	public void setDiscount(int discount){
		if(MIN_DIS_SPEC <= discount && discount <= MAX_DIS_SPEC)
			this.discount = discount;
		else
			System.err.printf("折扣違反既定區間: %s ~ %s%%\n	", MIN_DIS_SPEC, MAX_DIS_SPEC);
		// TODO throw new XXX Exception
	}
	public int getDiscout(){
		return this.discount;
	}
	public String getDiscountString(){
		int discount = 100 - this.discount;
		if(discount % 10 == 0) discount = discount / 10;
		return discount + "折";
	}
	@Override
	public double getUnitPrice(){
		double unitPrice = (super.getUnitPrice()) * (100 - this.discount) / 100;
		return unitPrice;
	}
	@Override
	public String toString(){
		return super.toString() + "[折扣= " + this.discount + "%off ,即為: " + this.getDiscountString() + ", 售價= "
				+ this.getListPrice() + "]";
	}
}
