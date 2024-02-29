package a01649193;
import java.util.Collections;
import java.util.Set;
/**
 * Magic spells that do some sort of damage to a target
 */
public class AttackingSpell extends Spell {
	/**
	 * Defines, if HP or MP is affected.
	 * <p>
	 * type == true: affects HP
	 * <p>
	 * type == false: affects MP
	 */
	private boolean type;
	/**
	 * Defines, if amount is interpreted as an absolute value or as a percentage.
	 * <p>
	 * percentage == true: deduct value to subtract as 'amount' percentage of basic value
	 * <p>
	 * percentage == false: subtract amount directly 
	 */
	private boolean percentage;
	/**
	 * Has to be non negative.
	 * <p>
	 * if percentage==true, amount must be in the interval [0,100]
	 */
	private int amount;
	
	/**
	 * @param name name
	 * @param manaCost manaCost
	 * @param levelNeeded levelNeeded
	 * @param type defines if health or mana is affected
	 * @param percentage defines if amount is an absolute or a percentage value
	 * @param amount amount
	 */
	public AttackingSpell(String name,	int manaCost, MagicLevel levelNeeded, boolean type, boolean percentage, int amount) {
		super(name, manaCost, levelNeeded);
		this.type=type;
		this.percentage=percentage;
		this.amount=amount;
		if(amount<0 ){
			throw new IllegalArgumentException("amount<0");
		}
		if(percentage && amount>100){
			throw new IllegalArgumentException("percentage && amount>100");
		}
	}

	/**
	 * If the target is protected against this spell (isProtected), then protection against
	 * exactly this spell is removed (removeProtection).
	 * Otherwise use one of the functions takeDamage, takeDamagePercent, weakenMagic or
	 * weakenMagicPercent on target according to the flags type and percentage.
	 * @param target target that takes the damage
	*/
	@Override
	public void doEffect(MagicEffectRealization target) {
			if(target==null){
			throw new IllegalArgumentException("targer null");
		}
		if(target.isProtected(this)){
			Set<AttackingSpell> singletonSet = Collections.singleton(this);
			target.removeProtection(singletonSet);
		}else {
			if (type && percentage) {
				target.takeDamagePercent(amount);
			}
			if (type && !percentage) {
				target.takeDamage(amount);
			}
			if (!type && percentage) {
				target.weakenMagicPercent(amount);
			}
			if (!type && !percentage) {
				target.weakenMagic(amount);
			}
		}



	}

	/**
	 * Returns "; -'amount' 'percentage' 'HPorMP'".
	 * where 'percentage' is a '%'-sign if percentage is true,
	 * empty otherwise and HPorMP is HP if type is true, MP otherwise.
	 * E. g. "; -10 MP" or "; -50 % HP"
	 * @return "; -'amount' 'percentage' 'HPorMP'".
	 */
	@Override
	public String additionalOutputString() {
		String HPorMP;
		String pr;
		if(type){
			HPorMP="HP";
		}else{
			HPorMP="MP";
		}
		if(percentage){
			pr="% ";
		}else{
			pr="";
		}

		return ("; -"+amount+" "+pr+HPorMP);
	}
}