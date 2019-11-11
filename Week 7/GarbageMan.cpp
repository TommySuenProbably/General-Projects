//Tommy and Frederick

//Method to drive and count green and not green things
void measure_green(int time, int power, 
				   int & things_green, int & things_notGreen)
{
	const float WHEEL_RADIUS = 2.75
	
	//Reset the counters
	things_green = 0;
	things_notGreen = 0;
	
	//Reset the everything (time and encoder)
	time1[T1] = 0;
	nMotorEncoder[motorA] = 0;
	
	motor[motorA] = motor[motorD] = power; //Set to power given
	//While time is not over OR while down button is not pressed
	while(time1[T1] < time)
	{
		//If the car has driven 1cm
		if(nMotorEncoder[motorA] = 180.0/(PI*WHEEL_RADIUS))
		{
			nMotorEncoder = 0; //Reset the motor encoders
			
			//Count whether the thing beneath is green OR not
			if(SensorValue[S1] == (int) colorGreen)
				things_green++;		
			else 
				things_notGreen++;
		}
	}
	motor[motorA] = motor[motorD] = 0; //Turn off motors
}

task main()
{
	//Boolean variables to check which button was pressed
	//Rest are (cumulative) counting variales
	bool left = false, centre = false, right = false, down = false;
	int things_green = 0, things_notGreen = 0;
	int total_green = 0, total_notGreen = 0;
	
	//Set the color sensor
	SensorType[S1] = sensorEV3_Color;
	wait1Msec(50);
	SensorMode[S1] = modeEV3Color_Color;
	wait1Msec(50);
	SensorType[S2] = sensorEV3_Touch;
	wait1Msec(50);
	
	//Display Header message
	displayTextLine(3, "Wed 2:30 T.S., F.K.");
	
	//Wait for the touch sensor to be pressed and released
	while(SensorValue[S2] == 0)
	{}
	while(SensorValue[S2] == 1)
	{}
	
	//While down is not pressed. Multiple checks are integrated in loop  
	//to end the program if the down button is ever pressed
	while(!down)
	{	
		//While none of the buttons are pressed, do nothing
		while(!getButtonPress(buttonLeft) && 
		      !getButtonPress(buttonRight) &&
		      !getButtonPress(buttonCentre) &&
			  !getButtonPress(buttonDown))
		{}
		    
		//Else, pass that info to bools 
		left = getButtonPress(buttonLeft);
		right = getButtonPress(buttonEnter);
		centre = getButtonPress(buttonRight);
		down = getButtonPress(buttonDown);
		    
		//Wait for button release (not checking down button)
		while(getButtonPress(buttonAny)) 
		{}
			
		//Depending on which button has been pressed, perform task
		if(left) 
			measure_green(2000, 75, things_green, things_notGreen);
		else if(right)
			measure_green(3000, 50, things_green, things_notGreen);
		else if(centre)
			measure_green(4000, 25, things_green, things_notGreen);
		
		//Add info into cumulative variables 	
		total_green += things_green;
		total_notGreen += things_notGreen;
		
		//Display findings of green and not green things for 10 secs
		displayTextLine(4, "Green Things: %d", total_green);
		displayTextLine(5, "NOT Green Things: %d", total_notGreen);
	}
}
