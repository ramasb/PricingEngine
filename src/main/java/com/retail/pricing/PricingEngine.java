package com.retail.pricing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.TreeMap;

import com.retail.domain.ProductEquilibrium;
import com.retail.domain.ProductSurvey;
import static com.retail.engines.DiscountEngine.getInstance;

/**
 * The Class PricingEngine.
 */
public class PricingEngine {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			calculateDiscounts(retrieveProducts(), retrieveSurveys());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Retrieve products.
	 *
	 * @return the list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static List<ProductEquilibrium> retrieveProducts() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<ProductEquilibrium> products = new ArrayList<ProductEquilibrium>();
		int noOfProducts = Integer.parseInt(br.readLine());
		String thisLine = null;
		while (noOfProducts-- > 0 && (thisLine = br.readLine()) != null) {
			products.add(new ProductEquilibrium(Arrays.asList(thisLine.split(" "))));
		}
		return products;
	}

	/**
	 * Retrieve surveys.
	 *
	 * @return the list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static List<ProductSurvey> retrieveSurveys() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<ProductSurvey> surveys = new ArrayList<ProductSurvey>();
		int noOfSurveys = Integer.parseInt(br.readLine());
		String thisLine = null;
		while (noOfSurveys-- > 0 && (thisLine = br.readLine()) != null) {
			surveys.add(new ProductSurvey(Arrays.asList(thisLine.split(" "))));
		}
		return surveys;
	}

	/**
	 * Calculate discounts.
	 *
	 * @param products
	 *            the products
	 * @param surveys
	 *            the surveys
	 */
	private static void calculateDiscounts(List<ProductEquilibrium> products, List<ProductSurvey> surveys) {
		Double discount = 0.0;
		Optional<Double> leastPrice = null;
		Map<String, Double> productPrices = new TreeMap<>();
		char c = 'A';
		for (ProductEquilibrium product : products) {
			discount = getInstance().getDiscount(product.getSupply(), product.getDemand());
			leastPrice = surveys.stream()
					.filter(productSurvey -> productSurvey.equals(product)
							&& validateProductAverage(product, surveys, productSurvey))
					.map(survey -> survey.getPrice()).sorted().findFirst();
			if (leastPrice.isPresent()) {
				productPrices.put(String.valueOf(c++), leastPrice.get() + (discount * leastPrice.get()));
			}
		}
		productPrices.forEach(PricingEngine::printPrice);
	}

	/**
	 * Validate product average.
	 *
	 * @param product
	 *            the product
	 * @param surveys
	 *            the surveys
	 * @param productSurvey
	 *            the product survey
	 * @return true, if successful
	 */
	private static boolean validateProductAverage(ProductEquilibrium product, List<ProductSurvey> surveys,
			ProductSurvey productSurvey) {
		OptionalDouble average = surveys.stream().filter(survey -> survey.equals(product))
				.mapToDouble(a -> a.getPrice()).average();
		if (average.isPresent() && (productSurvey.getPrice() * 0.5 < average.getAsDouble())
				&& (productSurvey.getPrice() * 1.5 > average.getAsDouble())) {
			return true;
		}
		return false;
	}

	/**
	 * Prints the price.
	 *
	 * @param productName
	 *            the product name
	 * @param price
	 *            the price
	 */
	private static void printPrice(String productName, Double price) {
		System.out.println(productName + " " + price);
	}
}
