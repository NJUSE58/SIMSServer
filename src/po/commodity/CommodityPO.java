package po.commodity;

import java.io.Serializable;

import po.ClassificationPO;
import po.PersistObject;

public class CommodityPO implements Serializable{

	private static final long serialVersionUID = -6035519417985941664L;
	private String id;
	private String name;
	private String model; // 商品型号
	private ClassificationPO classification;
	private int number; // 商品数量
	private double purPrice; // 进价
	private double retailedPrice; // 零售价
	private double recentPurPrice; // 最新进价
	private double recentRetailedPrice; // 最新零售价
	private int warmingValue; // 警戒值

	/**
	 * @Description: TODO(这里用一句话描述这个方法的作用) @param @param id @param @param
	 * name @param @param model @param @param classification @param @param
	 * number @param @param purPrice @param @param retailedPrice @param @param
	 * warmingValue 设定文件 @return 返回类型 @throws
	 */
	public CommodityPO(String id, String name, String model, ClassificationPO classification, int number,
			double purPrice, double retailedPrice, int warmingValue) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.classification = classification;
		this.number = number;
		this.purPrice = purPrice;
		this.retailedPrice = retailedPrice;
		this.warmingValue = warmingValue;
	}

	
	public ClassificationPO getClassification() {
		return classification;
	}

	public void setClassification(ClassificationPO classification) {
		this.classification = classification;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public int getNumber() {
		return number;
	}

	public double getPurPrice() {
		return purPrice;
	}

	public double getRetailedPrice() {
		return retailedPrice;
	}

	public double getRecentPurPrice() {
		return recentPurPrice;
	}

	public double getRecentRetailedPrice() {
		return recentRetailedPrice;
	}

	public int getWarmingValue() {
		return warmingValue;
	}
	
	
	public void setRecentPurPrice(double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}

	public void setRecentRetailedPrice(double recentRetailedPrice) {
		this.recentRetailedPrice = recentRetailedPrice;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + model + "," + number + "," + purPrice + "," + retailedPrice + ","
				+ recentPurPrice + "," + recentRetailedPrice + "," + warmingValue;
	}
}