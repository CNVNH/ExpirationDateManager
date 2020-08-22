package ru.cnvnh.expirationdatemanager.repos;

import android.content.Context;

import java.util.concurrent.Executors;

import ru.cnvnh.expirationdatemanager.databases.CIODatabase;
import ru.cnvnh.expirationdatemanager.models.CIOProductSupplierJoin;

public class CIOProductSupplierJoinRepo
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIOProductSupplierJoinRepo";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	private static CIOProductSupplierJoinRepo instance;
	
	public static CIOProductSupplierJoinRepo getInstance()
	{
		if(instance == null)
		{
			instance = new CIOProductSupplierJoinRepo();
		}
		
		return instance;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void insert(final Context context, final CIOProductSupplierJoin productSupplierJoin)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				CIODatabase.getInstance(context).productSupplierJoins().insert(productSupplierJoin);
			}
		});
	}
	
	public void delete(final Context context, final CIOProductSupplierJoin productSupplierJoin)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).productSupplierJoins().delete(productSupplierJoin);
			}
		});
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
