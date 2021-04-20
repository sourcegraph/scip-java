package minimized;

public class TabIndented {
	public void app() {
		Object o = new Object() {
			@Override
			public boolean equals(Object other) {
				return false;
			}

			@Override
			public String toString() {
				return "";
			}
		};
	}
}
