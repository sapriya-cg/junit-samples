package junit.sample;

/**
 * 
 * Tube "App" :)
 *
 */
public class Tube {

	/**
	 * Method which determines if this Tube glows for the given color.
	 * 
	 * @param color
	 *            Cannot be null
	 * @return True if it is supported, false otherwise.
	 */
	public boolean glow(String color) {
		switch (color) {

		case "green":
		case "yellow":
		case "red":
		case "blue":
		case "violet":
			// "glows"
			return true;
		default:
			// "doesn't"
			return false;

		}

	}
}
