/**

 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author N Kiani
 * @version 20/02/2023
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private NumberDisplay seconds;
    //private String day;
    //private NumberDisplay day;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     * @param String 
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        //day = "";


        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int newHour, int newMinute, int newSeconds )
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
       
        setTime(newHour, newMinute, newSeconds);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        seconds.increment();
        if(seconds.getValue() == 0) {  // it just rolled over!
            minutes.increment();
        }
        if(minutes.getValue() == 0 && seconds.getValue() == 0) 
            {hours.increment();} //Incrementing the hours when both the seconds and minutes are at 0.
        
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int newHour, int newMinute, int newSeconds)
    {if (newHour < 1) { //This is validating that the hours are within the correct range.
    	System.out.println("This is an invalid input");}
    else if (newHour > 24) {
    	System.out.println("This is an invalid input");}
    
    else{hours.setValue(newHour);}
    
    if (newMinute < 0) {
    	System.out.println("This is an invalid input");}
    
    else if (newMinute > 60) {
    	System.out.println("This is an invalid input");}
    else {
    	minutes.setValue(newMinute);
    	seconds.setValue(newSeconds);}
    
        
    
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
    	 System.out.println(displayString);
        return displayString;
        
    }
    
    public void printTime()
    {
    	System.out.println(displayString);

        
    }
    
    /**
     * Update the internal string that represents the display.
     */
    public void updateDisplay()
    
    {
    	int hourHour;
    	hourHour = hours.getValue();
    	String amPm;
    	amPm = "";
        if (hours.getValue() > 12)  //If the hours are greater than 12, we are going to subtract 12 to make a 12 hour clock.
        {
        	hourHour = hourHour - 12;
        	amPm = "PM"; // If the hours are greater than 12, it must be PM.
    	    hours.setValue(hourHour);}
    	else if (hours.getValue() <= 12) {
    		hours.setValue(hourHour);
    		amPm = "AM";}
 
    		
    		
    	
        displayString = hours.getDisplayValue() + ":" + 
                minutes.getDisplayValue()+ ":" + seconds.getDisplayValue() + amPm;
       
    }
    
 
}
