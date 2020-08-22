package ru.cnvnh.expirationdatemanager.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "suppliers",
		indices = {@Index(value = "name", name = "idx_supplier_name", unique = true)})
public class CIOSupplier
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private Long id;
	
	@NonNull
	@ColumnInfo(name = "name")
	private String name;
	
	@Nullable
	@ColumnInfo(name = "notify_in")
	private Date notifyIn;
	
	@Nullable
	@ColumnInfo(name = "notify_in_unit")
	private Integer notifyInUnit;
	
	@NonNull
	@ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
	private Date createdAt;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	public CIOSupplier(@NonNull String name, @Nullable Date notifyIn, @Nullable Integer notifyInUnit)
	{
		this.name = name;
		this.notifyIn = notifyIn;
		this.notifyInUnit = notifyInUnit;
		this.createdAt = Calendar.getInstance().getTime();
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@NonNull
	public String getName()
	{
		return name;
	}
	
	public void setName(@NonNull String name)
	{
		this.name = name;
	}
	
	@Nullable
	public Date getNotifyIn()
	{
		return notifyIn;
	}
	
	public void setNotifyIn(@Nullable Date notifyIn)
	{
		this.notifyIn = notifyIn;
	}
	
	@Nullable
	public Integer getNotifyInUnit()
	{
		return notifyInUnit;
	}
	
	public void setNotifyInUnit(@Nullable Integer notifyInUnit)
	{
		this.notifyInUnit = notifyInUnit;
	}
	
	public Date getCreatedAt()
	{
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}
	
	/* ****************************************************************************************** *
	 * * METHODS																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * LIFECYCLE																				* *
	 * ****************************************************************************************** */
	
	/* ****************************************************************************************** *
	 * * CALLBACKS																				* *
	 * ****************************************************************************************** */
}
