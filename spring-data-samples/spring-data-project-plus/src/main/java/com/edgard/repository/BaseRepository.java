package com.edgard.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	/*
	@SuppressWarnings("unchecked")
	@Async
	public List<T> findByIds(ID...ids);
	*/
	
	/*
	@SuppressWarnings("unchecked")
	public List<T> findByIds(ID...ids);
	*/
}
