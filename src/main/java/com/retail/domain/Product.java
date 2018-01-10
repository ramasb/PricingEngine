package com.retail.domain;

/**
 * The Class Product.
 */
public class Product {

	/** The product name. */
	private String productName;

	/**
	 * Instantiates a new product.
	 *
	 * @param productName
	 *            the product name
	 */
	public Product(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.toLowerCase().hashCode());
		return result;
	}

	/**
	 * Check whether product name is equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Product other = (Product) obj;
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equalsIgnoreCase(other.productName)) {
			return false;
		}
		return true;
	}
}
