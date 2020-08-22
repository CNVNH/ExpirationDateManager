package ru.cnvnh.expirationdatemanager.repos;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import ru.cnvnh.expirationdatemanager.databases.CIODatabase;
import ru.cnvnh.expirationdatemanager.models.CIONote;
import ru.cnvnh.expirationdatemanager.tupples.CIONoteItem;

public class CIONoteRepo
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIONoteRepo";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	private static CIONoteRepo instance;
	
	public static CIONoteRepo getInstance()
	{
		if(instance == null)
		{
			instance = new CIONoteRepo();
		}
		
		return instance;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void insert(final Context context, final CIONote note, @Nullable final OnNotesAddedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				Long id = CIODatabase.getInstance(context).notes().insert(note);
			}
		});
	}
	
	public void insert(final Context context, final List<CIONote> notes, @Nullable final OnNotesAddedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				List<Long> ids = CIODatabase.getInstance(context).notes().insert(notes);
				
				if(callback != null)
				{
					callback.onNotesAdded(ids);
				}
			}
		});
	}
	
	public void insertSomeNotes(final Context context, final List<Long> productIds, final List<Long> supplierIds, @Nullable final OnNotesAddedListener callback)
	{
		List<CIONote> notes = new ArrayList<>();
		
		Calendar c = Calendar.getInstance();
		c.setLenient(true);
		
		notes.add(new CIONote(c.getTime(), productIds.get(0), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(1), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(3), supplierIds.get(1)));
		notes.add(new CIONote(c.getTime(), productIds.get(4), supplierIds.get(1)));
		notes.add(new CIONote(c.getTime(), productIds.get(2), null));
		
		c.add(Calendar.DAY_OF_MONTH, 1);
		notes.add(new CIONote(c.getTime(), productIds.get(0), supplierIds.get(0)));
		
		c.add(Calendar.DAY_OF_MONTH, 1);
		notes.add(new CIONote(c.getTime(), productIds.get(4), null));
		notes.add(new CIONote(c.getTime(), productIds.get(3), null));
		
		c.add(Calendar.DAY_OF_MONTH, 1);
		notes.add(new CIONote(c.getTime(), productIds.get(0), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(1), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(2), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(3), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(4), supplierIds.get(0)));
		notes.add(new CIONote(c.getTime(), productIds.get(0), supplierIds.get(1)));
		notes.add(new CIONote(c.getTime(), productIds.get(1), supplierIds.get(1)));
		notes.add(new CIONote(c.getTime(), productIds.get(2), supplierIds.get(1)));
		notes.add(new CIONote(c.getTime(), productIds.get(3), supplierIds.get(2)));
		notes.add(new CIONote(c.getTime(), productIds.get(4), supplierIds.get(2)));
		
		insert(context, notes, callback);
	}
	
	public void update(final Context context, final CIONote note)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).notes().update(note);
			}
		});
	}
	
	public void update(final Context context, final List<CIONote> notes)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).notes().update(notes);
			}
		});
	}
	
	public void delete(final Context context, final CIONote note, @Nullable final OnNotesDeletedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).notes().delete(note);
			}
		});
	}
	
	public void delete(final Context context, final List<CIONote> notes, @Nullable final OnNotesDeletedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).notes().delete(notes);
			}
		});
	}
	
	public void deleteByIds(final Context context, final List<Long> notesIds, @Nullable final OnNotesDeletedListener callback)
	{
		Executors.newSingleThreadExecutor().execute(new Runnable()
		{
			@Override
			public void run()
			{
				int count = CIODatabase.getInstance(context).notes().deleteByIds(notesIds);
				
				if(callback != null)
				{
					callback.onNotesDeleted(count);
				}
			}
		});
	}
	
	public LiveData<List<CIONoteItem>> getAll(final Context context)
	{
		return CIODatabase.getInstance(context).notes().getAll();
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	public interface OnNotesAddedListener
	{
		void onNotesAdded(List<Long> ids);
	}
	
	public interface  OnNotesDeletedListener
	{
		void onNotesDeleted(int count);
	}
}
