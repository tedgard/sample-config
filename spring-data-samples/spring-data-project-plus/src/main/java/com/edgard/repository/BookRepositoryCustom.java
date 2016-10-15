package com.edgard.repository;

import com.edgard.domain.Book;

public interface BookRepositoryCustom {

	public void saveAndLog(Book book);
}
