package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import static dao.Utilities.*;
import beans.Offer;

public class DaoOfferImplementation implements DaoOffer{
	
	
	DaoFactory daoFactory ;
	public  DaoOfferImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Offer searchOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveOffer() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public List<Offer> findOffers(){
		return null;
		
	}

	@Override
	public List<Offer> findOffers(Map<String, String> searchKeysMap) {
		Connection connection = daoFactory.getConnection();
		String sqlRequest = prepareSelectRequest(searchKeysMap);
		
		PreparedStatement preparedStatement ;
		ResultSet resultSet;
		try{
			preparedStatement = connection.prepareStatement(sqlRequest);
			addValueOnPreparedStatement(preparedStatement, searchKeysMap);
			System.out.println("value added on request");
			resultSet = preparedStatement.executeQuery();
			System.out.println("Query done");
			return mapOffer(resultSet);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
//	private int cpid;
//	private String ean;
//	private String internalref;
//	private int pid;
//	private String productPath;
//	private int sid;
}
