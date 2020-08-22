package ru.cnvnh.expirationdatemanager.views.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import ru.cnvnh.expirationdatemanager.R;

public class CIOMainActivity extends AppCompatActivity
{
	/* ****************************************************************************************** *
	 * * FIELDS																					* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIOMainActivity";
	
	private Toolbar toolbar;
	
	private DrawerLayout drawer;
	private NavigationView nav;
	
	private NavController navController;
	private AppBarConfiguration appBarConfiguration;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	public NavController getNavController()
	{
		return navController;
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cio_activity_main);
		
		toolbar = findViewById(R.id.cio_toolbar);
		setSupportActionBar(toolbar);
		
		drawer = findViewById(R.id.cio_drawer);
		nav = findViewById(R.id.cio_nav);
		
		navController = Navigation.findNavController(this, R.id.cio_fragment_container);
		appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawer).build();
		
		NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(nav, navController);
	}
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
