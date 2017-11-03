package serialization;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import beans.OfferComparationOutPut;

public class CsvParser implements Serializer {

   private String separator;
   private Set<String> toCrawLinks;
   private List<OfferComparationOutPut> comparedOffers;

   public CsvParser(String separator, Set<String> toCrawlLinks, List<OfferComparationOutPut> comparedOffers) {
      this.toCrawLinks = toCrawlLinks;
      this.separator = separator;
      this.comparedOffers = comparedOffers;
   }

   public CsvParser(String separator, List<OfferComparationOutPut> comparedOffers) {
      this.separator = separator;
      this.comparedOffers = comparedOffers;
   }

   @Override
   public boolean saveComparedFile(String filePath) {
      try {
         FileWriter writer = new FileWriter(filePath);

         writer.append("catalogOfferTitle;catalogCPID;catalogOfferEan;dafySku;matchedSkuKey;dafyCPID;dafyTitle;dafyProductPath;\n");

         for (OfferComparationOutPut comp : comparedOffers) {
            writer.append(comp.getCatalogOfferTitle());
            writer.append(separator);

            writer.append(comp.getCatalogCPID());
            writer.append(separator);

            writer.append(comp.getCatalogOfferEan());
            writer.append(separator);

            writer.append(comp.getDafySku());
            writer.append(separator);

            writer.append(comp.getMatchedSkuKey());
            writer.append(separator);

            writer.append(comp.getDafyCPID());
            writer.append(separator);

            writer.append(comp.getDafyTitle());
            writer.append(separator);

            writer.append(comp.getDafyProductPath());
            writer.append(separator);

            writer.append('\n');

         }

         writer.flush();
         writer.close();

         return true;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      //
      return false;
   }

   @Override
   public boolean saveToCrawlLinks(String filePath) {
      try {
         FileWriter writer = new FileWriter(filePath);
         writer.append("toCrawlLink;\n");
         for (String toCrawlLink : toCrawLinks) {
            writer.append(toCrawlLink);
            writer.append(separator);
            writer.append('\n');

         }
         writer.flush();
         writer.close();
         return true;
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      //
      return false;
   }

}
