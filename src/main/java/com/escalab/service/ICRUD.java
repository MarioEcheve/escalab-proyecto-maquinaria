package com.escalab.service;
import java.util.List;

public interface ICRUD<T>{
	
	T save(T obj);
	T update(T obj);
	List<T> list();
	T findById(Integer id);
	boolean delete(Integer id);
}
