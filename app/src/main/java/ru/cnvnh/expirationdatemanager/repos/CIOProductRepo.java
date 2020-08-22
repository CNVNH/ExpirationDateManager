package ru.cnvnh.expirationdatemanager.repos;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import ru.cnvnh.expirationdatemanager.databases.CIODatabase;
import ru.cnvnh.expirationdatemanager.models.CIOProduct;

public class CIOProductRepo
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIOProductRepo";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	private static CIOProductRepo instance;
	
	public static CIOProductRepo getInstance()
	{
		if(instance == null)
		{
			instance = new CIOProductRepo();
		}
		
		return instance;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void insert(final Context context, final CIOProduct product)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				Long id = CIODatabase.getInstance(context).products().insert(product);
			}
		});
	}
	
	public void insert(final Context context, final List<CIOProduct> products, final OnProductsAddedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				List<Long> ids = CIODatabase.getInstance(context).products().insert(products);
				
				callback.onProductsAdded(ids);
			}
		});
	}
	
	public void insertSomeProducts(final Context context, final OnProductsAddedListener callback)
	{
		List<CIOProduct> products = new ArrayList<>();
		
		Calendar c = Calendar.getInstance();
		c.setLenient(true);
		
		c.setTime(new Date(0L));
		c.add(Calendar.MONTH, 12);
		products.add(new CIOProduct("0000000000000", "000000000", "Coffee", c.getTime(), 2, null));
		
		c.setTime(new Date(0L));
		c.add(Calendar.MONTH, 1);
		products.add(new CIOProduct("1111111111111", "111111111", "Cream", c.getTime(), 2, null));
		
		c.setTime(new Date(0L));
		c.add(Calendar.MONTH, 12);
		products.add(new CIOProduct("2222222222222", "222222222", "Sugar", c.getTime(), 2, null));
		
		c.setTime(new Date(0L));
		c.add(Calendar.DAY_OF_MONTH, 3);
		products.add(new CIOProduct("3333333333333", "333333333", "Pasta", c.getTime(), 1, null));
		
		c.setTime(new Date(0L));
		c.add(Calendar.HOUR, 72);
		products.add(new CIOProduct("4444444444444", "444444444", "Bread", c.getTime(), 0, null));
		
		insert(context, products, callback);
	}
	
	public void update(final Context context, final CIOProduct product)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).products().update(product);
			}
		});
	}
	
	public void update(final Context context, final List<CIOProduct> products)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).products().update(products);
			}
		});
	}
	
	public void delete(final Context context, final CIOProduct product)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).products().delete(product);
			}
		});
	}
	
	public void delete(final Context context, final List<CIOProduct> products)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).products().delete(products);
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
				int count = CIODatabase.getInstance(context).products().deleteAll();
			}
		});
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	public interface OnProductsAddedListener
	{
		void onProductsAdded(final List<Long> ids);
	}
}
