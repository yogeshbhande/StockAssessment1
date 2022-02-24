package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nse.entity.Portfolio;
import com.nse.entity.Share;
import com.nse.repository.PortfolioRepo;
import com.nse.repository.ShareRepo;

@org.springframework.stereotype.Service
public class stockServiceImpl implements StockService {
	@Autowired
	private PortfolioRepo pRepo;

	@Autowired
	private ShareRepo sRepo;

	public Portfolio createPortfolio(Portfolio p) {
		return pRepo.save(p);
	}

	public List<Portfolio> showPortfolio() {
		return pRepo.findAll();
	}
	public Share createShare(Share s) {
		return sRepo.save(s);
	}
	public List<Share> showShare() {
		return sRepo.findAll();
	}

	public boolean buyShare(Integer shareId, Integer portfolioId) {
		Portfolio p = pRepo.findById(portfolioId).get();
		Share s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() + s.getPrice());
		List<Portfolio> plist = new ArrayList<>();
		plist.add(p);
		List<Share> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.save(p);
		sRepo.save(s);
		return true;
	}

	public boolean sellShare(Integer shareId, Integer portfolioId) {
		Portfolio p = pRepo.findById(portfolioId).get();
		Share s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() - s.getPrice());
		List<Portfolio> plist = new ArrayList<>();
		plist.add(p);
		List<Share> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.delete(p);
		sRepo.delete(s);
		return true;
	}
}
