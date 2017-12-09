package data.promotiondata;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.PromotionPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ6ÈÕ    
*/
public class PromotionData {

	public ResultMessage insert(PromotionPO po) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage delete(String id) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage update(PromotionPO po) {
		return ResultMessage.FAIL;
	}
	
	public PromotionPO find(String id) {
		PromotionPO po = null;
		return po;
	}
	
	public ArrayList<PromotionPO> show() {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		return list;
	}
}
