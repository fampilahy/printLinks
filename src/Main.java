import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import beans.Offer;
import beans.OfferComparationOutPut;
import dao.DaoFactory;
import dao.DaoOffer;
import serialization.CsvParser;

public class Main {

   public static void main(String[] args) {

      DaoFactory daoFactory = DaoFactory.getInstance("utilities/dao.properties");
      DaoOffer daoOfferInstance = daoFactory.getDaoOfferInstance();

      Map<String, String> dafyOffersSearchKeysMap = new HashMap<String, String>();
      dafyOffersSearchKeysMap.put("sid", "1301");// DAFY SID
      List<Offer> dafyOffers = daoOfferInstance.findOffers(dafyOffersSearchKeysMap);

      Map<String, String> catalogDafyOffersSearchKeysMap = new HashMap<String, String>();
      catalogDafyOffersSearchKeysMap.put("sid", "1300"); // CATALOG DAFY SID
      List<Offer> catalogDafyOffers = daoOfferInstance.findOffers(catalogDafyOffersSearchKeysMap);

      List<Offer> offersToCrawl = new ArrayList<Offer>();

      int i = 0;
      String matchedSkuKey;

      List<OfferComparationOutPut> comparedOffers = new ArrayList<OfferComparationOutPut>();
      OfferComparationOutPut comparedOffer;

      for (Offer daffyOffer : dafyOffers) {
         i++;

         matchedSkuKey = daffyOffer.getInternalref();
         if (matchedSkuKey.contains("-")) matchedSkuKey = matchedSkuKey.substring(0, matchedSkuKey.indexOf("-"));

         // take off 2 characters from each extremity of dafy offer sku
         matchedSkuKey = matchedSkuKey.substring(2, matchedSkuKey.length() - 2);

         for (Offer catalogDafyOffer : catalogDafyOffers) {

            if (catalogDafyOffer.getEan() != null && catalogDafyOffer.getEan().contains(matchedSkuKey)) {
               System.out.println(matchedSkuKey + " " + catalogDafyOffer.getEan() + "  " + daffyOffer.getInternalref());
               offersToCrawl.add(daffyOffer);
               comparedOffer = new OfferComparationOutPut();
               comparedOffer.setCatalogCPID("" + catalogDafyOffer.getCpid());
               comparedOffer.setCatalogOfferEan(catalogDafyOffer.getEan());
               comparedOffer.setCatalogOfferTitle(catalogDafyOffer.getTitle());
               comparedOffer.setDafyCPID("" + daffyOffer.getCpid());
               comparedOffer.setDafyProductPath(daffyOffer.getProductPath());
               comparedOffer.setDafySku(daffyOffer.getInternalref());
               comparedOffer.setDafyTitle(daffyOffer.getTitle());
               comparedOffer.setMatchedSkuKey(matchedSkuKey);
               comparedOffers.add(comparedOffer);
               break;
            }

         }
      }

      System.out.println("dafy offer number ____" + i);
      System.out.println("offer to crawl size ____" + offersToCrawl.size());

      Set<String> linksToCrawl = new HashSet<String>();

      for (Offer of : offersToCrawl) {
         linksToCrawl.add(of.getProductPath());
      }
      System.out.println("links without double ____" + linksToCrawl.size());

      CsvParser csvParser = new CsvParser(";", linksToCrawl, comparedOffers);

      if (csvParser.saveComparedFile("OutPut.csv")) {
         System.out.println("FINISH");
      }

      if (csvParser.saveToCrawlLinks("ToCrawl.csv")) {
         System.out.println("FINISH");
      }

   }

}
