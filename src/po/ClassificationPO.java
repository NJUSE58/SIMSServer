package po;

import java.io.Serializable;
import java.util.ArrayList;

import po.commodity.CommodityPO;


public class ClassificationPO implements Serializable{

	private static final long serialVersionUID = -1575927402071619530L;
	private String id;
	private String name;
	private ArrayList<CommodityPO> po;
	private ClassificationPO father;
	private ArrayList<ClassificationPO> children;

	public ClassificationPO(String id, String n,ArrayList<CommodityPO> p,ClassificationPO f,ArrayList<ClassificationPO> c){
		this.id = id;
		name = n;
		po = p;
		father = f;
		children = c;
	}

	public String getID() {
		return id;
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
