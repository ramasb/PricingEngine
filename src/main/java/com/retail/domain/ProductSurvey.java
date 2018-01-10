package com.retail.domain;

import java.util.List;
/**
 * The Class ProductSurvey.
 */
public class ProductSurvey extends Product {
	
	/** The competitor name. */
	private String competitorName;

	/** The price. */
	private Double price;

	/**
	 * Instantiates a new product survey.
	 *
	 * @param productName the product name
	 * @param competitorName the competitor name
	 * @param price the price
	 */
	public ProductSurvey(String productName, String competitorName, Double price) {
		super(productName);
		this.competitorName = competitorName;
		this.price = price;
	}

	/**
	 * Instantiates a new product survey.
	 *
	 * @param details the details
	 */
	public ProductSurvey(List<String> details) {
		this(details.get(0), details.get(1), Double.parseDouble(details.get(2)));
	}

	/**
	 * Gets the competitor name.
	 *
	 * @return the competitorName
	 */
	public String getCompetitorName() {
		return competitorName;
	}

	/**
	 * Sets the competitor name.
	 *
	 * @param competitorName            the competitorName to set
	 */
	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}
