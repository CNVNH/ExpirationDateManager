package ru.cnvnh.expirationdatemanager.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.cnvnh.expirationdatemanager.models.CIOSupplier;

@Dao
public interface CIOSupplierDao
{
	@Insert
	Long insert(final CIOSupplier supplier);
	
	@Insert
	List<Long> insert(final List<CIOSupplier> suppliers);
	
	@Update
	int update(final CIOSupplier supplier);
	
	@Update
	int update(final List<CIOSupplier> suppliers);
	
	@Delete
	int delete(final CIOSupplier supplier);
	
	@Delete
	int delete(final List<CIOSupplier> suppliers);
	
	@Query("DELETE FROM suppliers")
	int deleteAll();
}
