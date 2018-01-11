package com.saadi;

import java.io.IOException;
import org.json.*;

public class Filter {

	private String FilterValue;
	private String FilterList;

	public String getFilterValue() {
		return FilterValue;
	}

	public void setFilterValue(String filterValue) {
		FilterValue = filterValue;
	}

	public String getFilterList() {
		return FilterList;
	}

	public void setFilterList(String filterList) {
		FilterList = filterList;
	}

	public boolean isInteger(String input) {
		try {
			Integer.parseInt(input.replaceAll(",", ""));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDate(String input) {
		try {
			java.sql.Date.valueOf(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public JSONObject finalResult() throws IOException {
		String jsonUrl = "";
		try {
			
			if(FilterList==null||FilterValue==null || FilterList.equals("All")){
				jsonUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
			}
			
			
			if (FilterList != null) {
				if (!FilterList.equals("All")) {
					if (FilterValue != null) {
						if (!FilterValue.equals("")) {
							if (FilterList.equals("lengthOfStay") || FilterList.equals("maxTotalRate")
									|| FilterList.equals("minTotalRate") || FilterList.equals("maxGuestRating")
									|| FilterList.equals("minGuestRating") || FilterList.equals("minStarRating")
									|| FilterList.equals("maxStarRating")) {

								if (isInteger(FilterValue)) {
									jsonUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel" + "&" + FilterList + "=" + FilterValue;
								}

							} else if (FilterList.equals("destinationName")) {
								jsonUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel" + "&" + FilterList + "=" + FilterValue;
							} else if (FilterList.equals("minTripStartDate") || FilterList.equals("maxTripStartDate")) {
								if (isDate(FilterValue)) {
									jsonUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel" + "&" + FilterList + "=" + FilterValue;
								}
							}
						}
					}
				}
			}

			if (jsonUrl.equals("")){
				return null;
			}
			JSONObject json = JsonReader.readJsonFromUrl(jsonUrl);

			if (json.getJSONObject("offers") == null) {
				return null;
			}

			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
