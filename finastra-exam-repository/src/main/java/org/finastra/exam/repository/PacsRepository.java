package org.finastra.exam.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.finastra.exam.repository.data.Pacs008;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repository for Pacs
 * 
 * @author jr mangulabnan
 *
 */
@Repository
public class PacsRepository {

	@Autowired
	private DataSource dataSource;

	/**
	 * Save Pacs008
	 * 
	 * @param pacs008
	 * @throws SQLException 
	 */
	public int[] save(Pacs008 pacs008) throws SQLException {
		PreparedStatement ps = dataSource.getConnection().prepareStatement("INSERT INTO PACS008 VALUES (?, ?)");
		for (Pacs008.Document document : pacs008.getDocument()) {
			ps.setString(1, document.getGrpHdr().getMsgId());
			ps.setLong(2, document.getCdtTrfTxInf().getIntrBkSttlmAmt());
			ps.addBatch();
		}
		return ps.executeBatch();
	}

	/**
	 * Get sum of INTRBKSTTLMAMT
	 */
	public long getTotalInterbankSettlementAmount() {
		long sum = 0;
		try {
			ResultSet rs = dataSource.getConnection().createStatement()
					.executeQuery("SELECT SUM(INTRBKSTTLMAMT) FROM PACS008");
			rs.next();
			sum = rs.getLong(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

}
