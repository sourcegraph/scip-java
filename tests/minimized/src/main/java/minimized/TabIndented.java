package minimized;

public class TabIndented {
	public void app() {
		Object o = new Object() {
			@Override
			public boolean equals(Object other) {
				return false;
			}

			@Override
			public int hashCode() {
				return System.identityHashCode(this);
			}

			@Override
			public String toString() {
				return "";
			}
		};
	}
}
