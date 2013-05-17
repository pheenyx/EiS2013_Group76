import java.awt.Color;

public class CVTheme {

	public enum ThemeStyle {
		CLASSIC, BANKING, CASUAL
	}

	public enum ThemeColor {
		BLUE, ORANGE, GREEN;

		public Color toColor() {
			switch (this) {
			case BLUE:
				return Color.BLUE;
			case ORANGE:
				return Color.ORANGE;
			case GREEN:
				return Color.GREEN;
			}
			return null;
			/*
			 * should really throw an exception, but since the (provided)
			 * CurriculumVitae.java does not do any exception handling, just
			 * ignore this for now
			 */
		}
	}

	private ThemeColor color;
	private ThemeStyle style;

	/**
	 * Constructor
	 */
	public CVTheme() {
	}

	/**
	 * Constructor
	 * 
	 * @param style
	 *            - the style to set
	 * @param color
	 *            - the color to set
	 * @throws IllegalArgumentException
	 *             if and only if any argument ==null
	 */
	public CVTheme(ThemeStyle style, ThemeColor color) {
		setStyle(style);
		setColor(color);
	}

	/**
	 * @return the color
	 */
	public ThemeColor getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 * @throws IllegalArgumentException
	 *             if and only if color==null
	 */
	public void setColor(ThemeColor color) {
		if (color == null)
			throw new IllegalArgumentException();
		this.color = color;
	}

	/**
	 * @return the style
	 */
	public ThemeStyle getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 * @throws IllegalArgumentException
	 *             if and only if style==null
	 */
	public void setStyle(ThemeStyle style) {
		if (style == null)
			throw new IllegalArgumentException();
		this.style = style;
	}

}
