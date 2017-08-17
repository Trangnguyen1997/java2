package dataobject;

public class UnitOfMeasure {
	private int unitmeasureid;
	private String name;

	public UnitOfMeasure(int unitmeasureid, String name) {
		super();
		this.unitmeasureid = unitmeasureid;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getUnitmeasure() {
		return unitmeasureid;
	}

	public void setId(int unitmeasureid) {
		this.unitmeasureid = unitmeasureid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


