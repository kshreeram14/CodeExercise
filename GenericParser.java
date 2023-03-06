public Object parseGenericApi(String responseData) {
		Object data = 0;
		JsonParser parser = new JsonParser();
		Object registerData;
		String resCode;

		JsonObject object = (JsonObject) parser.parse(responseData);
		if (object.get("meta") != null) {
			registerData = object.get("meta");
			if (((JsonObject) registerData).get(ApplicationConstant.STATUS) != null) {
				data = ((JsonObject) registerData).get(ApplicationConstant.STATUS).getAsInt();
			}
		}
		return data;
	}
	
public ErrorHandling processError(String responseData) {
		ErrorHandling errorHandling = new ErrorHandling();
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(responseData);
		String code = null;
		String message = null;
		if (object.get(ApplicationConstant.CODE) != null) {
			code = object.get(ApplicationConstant.CODE).getAsString();
		}
		if (object.get(ApplicationConstant.MESSAGE) != null) {
			message = object.get(ApplicationConstant.MESSAGE).getAsString();
		}
		errorHandling.setErrorCode(code);
		errorHandling.setErrorMessage(message);
		return errorHandling;
	}

	public Object jsonParser(String responseData) {
		Object data = 0;
		JsonParser parser = new JsonParser();
		Object registerData;
		String resCode;

		JsonObject object = (JsonObject) parser.parse(responseData);
		if (object.get(ApplicationConstant.URL_PARAMETER_TX_ID) != null) {
			data = object.get(ApplicationConstant.URL_PARAMETER_TX_ID).getAsLong();
		}
		if (object.get(ApplicationConstant.STATUS) != null) {
			data = object.get(ApplicationConstant.STATUS).getAsInt();
		}
		if (object.get(ApplicationConstant.ID) != null) {
			data = object.get(ApplicationConstant.ID).getAsLong();
		}
		if (object.get(ApplicationConstant.DATA) != null) {
			registerData = object.get(ApplicationConstant.DATA);
			if (((JsonObject) registerData).get(ApplicationConstant.REMITTER_ID) != null) {
				data = ((JsonObject) registerData).get(ApplicationConstant.REMITTER_ID).getAsLong();
			}
			if (((JsonObject) registerData).get(ApplicationConstant.RESPONSE_CODE) != null) {
				data = ((JsonObject) registerData).get(ApplicationConstant.RESPONSE_CODE).getAsInt();
				resCode = ((JsonObject) registerData).get(ApplicationConstant.RESPONSE_CODE).getAsString();
				if (resCode.equals("000")) {
					data = 200;
				}
			}
			if (((JsonObject) registerData).get(ApplicationConstant.RS_CODE) != null) {
				resCode = ((JsonObject) registerData).get(ApplicationConstant.RS_CODE).getAsString();
				if (resCode.equals("000")) {
					data = 200;
				}

			}
		}
		if (object.get(ApplicationConstant.AGENT_PUBLICKEY) != null) {
			data = object.get(ApplicationConstant.AGENT_PUBLICKEY).getAsString();
		}
		if (object.get("meta") != null) {
			registerData = object.get("meta");
			if (((JsonObject) registerData).get(ApplicationConstant.STATUS) != null) {
				data = ((JsonObject) registerData).get(ApplicationConstant.STATUS).getAsInt();
			}
		}
		return data;
	}