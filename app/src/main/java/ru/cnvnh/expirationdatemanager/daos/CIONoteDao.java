package ru.cnvnh.expirationdatemanager.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.cnvnh.expirationdatemanager.models.CIONote;
import ru.cnvnh.expirationdatemanager.tupples.CIONoteItem;

@Dao
public interface CIONoteDao
{
	@Insert
	Long insert(final CIONote note);
	
	@Insert
	List<Long> insert(final List<CIONote> notes);
	
	@Update
	int update(final CIONote note);
	
	@Update
	int update(final List<CIONote> notes);
	
	@Delete
	int delete(final CIONote note);
	
	@Delete
	int delete(final List<CIONote> notes);
	
	@Query("DELETE FROM notes WHERE id IN (:notesIds)")
	int deleteByIds(final List<Long> notesIds);
	
	@Query("SELECT notes.id, notes.expire_date, notes.product_id, products.barcode, products.code, products.name AS product_name, notes.supplier_id, suppliers.name AS supplier_name FROM notes INNER JOIN products ON notes.product_id = products.id LEFT JOIN suppliers ON notes.supplier_id = suppliers.id ORDER BY notes.expire_date ASC, notes.supplier_id ASC")
	LiveData<List<CIONoteItem>> getAll();
}
