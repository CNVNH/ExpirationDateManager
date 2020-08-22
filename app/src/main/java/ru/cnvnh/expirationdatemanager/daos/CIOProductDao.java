package ru.cnvnh.expirationdatemanager.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.cnvnh.expirationdatemanager.models.CIOProduct;

@Dao
public interface CIOProductDao
{
	@Insert
	Long insert(final CIOProduct product);
	
	@Insert
	List<Long> insert(final List<CIOProduct> products);
	
	@Update
	int update(final CIOProduct product);
	
	@Update
	int update(final List<CIOProduct> products);
	
	@Delete
	int delete(final CIOProduct product);
	
	@Delete
	int delete(final List<CIOProduct> products);
	
	@Query("DELETE FROM products")
	int deleteAll();
}
