package First;

public class InfoPage {
	private String coefficientName;
	private float coefficientValue, coefficientPermissibleValue;

	public InfoPage(String coeficientName, float coefficientValue, float coefficientPermissibleValue) {

		this.setCoefficientName(coefficientName);
		this.setCoefficientValue(coefficientValue);
		this.setCoefficientPermissibleValue(coefficientPermissibleValue);
	}

	public String getCoefficientName() {
		return coefficientName;
	}

	public void setCoefficientName(String coefficientName) {
		this.coefficientName = coefficientName;
	}

	public float getCoefficientValue() {
		return coefficientValue;
	}

	public void setCoefficientValue(float coefficientValue) {
		this.coefficientValue = coefficientValue;
	}

	public float getCoefficientPermissibleValue() {
		return coefficientPermissibleValue;
	}

	public void setCoefficientPermissibleValue(float coefficientPermissibleValue) {
		this.coefficientPermissibleValue = coefficientPermissibleValue;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
		.append(this.coefficientName)
		.append(" ")
		.append(this.coefficientValue)
		.append("")
		.append(this.coefficientPermissibleValue);
		return sb.toString();
	}
}
