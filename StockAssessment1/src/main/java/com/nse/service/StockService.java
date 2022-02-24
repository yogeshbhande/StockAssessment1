package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nse.entity.Portfolio;
import com.nse.entity.Share;

@org.springframework.stereotype.Service
public interface StockService {

	public Portfolio createPortfolio(Portfolio p);

	public List<Portfolio> showPortfolio();

	public boolean buyShare(Integer shareId, Integer portfolioId);

	public boolean sellShare(Integer shareId, Integer portfolioId);
	
	public List<Share> showShare();

	public Share createShare(Share s);
}