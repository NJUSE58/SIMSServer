package po;

import java.util.ArrayList;

import po.commodity.CommodityPO;


public class ClassificationPO extends PersistObject{

	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<CommodityPO> po;
	private ClassificationPO father;
	private ArrayList<ClassificationPO> children;

	public ClassificationPO(String id, String n,ArrayList<CommodityPO> p,ClassificationPO f,ArrayList<ClassificationPO> c){
		super(id);
		name = n;
		po = p;
		father = f;
		children = c;
	}

	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setCommodityPOArray(ArrayList<CommodityPO> p){
		po = p;
	}

	public ArrayList<CommodityPO> getCommodityPOArray(){
		return po;
	}

	public void setFather(ClassificationPO f){
		father = f;
	}

	public ClassificationPO getFather(){
		return father;
	}

	public void setChildren(ArrayList<ClassificationPO> c){
		children = c;
	}

	public ArrayList<ClassificationPO> getChildren(){
		return children;
	}
}
