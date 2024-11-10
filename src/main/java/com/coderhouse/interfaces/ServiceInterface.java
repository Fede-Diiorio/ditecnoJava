package com.coderhouse.interfaces;

import java.util.List;

public interface ServiceInterface<T> {

	List<T> findAllRegisters();

	T findBySlug(String slug);
}
