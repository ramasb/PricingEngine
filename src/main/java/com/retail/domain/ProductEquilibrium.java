package com.retail.domain;

import java.util.List;
/**
 * The Class ProductEquilibrium.
 */
public class ProductEquilibrium extends Product {

	/** The supply. */
	private String supply;

	/** The demand. */
	private String demand;

	/**
	 * Instantiates a new product equilibrium.
	 *
	 * @param productName the product name
	 * @param supply the supply
	 * @param demand the demand
	 */
	public ProductEquilibrium(String productName, String supply, String demand) {
		super(productName);
		this.supply = supply;
		this.demand = demand;
	}

	/**
	 * Instantiates a new product equilibrium.
	 *
	 * @param details the details
	 */
	public ProductEquilibrium(List<String> details) {
		this(details.get(0), details.get(1), details.get(2));
	}

	/**
	 * Gets the supply.
	 *
	 * @return the supply
	 */
	public String getSupply() {
		return supply;
	}

	/**
	 * Sets the supply.
	 *
	 * @param supply            the supply to set
	 */
	public void setSupply(String supply) {
		this.supply = supply;
	}

	/**
	 * Gets the demand.
	 *
	 * @return the demand
	 */
	public String getDemand() {
		return demand;
	}

	/**
	 * Sets the demand.
	 *
	 * @param demand            the demand to set
	 */
	public void setDemand(String demand) {
		this.demand = demand;
	}

}
