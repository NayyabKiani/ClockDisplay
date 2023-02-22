/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author N Kiani
 * @version 20/02/2023
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    
	

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
        ;
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
        	
            return "0" + value;
            
        }
        else {
        	 
            return "" + value;
        }
    }
        public void printDisplayValue(){
        	
        	if(value < 10) {
           	
               
               
           }
           else {
           
        }
        	
        
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int newValue)
    {
        if((newValue >= 0) && (newValue < limit)) {
            value = newValue;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    /*
    public void increment()
    {
    	if( value < limit) {
    		value = (value + 1); }
    	else if (value >= limit) {
    		value = 0;
    	}
    		//System.out.println("INCORRECT INPUT : This is exceeding the limits");}
    }*/
    public void increment()
    {
        value = (value + 1) % limit;
    }
}
