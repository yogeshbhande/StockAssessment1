package com.nse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.entity.Share;

public interface ShareRepo extends JpaRepository<Share, Integer>{

}
