package ru.cnvnh.expirationdatemanager.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import ru.cnvnh.expirationdatemanager.models.CIOProductSupplierJoin;

@Dao
public interface CIOProductSupplierJoinDao
{
	@Insert
	void insert(final CIOProductSupplierJoin productSupplierJoin);
	
	@Delete
	int delete(final CIOProductSupplierJoin productSupplierJoin);
}
