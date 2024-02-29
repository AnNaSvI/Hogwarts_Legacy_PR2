package a01649193;
import java.util.Set;
public interface MagicEffectRealization {
    default void takeDamage(int amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default void takeDamagePercent(int percentage) {
        if(percentage<0 ){
            throw new IllegalArgumentException("Amount can not be negative");
        }
        if( percentage>100){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }

    default void weakenMagic(int amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default void weakenMagicPercent(int percentage) {
        if(percentage<0 || percentage>100){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default void heal(int amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }

    default void healPercent(int percentage) {
        if(percentage<0 || percentage>100){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default void enforceMagic(int amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default void enforceMagicPercent(int percentage) {
        if(percentage<0 || percentage>100){
            throw new IllegalArgumentException("Amount can not be negative");
        }
    }
    default boolean isProtected(Spell s) {
        if(s==null){
            throw new IllegalArgumentException("s null");
        }
        return false;
    }

    default void setProtection(Set<AttackingSpell > attacks) {
        if(attacks==null){
            throw new IllegalArgumentException("attacks null");
        }
    }
    default void removeProtection(Set<AttackingSpell > attacks) {
        if(attacks==null){
            throw new IllegalArgumentException("attacks null");
        }
    }
}
