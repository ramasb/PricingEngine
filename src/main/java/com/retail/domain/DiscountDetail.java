package com.retail.domain;
/**
 * The Class DiscountDetail.
 */
public class DiscountDetail {
	
	/** The high. */
	public static String HIGH = "H";
	
	/** The low. */
	public static String LOW = "L";
	
	/** The supply. */
	private String supply;
	
	/** The demand. */
	private String demand;
	
	/** The discount. */
	private Double discount;
	
	/**
	 * Instantiates a new discount detail.
	 *
	 * @param supply the supply
	 * @param demand the demand
	 * @param discount the discount
	 */
	public DiscountDetail(String supply, String demand, Double discount) {
		this.supply = supply;
		this.demand = demand;
		this.discount = discount;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((demand == null) ? 0 : demand.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DiscountDetail)) {
			return false;
		}
		DiscountDetail other = (DiscountDetail) obj;
		if (demand == null) {
			if (other.demand != null) {
				return false;
			}
		} else if (!demand.equals(other.demand)) {
			return false;
		}
		if (supply == null) {
			if (other.supply != null) {
				return false;
			}
		} else if (!supply.equals(other.supply)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}
}
