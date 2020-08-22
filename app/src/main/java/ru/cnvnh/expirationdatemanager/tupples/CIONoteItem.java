package ru.cnvnh.expirationdatemanager.tupples;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import java.util.Date;

import ru.cnvnh.expirationdatemanager.models.CIOProduct;
import ru.cnvnh.expirationdatemanager.models.CIOSupplier;

public class CIONoteItem extends BaseObservable
{
	/* ****************************************************************************************** *
	 * * FIELDS				    																* *
	 * ****************************************************************************************** */
	
	@NonNull
	@ColumnInfo(name = "id")
	private Long id;
	
	@NonNull
	@ColumnInfo(name = "expire_date")
	private Date expireDate;
	
	@NonNull
	@ColumnInfo(name = "product_id")
	private	Long productId;
	
	@NonNull
	@ColumnInfo(name = "barcode")
	private String barcode;
	
	@Nullable
	@ColumnInfo(name = "code")
	private String code;
	
	@Nullable
	@ColumnInfo(name = "product_name")
	private String productName;
	
	@Nullable
	@ColumnInfo(name = "supplier_id")
	private Long supplierId;
	
	@Nullable
	@ColumnInfo(name = "supplier_name")
	private String supplierName;
	
	/* ****************************************************************************************** *
	 * * CONSTRUCTORS / INSTANCE	    														* *
	 * ****************************************************************************************** */
	
	public CIONoteItem(@NonNull Long id, @NonNull Date expireDate, @NonNull Long productId, @NonNull String barcode, @Nullable String code, @Nullable String productName, @Nullable Long supplierId, @Nullable String supplierName)
	{
		this.id = id;
		this.expireDate = expireDate;
		this.productId = productId;
		this.barcode = barcode;
		this.code = code;
		this.productName = productName;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}
	
	public CIONoteItem(@NonNull Long id, @NonNull Date expireDate, @NonNull CIOProduct product, @Nullable CIOSupplier supplier)
	{
		this.id = id;
		this.expireDate = expireDate;
		this.productId = product.getId();
		this.barcode = product.getBarcode();
		this.code = product.getCode();
		this.productName = product.getName();
		this.supplierId = supplier == null ? null : supplier.getId();
		this.supplierName = supplier == null ? null : supplier.getName();
	}
	
	/* ****************************************************************************************** *
	 * * GETTERS / SETTERS																		* *
	 * ****************************************************************************************** */
	
	@NonNull
	public Long getId()
	{
		return id;
	}
	
	public void setId(@NonNull Long id)
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
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(@Nullable String productName)
	{
		this.productName = productName;
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
	
	@Nullable
	public String getSupplierName()
	{
		return supplierName;
	}
	
	public void setSupplierName(@Nullable String supplierName)
	{
		this.supplierName = supplierName;
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
