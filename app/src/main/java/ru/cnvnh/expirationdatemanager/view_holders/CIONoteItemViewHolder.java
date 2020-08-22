package ru.cnvnh.expirationdatemanager.view_holders;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import ru.cnvnh.expirationdatemanager.BR;
import ru.cnvnh.expirationdatemanager.view_models.CIONotesViewModel;

public class CIONoteItemViewHolder extends RecyclerView.ViewHolder
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIONoteItemViewHolder";
	
	private ViewDataBinding binding;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	public CIONoteItemViewHolder(@NonNull ViewDataBinding binding)
	{
		super(binding.getRoot());
		
		this.binding = binding;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public void bind(CIONotesViewModel viewModel, int pos, boolean showDate, boolean showSupplier)
	{
		binding.setVariable(BR.viewModel, viewModel);
		binding.setVariable(BR.pos, pos);
		binding.setVariable(BR.showDate, showDate);
		binding.setVariable(BR.showSupplier, showSupplier);
		binding.executePendingBindings();
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
