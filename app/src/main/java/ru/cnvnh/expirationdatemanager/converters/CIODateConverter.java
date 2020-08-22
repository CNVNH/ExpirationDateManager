package ru.cnvnh.expirationdatemanager.converters;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.InverseMethod;
import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CIODateConverter
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	private static final String TAG = "CIODateConverter";
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	@TypeConverter
	public static Date timestampToDate(@Nullable Long timestamp)
	{
		return timestamp == null ? null : new Date(timestamp);
	}
	
	@TypeConverter
	public static String timestampToString(@Nullable Long timestamp)
	{
		return timestamp == null ? null : (new SimpleDateFormat("dd.MM.yyyy", Locale.US)).format(new Date(timestamp));
	}
	
	@TypeConverter
	public static Long dateToTimestamp(@Nullable Date date)
	{
		return date == null ? null : date.getTime();
	}
	
	@InverseMethod("dateToString")
	public static String dateToString(Date date)
	{
		return (new SimpleDateFormat("dd.MM.yyyy", Locale.US)).format(date);
	}
	
	public static Date stringToDate(String value)
	{
		Date date;
		
		try
		{
			date = (new SimpleDateFormat("dd.MM.yyyy", Locale.US)).parse(value);
		}
		catch(ParseException e)
		{
			return new Date(0L);
		}
		
		return date;
	}
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
