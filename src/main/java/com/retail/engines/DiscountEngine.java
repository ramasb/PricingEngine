package com.retail.engines;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.retail.domain.DiscountDetail;

/**
 * The Class DiscountEngine.
 */
public class DiscountEngine {

	/** The instance. */
	private static DiscountEngine INSTANCE;

	/** The discount rules. */
	private List<DiscountDetail> discountRules;

	/**
	 * Instantiates a new discount engine.
	 */
	private DiscountEngine() {
		loadDiscountRules();
	}

	/**
	 * Load discount rules.
	 */
	private void loadDiscountRules() {
		discountRules = new CopyOnWriteArrayList<DiscountDetail>();
		// If Supply is High and Demand is High, Product is sold at same price as chosen
		// price.
		discountRules.add(new DiscountDetail(DiscountDetail.HIGH, DiscountDetail.HIGH, 0.0));
		// If Supply is Low and Demand is Low, Product is sold at 10 % more than chosen
		// price.
		discountRules.add(new DiscountDetail(DiscountDetail.LOW, DiscountDetail.LOW, 0.1));
		// If Supply is Low and Demand is High, Product is sold at 5 % more than chosen
		// price.
		discountRules.add(new DiscountDetail(DiscountDetail.LOW, DiscountDetail.HIGH, 0.05));
		// If Supply is High and Demand is Low, Product is sold at 5 % less than chosen
		// price.
		discountRules.add(new DiscountDetail(DiscountDetail.HIGH, DiscountDetail.LOW, -0.05));
	}

	/**
	 * Gets the single instance of DiscountEngine.
	 *
	 * @return single instance of DiscountEngine
	 */
	public static DiscountEngine getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DiscountEngine();
		}
		return INSTANCE;
	}

	/**
	 * Return the discount price based on supply and demand.
	 *
	 * @param supply
	 *            the supply
	 * @param demand
	 *            the demand
	 * @return discount
	 */
	public Double getDiscount(String supply, String demand) {
		return getDiscount(new DiscountDetail(supply, demand, 0.0));
	}

	/**
	 * Return the discount price based on supply and demand in DiscountDetail.
	 *
	 * @param discountD
	 *            - DiscountDetail
	 * @return discount
	 */
	public Double getDiscount(DiscountDetail discountD) {
		DiscountDetail discountDetail = discountRules.get(discountRules.indexOf(discountD));
		return discountDetail == null ? 0.0 : discountDetail.getDiscount();
	}
}
