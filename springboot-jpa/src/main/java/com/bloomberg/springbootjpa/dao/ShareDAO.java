package com.bloomberg.springbootjpa.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bloomberg.springbootjpa.entity.Share;

@Repository
public interface ShareDAO extends CrudRepository<Share,String> {
	
	@Transactional
	@Modifying
	@Query("update Share set sharePrice=?2,  equityDebtRatio=?3, "
			+ "totalInvestmentsInCrores=?4 where shareName=?1")
	public void updateShare(String shareName,double sharePrice, 
			double equityDebtRatio,double totalInvestmentsInCrores);

	public Optional<Share> findBySharePrice(double sharePrice);
}
