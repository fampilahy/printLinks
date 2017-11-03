package beans;

public class OfferComparationOutPut {

   public String getCatalogOfferTitle() {
      return catalogOfferTitle;
   }

   public void setCatalogOfferTitle(String catalogOfferTitle) {
      this.catalogOfferTitle = catalogOfferTitle;
   }

   public String getCatalogOfferEan() {
      return catalogOfferEan;
   }

   public void setCatalogOfferEan(String catalogOfferEan) {
      this.catalogOfferEan = catalogOfferEan;
   }

   public String getCatalogCPID() {
      return catalogCPID;
   }

   public void setCatalogCPID(String catalogCPID) {
      this.catalogCPID = catalogCPID;
   }

   public String getDafyCPID() {
      return dafyCPID;
   }

   public void setDafyCPID(String dafyCPID) {
      this.dafyCPID = dafyCPID;
   }

   public String getDafySku() {
      return dafySku;
   }

   public void setDafySku(String dafySku) {
      this.dafySku = dafySku;
   }

   public String getDafyTitle() {
      return dafyTitle;
   }

   public void setDafyTitle(String dafyTitle) {
      this.dafyTitle = dafyTitle;
   }

   public String getDafyProductPath() {
      return dafyProductPath;
   }

   public String getMatchedSkuKey() {
      return matchedSkuKey;
   }

   public void setMatchedSkuKey(String matchedSkuKey) {
      this.matchedSkuKey = matchedSkuKey;
   }

   public void setDafyProductPath(String dafyProductPath) {
      this.dafyProductPath = dafyProductPath;
   }

   private String catalogOfferTitle, catalogCPID, catalogOfferEan, dafySku, matchedSkuKey, dafyCPID, dafyTitle, dafyProductPath;

}
