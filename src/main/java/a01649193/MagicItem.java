package a01649193;

/**
 * MagicItems are items that can cause magic effects on other objects. So they are a source
 * of magic. As items they can be traded and they also can be the target of magic effects  
 */
public abstract class MagicItem implements Tradeable, MagicEffectRealization, MagicSource, Localizable {
	/**
	 * Must not be null or empty
	 * */
	private String name;
	/**
	 * Number of usages remaining; must not be negative
	 */
	private int usages;
	/**
	 * Must not be negative
	 */
	private int price;
	/**
	 * must not be negative
	 */
	private int weight;

	private String origin;

	/**
	 * @param name name
	 * @param usages number of usages still left
	 * @param price price
	 * @param weight weight
	 */
	public MagicItem(String name, int usages, int price, int weight) {
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("name==null || name.isEmpty()");
		}
		if(usages<0){
			throw new IllegalArgumentException("usages<0");
		}
		if(price<0){
			throw new IllegalArgumentException("price<0");
		}
		if(weight<0){
			throw new IllegalArgumentException("weight<0");
		}

		this.name=name;
		this.usages=usages;
		this.price=price;
		this.weight=weight;
		//this.origin=origin;
	}
	@Override
	public String getOrigin() {
		if(origin==null|| origin.isEmpty()){
			return "Hogwarts";
		}
		return origin;
	}
	@Override
	public void setOrigin(String origin) {
		 this.origin=origin;
	}

    /**
     * Returns value of usages (for access from deriving classes)
     * @return value of instance variable usages
     */
	public int getUsages() {
		return usages;
	}

    /**
     * If usages > 0 reduce usage by 1 and return true, otherwise return false
     * @return returns true if usage is still possible
     */
	public boolean tryUsage() {
		if(usages>0){
			--usages;
			return true;
		}
		return false;
	}

    /**
     * Returns "use" if usages is equal to 1, "uses" otherwise
     * @return "use" or "uses" depending on the value of usages
     */
	public String usageString() {
		if(usages==1){
			return "use";
		}
		return "uses";
	}

    /**
     * returns empty string. Is overridden in deriving classes as needed
     * @return ""
     */
	public String additionalOutputString() {
		return "";
	}

    /**
     * Formats this object according to
     * "['name'; 'weight' g; 'price' 'currencyString'; 'usages' 'usageString''additionalOutputString']"
     * 'currencyString' is "Knut" if price is 1, "Knuts" otherwise
     * e.g. (when additionalOutput() returns an empty string)
     * "[Accio Scroll; 1 g; 1 Knut; 5 uses]" or "[Alohomora Scroll; 1 g; 10 Knuts; 1 use]"
     * @return "['name'; 'weight' g; 'price' 'currencyString'; 'usages' 'usageString''additionalOutputString']"
     */
	@Override
	public String toString() {
		String currencyString;
		if(price==1){
			currencyString ="Knut";
		}else{
			currencyString="Knuts";
		}
		return "["+this.name+"("+getOriginFormatted()+")"+"; "+this.weight+" g; "+this.price+" "+currencyString+"; "+usages+" "+this.usageString()+additionalOutputString()+"]";
	}

	//Tradeable Interface:

	/**
	 * Returns price of the object
	 * @return value of instance variable price
	 */
	@Override
	public int getPrice() {
		return this.price;
	}
	public String getName() {
		return this.name;
	}

    /**
     * Returns weight of the object
     * @return value of instance variable weight
     */
	@Override
	public int getWeight() {
		return this.weight;
	}

	//MagicSource Interface:

    /**
     * Always returns true; no Exceptions needed
     */
	@Override
	public boolean provideMana(MagicLevel levelNeeded, int amount) {
		if(levelNeeded==null || amount<0){
			throw new IllegalArgumentException("evelNeeded==null || amount<0");
		}
		return true;
	}

	//MagicEffectRealization Interface:

	/**
	 * Reduce usages to usages*(1-percentage/100.)
	 */
	@Override
	public void takeDamagePercent(int percentage) {
		if(percentage<0 || percentage>100){
			throw new IllegalArgumentException("percentage<0 || percentage>100");
		}
		usages = (int) Math.ceil(usages * (1 - (percentage / 100.0)));
	}
}