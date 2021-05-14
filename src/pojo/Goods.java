package pojo;



public class Goods {
	enum StatusEnum{
		SELLING,SELLED
	}
	
	private int goodsId;
	private StatusEnum status=Goods.StatusEnum.SELLING;	
	private String name;
	private String description;
	private String pictureId;
	private String sellerId;
	
	public void setStatusToSelled(){
		this.status=Goods.StatusEnum.SELLED;
	}
	public void setStatusToSelling(){
		this.status=Goods.StatusEnum.SELLING;
	}
	public String getStatus(){
		return status.toString();
	}
	
	//setter and getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	
}
