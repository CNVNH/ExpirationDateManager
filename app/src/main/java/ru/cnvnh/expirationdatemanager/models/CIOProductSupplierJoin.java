package ru.cnvnh.expirationdatemanager.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "product_supplier_join",
		primaryKeys = {"product_id", "supplier_id"},
		indices = {@Index(value = "supplier_id", name = "idx_supplier_id")},
		foreignKeys = {@ForeignKey(entity = CIOProduct.class, parentColumns = "id", childColumns = "product_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
					   @ForeignKey(entity = CIOSupplier.class, parentColumns = "id", childColumns = "supplier_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class CIOProductSupplierJoin
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	@NonNull
	@ColumnInfo(name = "product_id")
	private Long product_id;
	
	@NonNull
	@ColumnInfo(name = "supplier_id", index = true)
	private Long supplier_id;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	public CIOProductSupplierJoin(@NonNull Long product_id, @NonNull Long supplier_id)
	{
		this.product_id = product_id;
		this.supplier_id = supplier_id;
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	@NonNull
	public Long getProduct_id()
	{
		return product_id;
	}
	
	public void setProduct_id(@NonNull Long product_id)
	{
		this.product_id = product_id;
	}
	
	@NonNull
	public Long getSupplier_id()
	{
		return supplier_id;
	}
	
	public void setSupplier_id(@NonNull Long supplier_id)
	{
		this.supplier_id = supplier_id;
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
