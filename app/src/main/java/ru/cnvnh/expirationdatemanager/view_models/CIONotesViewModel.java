package ru.cnvnh.expirationdatemanager.view_models;

import android.app.Application;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ru.cnvnh.expirationdatemanager.adapters.CIONotesAdapter;
import ru.cnvnh.expirationdatemanager.repos.CIONoteRepo;
import ru.cnvnh.expirationdatemanager.repos.CIOProductRepo;
import ru.cnvnh.expirationdatemanager.repos.CIOSupplierRepo;
import ru.cnvnh.expirationdatemanager.tupples.CIONoteItem;

public class CIONotesViewModel extends AndroidViewModel implements CIOSupplierRepo.OnSuppliersAddedListener, CIOProductRepo.OnProductsAddedListener, CIONoteRepo.OnNotesAddedListener, CIONoteRepo.OnNotesDeletedListener
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIONotesViewModel";
	
	private CIONotesAdapter notesAdapter;
	private LiveData<List<CIONoteItem>> notes;
	private LiveData<List<Long>> selectedNotesIds;
	
	private MutableLiveData<Boolean> inSelectionMode;
	
	private List<Long> supplierIds;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	public CIONotesViewModel(@NonNull Application application)
	{
		super(application);
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	public CIONotesAdapter getNotesAdapter()
	{
		return notesAdapter;
	}
	
	public LiveData<List<CIONoteItem>> getNotes()
	{
		return notes;
	}
	
	public LiveData<List<Long>> getSelectedNotesIds()
	{
		return selectedNotesIds;
	}
	
	public void setSelectedNotesIds(LiveData<List<Long>> selectedNotesIds)
	{
		this.selectedNotesIds = selectedNotesIds;
	}
	
	public MutableLiveData<Boolean> getInSelectionMode()
	{
		return inSelectionMode;
	}
	
	public void setInSelectionMode(MutableLiveData<Boolean> inSelectionMode)
	{
		this.inSelectionMode = inSelectionMode;
	}
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void init()
	{
		notesAdapter = new CIONotesAdapter(this);
		notes = CIONoteRepo.getInstance().getAll(getApplication().getApplicationContext());
		
		List<Long> selectedNotesIdsList = new ArrayList<>();
		selectedNotesIds = new MutableLiveData<>(selectedNotesIdsList);
		
		inSelectionMode = new MutableLiveData<>(false);
	}
	
	public CIONoteItem getNote(int pos)
	{
		if(notes.getValue() != null && pos < notes.getValue().size())
		{
			return notes.getValue().get(pos);
		}
		
		return null;
	}
	
	private boolean isInSelectionMode()
	{
		return inSelectionMode.getValue() != null && inSelectionMode.getValue();
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	public void onAddButtonClicked()
	{
		CIOSupplierRepo.getInstance().deleteAll(getApplication().getApplicationContext());
		CIOProductRepo.getInstance().deleteAll(getApplication().getApplicationContext());
		
		CIOSupplierRepo.getInstance().insertSomeSuppliers(getApplication().getApplicationContext(), this);
	}
	
	public void onDeleteButtonClicked()
	{
		inSelectionMode.setValue(false);
		
		if(selectedNotesIds.getValue() != null && selectedNotesIds.getValue().size() > 0)
		{
			CIONoteRepo.getInstance().deleteByIds(getApplication().getApplicationContext(), selectedNotesIds.getValue(), this);
		}
	}
	
	public void onSupplierClicked(int pos)
	{
		if(isInSelectionMode())
		{
			// TODO: 22 / 08 / 2020 Add same date supplier notes to selected
		}
		else
		{
			// TODO: 22 / 08 / 2020 Open edit supplier fragment
		}
	}
	
	public boolean onSupplierLongClicked(int pos)
	{
		if(!isInSelectionMode())
		{
			inSelectionMode.setValue(true);
			
			// TODO: 22 / 08 / 2020 Add same date supplier notes to selected
		}
		
		return true;
	}
	
	public void onProductClicked(int pos)
	{
		Log.d(TAG, "onProductClicked: ");
		
		if(isInSelectionMode())
		{
			// TODO: 22 / 08 / 2020 Toggle selection
		}
		else
		{
			// TODO: 22 / 08 / 2020 Open edit note fragment
		}
	}
	
	public boolean onProductLongClicked(int pos)
	{
		Log.d(TAG, "onProductLongClicked: ");
		
		if(!isInSelectionMode())
		{
			Log.d(TAG, "onProductLongClicked: !inSelectionMode");
			
			inSelectionMode.setValue(true);
			
			// TODO: 22 / 08 / 2020 Toggle selection
		}
		
		return true;
	}
	
	@Override
	public void onSuppliersAdded(List<Long> ids)
	{
		supplierIds = ids;
		
		CIOProductRepo.getInstance().insertSomeProducts(getApplication().getApplicationContext(), this);
	}
	
	@Override
	public void onProductsAdded(List<Long> ids)
	{
		CIONoteRepo.getInstance().insertSomeNotes(getApplication().getApplicationContext(), ids, supplierIds, this);
	}
	
	@Override
	public void onNotesAdded(List<Long> ids)
	{
		Looper.prepare();
		
		Toast.makeText(getApplication().getApplicationContext(), ids.size() + " notes added", Toast.LENGTH_SHORT).show();
		
		Looper.loop();
	}
	
	@Override
	public void onNotesDeleted(int count)
	{
		Looper.prepare();
		
		Toast.makeText(getApplication().getApplicationContext(), count + " notes deleted", Toast.LENGTH_SHORT).show();
		
		Looper.loop();
	}
}
