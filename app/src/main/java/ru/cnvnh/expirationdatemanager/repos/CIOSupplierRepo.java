package ru.cnvnh.expirationdatemanager.repos;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import ru.cnvnh.expirationdatemanager.databases.CIODatabase;
import ru.cnvnh.expirationdatemanager.models.CIOSupplier;

public class CIOSupplierRepo
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIOSupplierRepo";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	private static CIOSupplierRepo instance;
	
	public static CIOSupplierRepo getInstance()
	{
		if(instance == null)
		{
			instance = new CIOSupplierRepo();
		}
		
		return instance;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void insert(final Context context, final CIOSupplier supplier)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				Long id = CIODatabase.getInstance(context).suppliers().insert(supplier);
			}
		});
	}
	
	public void insert(final Context context, final List<CIOSupplier> suppliers, final OnSuppliersAddedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				List<Long> ids = CIODatabase.getInstance(context).suppliers().insert(suppliers);
				
				callback.onSuppliersAdded(ids);
			}
		});
	}
	
	public void insertSomeSuppliers(final Context context, final OnSuppliersAddedListener callback)
	{
		List<CIOSupplier> suppliers = new ArrayList<>();
		
		Calendar c = Calendar.getInstance();
		c.setLenient(true);
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 7);
		suppliers.add(new CIOSupplier("OOO North Star", c.getTime(), 1));
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 7);
		suppliers.add(new CIOSupplier("OOO Artek", c.getTime(), 1));
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 14);
		suppliers.add(new CIOSupplier("IP Ivanov", c.getTime(), 1));
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 14);
		suppliers.add(new CIOSupplier("OAO Vladivostok 2000", c.getTime(), 1));
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 7);
		suppliers.add(new CIOSupplier("OOO Zea", c.getTime(), 1));
		
		insert(context, suppliers, callback);
	}
	
	public void update(final Context context, final CIOSupplier supplier)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).suppliers().update(supplier);
			}
		});
	}
	
	public void update(final Context context, final List<CIOSupplier> suppliers)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).suppliers().update(suppliers);
			}
		});
	}
	
	public void delete(final Context context, final CIOSupplier supplier)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).suppliers().delete(supplier);
			}
		});
	}
	
	public void delete(final Context context, final List<CIOSupplier> suppliers)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).suppliers().delete(suppliers);
			}
		});
	}
	
	public void deleteAll(final Context context)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).suppliers().deleteAll();
			}
		});
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	public interface OnSuppliersAddedListener
	{
		void onSuppliersAdded(final List<Long> ids);
	}
}
