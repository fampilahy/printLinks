package dao;

import java.util.List;
import java.util.Map;

import beans.Offer;

public interface DaoOffer {
	
	public Offer searchOffer();
	
	public int saveOffer();
	
	public List<Offer> findOffers(Map<String,String> parameters);

}
