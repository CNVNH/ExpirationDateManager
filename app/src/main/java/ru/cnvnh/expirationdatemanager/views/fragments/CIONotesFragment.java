package ru.cnvnh.expirationdatemanager.views.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import ru.cnvnh.expirationdatemanager.R;
import ru.cnvnh.expirationdatemanager.databinding.CioFragmentNotesBinding;
import ru.cnvnh.expirationdatemanager.tupples.CIONoteItem;
import ru.cnvnh.expirationdatemanager.view_models.CIONotesViewModel;

public class CIONotesFragment extends CIOBaseFragment
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIONotesFragment";
	
	private CioFragmentNotesBinding binding;
	private CIONotesViewModel viewModel;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		binding = DataBindingUtil.inflate(inflater, R.layout.cio_fragment_notes, container, false);
		viewModel = ViewModelProviders.of(this).get(CIONotesViewModel.class);
		
		binding.setViewModel(viewModel);
		binding.setLifecycleOwner(this);
		
		return binding.getRoot();
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		
		if(savedInstanceState == null)
		{
			viewModel.init();
		}
		
		viewModel.getNotes().observe(getViewLifecycleOwner(), notesObserver);
		viewModel.getSelectedNotesIds().observe(getViewLifecycleOwner(), selectedNotesObserver);
		viewModel.getInSelectionMode().observe(getViewLifecycleOwner(), inSelectionModeObserver);
	}
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
	
	private Observer<List<CIONoteItem>> notesObserver = new Observer<List<CIONoteItem>>()
	{
		@Override
		public void onChanged(List<CIONoteItem> notes)
		{
			viewModel.getNotesAdapter().setNotes(notes);
			viewModel.getNotesAdapter().notifyDataSetChanged();
		}
	};
	
	private Observer<List<Long>> selectedNotesObserver = new Observer<List<Long>>()
	{
		@Override
		public void onChanged(List<Long> ids)
		{
			Log.d(TAG, "onChanged: ");
		}
	};
	
	private  Observer<Boolean> inSelectionModeObserver = new Observer<Boolean>()
	{
		@Override
		public void onChanged(Boolean inSelectionMode)
		{
			Log.d(TAG, "onChanged: ");
		}
	};
}
