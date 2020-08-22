package ru.cnvnh.expirationdatemanager.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "products",
		indices = {@Index(value = "barcode", name = "idx_barcode", unique = true),
				   @Index(value = "name", name = "idx_product_name")})
public class CIOProduct
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private Long id;
	
	@NonNull
	@ColumnInfo(name = "barcode")
	private String barcode;
	
	@Nullable
	@ColumnInfo(name = "code")
	private String code;
	
	@Nullable
	@ColumnInfo(name = "name")
	private String name;
	
	@Nullable
	@ColumnInfo(name = "storage_period")
	private Date storagePeriod;
	
	@Nullable
	@ColumnInfo(name = "storage_period_unit")
	private Integer storagePeriodUnit;
	
	@Nullable
	@ColumnInfo(name = "favorite_supplier_id")
	private Long favoriteSupplierId;
	
	@NonNull
	@ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
	private Date createdAt;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	public CIOProduct(@NonNull String barcode, @Nullable String code, @Nullable String name, @Nullable Date storagePeriod, @Nullable Integer storagePeriodUnit, @Nullable Long favoriteSupplierId)
	{
		this.barcode = barcode;
		this.code = code;
		this.name = name;
		this.storagePeriod = storagePeriod;
		this.storagePeriodUnit = storagePeriodUnit;
		this.favoriteSupplierId = favoriteSupplierId;
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
	public String getBarcode()
	{
		return barcode;
	}
	
	public void setBarcode(@NonNull String barcode)
	{
		this.barcode = barcode;
	}
	
	@Nullable
	public String getCode()
	{
		return code;
	}
	
	public void setCode(@Nullable String code)
	{
		this.code = code;
	}
	
	@Nullable
	public String getName()
	{
		return name;
	}
	
	public void setName(@Nullable String name)
	{
		this.name = name;
	}
	
	@Nullable
	public Date getStoragePeriod()
	{
		return storagePeriod;
	}
	
	public void setStoragePeriod(@Nullable Date storagePeriod)
	{
		this.storagePeriod = storagePeriod;
	}
	
	@Nullable
	public Integer getStoragePeriodUnit()
	{
		return storagePeriodUnit;
	}
	
	public void setStoragePeriodUnit(@Nullable Integer storagePeriodUnit)
	{
		this.storagePeriodUnit = storagePeriodUnit;
	}
	
	@Nullable
	public Long getFavoriteSupplierId()
	{
		return favoriteSupplierId;
	}
	
	public void setFavoriteSupplierId(@Nullable Long favoriteSupplierId)
	{
		this.favoriteSupplierId = favoriteSupplierId;
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
