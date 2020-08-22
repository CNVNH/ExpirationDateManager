package ru.cnvnh.expirationdatemanager.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.cnvnh.expirationdatemanager.R;
import ru.cnvnh.expirationdatemanager.tupples.CIONoteItem;
import ru.cnvnh.expirationdatemanager.view_holders.CIONoteItemViewHolder;
import ru.cnvnh.expirationdatemanager.view_models.CIONotesViewModel;

public class CIONotesAdapter extends RecyclerView.Adapter<CIONoteItemViewHolder>
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIONotesAdapter";
	
	private List<CIONoteItem> notes;
	private CIONotesViewModel viewModel;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	public CIONotesAdapter(CIONotesViewModel viewModel)
	{
		this.viewModel = viewModel;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	@Override
	public int getItemCount()
	{
		return notes == null ? 0 : notes.size();
	}
	
	public void setNotes(List<CIONoteItem> notes)
	{
		this.notes = notes;
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	@NonNull
	@Override
	public CIONoteItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		return new CIONoteItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cio_adapter_item_note, parent, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull CIONoteItemViewHolder holder, int pos)
	{
		boolean showDate = false;
		boolean showSupplier = false;
		
		if(pos == 0 || (notes.get(pos).getExpireDate().compareTo(notes.get(pos - 1).getExpireDate()) != 0))
		{
			showDate = true;
			showSupplier = true;
		}
		else
		{
			Long cId = notes.get(pos).getSupplierId();
			Long pId = notes.get(pos - 1).getSupplierId();
			
			if((cId == null && pId != null) || (cId != null && pId == null) || (cId != null && !cId.equals(pId)))
			{
				showSupplier = true;
			}
		}
		
		holder.bind(viewModel, pos, showDate, showSupplier);
	}
}