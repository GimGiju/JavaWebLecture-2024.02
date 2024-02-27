package dog.entity;

public class Item {
	private int itemId;
	private int price;
	private String itemName;
	private String iType;
	private String note;
	private String fNmae;
	public Item() { }
	@Override
	public String toString() {
		return "item [itemId=" + itemId + ", price=" + price + ", itemName=" + itemName + ", iType=" + iType + ", note="
				+ note + ", fNmae=" + fNmae + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getiType() {
		return iType;
	}
	public void setiType(String iType) {
		this.iType = iType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getfNmae() {
		return fNmae;
	}
	public void setfNmae(String fNmae) {
		this.fNmae = fNmae;
	}
	
}
