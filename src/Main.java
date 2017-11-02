import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import beans.Offer;
import dao.DaoFactory;
import dao.DaoOffer;

public class Main {

	public static void main(String[] args) {
		
		
		DaoFactory daoFactory = DaoFactory.getInstance("utilities/dao.properties");
		DaoOffer daoOfferInstance = daoFactory.getDaoOfferInstance();
		
		
		Map<String,String> dafyOffersSearchKeysMap = new HashMap<String,String>();
		dafyOffersSearchKeysMap.put("sid","1301");
		List<Offer> dafyOffers = daoOfferInstance.findOffers(dafyOffersSearchKeysMap);
		
		Map<String,String> catalogDafyOffersSearchKeysMap = new HashMap<String,String>();
		catalogDafyOffersSearchKeysMap.put("sid","1300");
		List<Offer> catalogDafyOffers = daoOfferInstance.findOffers(catalogDafyOffersSearchKeysMap);
		
		List<Offer> offersToCrawl = new ArrayList<Offer>(); 
		
		int i =0;
		String sku;
		for (Offer daffyOffer :dafyOffers ){
			i++;
			
			
			sku = daffyOffer.getInternalref();
			if(sku.contains("-"))
				sku = sku.substring(0,sku.indexOf("-"));
			
			for(Offer catalogDafyOffer : catalogDafyOffers){
				
				
				
				
				if(catalogDafyOffer.getEan()!=null && catalogDafyOffer.getEan().contains(sku))
				{
					System.out.println(catalogDafyOffer.getEan()+"  "+daffyOffer.getInternalref());
					offersToCrawl.add(daffyOffer);
				}
					
				
			}
		}
		System.out.println("____"+i);
		System.out.print("____"+offersToCrawl.size());
		
		Set<String> linksToCrawl = new HashSet<String>();
		
		for(Offer of: offersToCrawl){
			linksToCrawl.add(of.getProductPath());
		}
		System.out.print("____"+linksToCrawl.size());
		

	}

}
