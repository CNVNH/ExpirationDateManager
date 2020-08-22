package ru.cnvnh.expirationdatemanager.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "notes",
		indices = {@Index(value = {"product_id", "supplier_id", "expire_date"}, name = "idx_note", unique = true)},
		foreignKeys = {@ForeignKey(entity = CIOProduct.class, parentColumns = "id", childColumns = "product_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
					   @ForeignKey(entity = CIOSupplier.class, parentColumns = "id", childColumns = "supplier_id", onDelete = ForeignKey.SET_DEFAULT, onUpdate = ForeignKey.CASCADE)})
public class CIONote
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private Long id;
	
	@NonNull
	@ColumnInfo(name = "expire_date", index = true)
	private Date expireDate;
	
	@NonNull
	@ColumnInfo(name = "product_id", index = true)
	private Long productId;
	
	@Nullable
	@ColumnInfo(name = "supplier_id", index = true, defaultValue = "NULL")
	private Long supplierId;
	
	@NonNull
	@ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
	private Date createdAt;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE																* *
	 * ****************************************************************************************** */
	
	public CIONote(@NonNull Date expireDate, @NonNull Long productId, @Nullable Long supplierId)
	{
		this.expireDate = expireDate;
		this.productId = productId;
		this.supplierId = supplierId;
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
	public Date getExpireDate()
	{
		return expireDate;
	}
	
	public void setExpireDate(@NonNull Date expireDate)
	{
		this.expireDate = expireDate;
	}
	
	@NonNull
	public Long getProductId()
	{
		return productId;
	}
	
	public void setProductId(@NonNull Long productId)
	{
		this.productId = productId;
	}
	
	@Nullable
	public Long getSupplierId()
	{
		return supplierId;
	}
	
	public void setSupplierId(@Nullable Long supplierId)
	{
		this.supplierId = supplierId;
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
