package ru.cnvnh.expirationdatemanager.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import ru.cnvnh.expirationdatemanager.converters.CIODateConverter;
import ru.cnvnh.expirationdatemanager.daos.CIONoteDao;
import ru.cnvnh.expirationdatemanager.daos.CIOProductDao;
import ru.cnvnh.expirationdatemanager.daos.CIOProductSupplierJoinDao;
import ru.cnvnh.expirationdatemanager.daos.CIOSupplierDao;
import ru.cnvnh.expirationdatemanager.models.CIONote;
import ru.cnvnh.expirationdatemanager.models.CIOProduct;
import ru.cnvnh.expirationdatemanager.models.CIOProductSupplierJoin;
import ru.cnvnh.expirationdatemanager.models.CIOSupplier;

@Database(entities = {CIONote.class, CIOProduct.class, CIOSupplier.class, CIOProductSupplierJoin.class}, exportSchema = false, version = 2)
@TypeConverters({CIODateConverter.class})
public abstract class CIODatabase extends RoomDatabase
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIODatabase";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	private static CIODatabase instance;
	
	public static synchronized CIODatabase getInstance(final Context context)
	{
		if(instance == null)
		{
			instance = Room.databaseBuilder(context, CIODatabase.class, "expiration_date_database").fallbackToDestructiveMigration().build();
		}
		
		return instance;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public abstract CIONoteDao notes();
	public abstract CIOProductDao products();
	public abstract CIOSupplierDao suppliers();
	public abstract CIOProductSupplierJoinDao productSupplierJoins();
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
