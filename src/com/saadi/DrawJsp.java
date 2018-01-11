package com.saadi;

import java.io.IOException;

import org.json.*;

public class DrawJsp {
	private Filter resultFilter;

	public Filter getResultFilter() {
		return resultFilter;
	}

	public void setResultFilter(Filter resultFilter) {
		this.resultFilter = resultFilter;
	}

	public StringBuilder draw() throws IOException, JSONException {

		JSONObject json = resultFilter.finalResult();
		StringBuilder jspOut = new StringBuilder("");
		if (json != null) {
			
			try {
			JSONObject jsonObj = json.getJSONObject("offers");
			
			JSONArray hotelJsonArray = jsonObj.getJSONArray("Hotel");
			jspOut.append("Search result: " + "Number of offers is " + hotelJsonArray.length());
			for (int i = 0; i < hotelJsonArray.length(); i++) {
				jspOut.append("<table style=\"width:100%\" border=\"2\">");
				jspOut.append("<tr style=\"background-color: cadetblue;\">");
				jspOut.append("<th >" + (i + 1) + ": Hotel Name : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelName"))
						+ "</th> </tr></table>");
				jspOut.append(" <table style=\"width:100%\" border=\"2\">"
						+ "<tr style=\"background-color: bisque;\"><th>localized Hotel Name : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("localizedHotelName"))
						+ "</th>");
				jspOut.append("<th>Hotel Destination : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelDestination")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Hotel Long Destination : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelLongDestination"))
						+ "</th>");
				jspOut.append("<th>hotel Street Address : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelStreetAddress"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Hotel City : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelCity")) + "</th>");

				jspOut.append("<th>Hotel Province : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelProvince")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Hotel Country Coden : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelCountryCode")) + "</th>");
				jspOut.append("<th>Hotel Latitude : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelLatitude")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Hotel Longitude : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelLongitude")) + "</th>");
				jspOut.append("<th>Hotel Star Rating : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelStarRating")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Hotel Guest Review Rating : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelGuestReviewRating"))
						+ "</th>");
				jspOut.append("<th>Hotel Review Total : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelReviewTotal")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Is Official Rating : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("isOfficialRating")) + "</th>");
				jspOut.append("<th>Hotel Destination Region ID : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelDestinationRegionID"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Hotel Id : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelId")) + "</th>");
				
				jspOut.append("<th>Hotel Image Url : <img SRC="
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelInfo"),("hotelImageUrl")).replaceAll("http//", "")
						+ " width=\"100\" height=\"100\">" + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Travel Start Date : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("offerDateRange"),("travelStartDate"))
						+ "</th>");
				jspOut.append("<th>Travel End Date : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("offerDateRange"),("travelEndDate"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Length Of Stay : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("offerDateRange"),("lengthOfStay")) + "</th>");
				jspOut.append("<th>Region ID : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("regionID")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Associated Multi City Region Id : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("associatedMultiCityRegionId"))
						+ "</th>");
				jspOut.append("<th>Long Name : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("longName")) + "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Short Name : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("shortName")) + "</th>");
				jspOut.append("<th>Country : " + hotelJsonArray.getJSONObject(i).getJSONObject("destination").get("country").toString()
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Province : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i), "destination", "province") + "</th>");
				jspOut.append("<th>City : " + getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("city"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Tla : " + getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("tla"))
						+ "</th>");
				jspOut.append("<th>Non Localized City : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("destination"),("nonLocalizedCity"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Air Attach Remaining Time : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("airAttachRemainingTime"))
						+ "</th>");
				jspOut.append("<th>Number Of People Viewing : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("numberOfPeopleViewing"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Number Of People Booked : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("numberOfPeopleBooked"))
						+ "</th>");
				jspOut.append("<th>Number Of Rooms Left : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("numberOfRoomsLeft"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Last Booked Time : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("lastBookedTime"))
						+ "</th>");
				jspOut.append("<th>Almost Sold Status : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("almostSoldStatus"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Link : <a href=http://"
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("link"))
						+ ">ClickHere</a>" + "</th>");
				jspOut.append("<th>Air Attach Enabled : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrgencyInfo"),("airAttachEnabled"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Average Price Value : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("averagePriceValue"))
						+ "</th>");
				jspOut.append("<th>Total Price Value : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("totalPriceValue"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>Cross Out Price Value : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("crossOutPriceValue"))
						+ "</th>");
				jspOut.append("<th>Original Price Per Night : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("originalPricePerNight"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Currency : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("currency")) + "</th>");
				jspOut.append("<th>Percent Savings : "
						+ getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("percentSavings"))
						+ "</th>");
				jspOut.append("</tr>");
				jspOut.append("<tr><th>DRR : " + getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelPricingInfo"),("drr"))
						+ "</th>");
				jspOut.append("<th>Hotel Infosite Url : <a href="
						+ java.net.URLDecoder.decode(getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrls"),("hotelInfositeUrl")), "UTF-8")
						+ ">ClickHere</a>" + "</th>");
				jspOut.append("</tr>");
				
				jspOut.append("<tr style=\"background-color: bisque;\"><th>Hotel Search Result Url : <a href="
						+ java.net.URLDecoder.decode(getValueFromObject(hotelJsonArray.getJSONObject(i),("hotelUrls"),("hotelSearchResultUrl")), "UTF-8")
						+ ">ClickHere</a>"

						+ "</th>");
				jspOut.append("<th></th>");
				jspOut.append("</tr>");

				jspOut.append("</table> ");
			}

			return jspOut;
			} catch(Exception e) {
				return new StringBuilder("No Result");
			}
			
		}
		return new StringBuilder("No Result");
	}

	private String getValueFromObject(JSONObject jsonObject, String parent, String value) {
		try {
			return jsonObject.getJSONObject(parent).get(value).toString();
		} catch (Exception e) {
			return "";
		}

	}

}
