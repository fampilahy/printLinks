package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beans.Offer;

public class Utilities {

   public static String prepareSelectRequest(Map<String, String> searchKeysMap) {
      if (searchKeysMap == null || searchKeysMap.isEmpty()) return null;
      String selectRequest = "SELECT cpid, ean, internalref, pid, productPath, sid , title FROM site_products ";
      int paramIterator = 1;
      for (Map.Entry<String, String> entry : searchKeysMap.entrySet()) {
         if (paramIterator == 1) {
            selectRequest += " WHERE ";
         } else {
            selectRequest += " AND ";
         }
         selectRequest += entry.getKey() + " =? ";

         paramIterator++;
      }
      System.out.println("Prepared request " + selectRequest);
      return selectRequest + ";";
   }

   public static void addValueOnPreparedStatement(PreparedStatement preparedStatement, Map<String, String> searchKeysMap) {
      if (preparedStatement == null || searchKeysMap == null || searchKeysMap.isEmpty()) return;
      int paramIterator = 1;
      for (Map.Entry<String, String> entry : searchKeysMap.entrySet()) {
         try {
            preparedStatement.setObject(paramIterator, entry.getValue());
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         paramIterator++;
      }

   }

   public static List<Offer> mapOffer(ResultSet resultSet) {
      if (resultSet == null) return null;

      List<Offer> offers = new ArrayList<Offer>();
      Offer offer;
      try {
         while (resultSet.next()) {

            offer = new Offer();
            offer.setCpid(resultSet.getInt(1));
            offer.setEan(resultSet.getString(2));
            offer.setInternalref(resultSet.getString(3));
            offer.setPid(resultSet.getInt(4));
            offer.setProductPath(resultSet.getString(5));
            offer.setSid(resultSet.getInt(6));
            offer.setTitle(resultSet.getString(7));
            offers.add(offer);

         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return offers;

   }

}
