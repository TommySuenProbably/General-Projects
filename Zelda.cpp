//Tommy and Dulhan

task main()
{
	//Speed constants
	const int SPEED = 40, GANON_SPEED = 10;

	//Counter variables for color tiles, length and time
	int blue_tiles = 0, red_tiles = 0;
	float red_length = 0, largest_red_length = 0, time = 0;

	//Set sensor types and modes
	SensorType[S1] = sensorEV3_Color;
	wait1Msec(50);
	SensorType[S2] = sensorEV3_Gyro;
	wait1Msec(50);
	SensorType[S3] = sensorEV3_Ultrasonic;
	wait1Msec(50);
	SensorMode[S1] = modeEV3Color_Color;
	wait1Msec(50);

	//Display Header message
	displayTextLine(3, "Wed 2:30 T.S., D.");

	//Wait until the enter button is pressed
	while(!getButtonPress(buttonEnter))
	{}
	while(getButtonPress(buttonAny))
	{}

	motor[motorA] = motor[motorD] = SPEED; //Set normal speed
	
	//Program starts on white so this loop helps officially start on red
	while(SensorValue[S1] != (int)colorRed)
	{}
	time1[T1] = 0; //Start time
	
	while(SensorValue[S1] != (int)colorWhite)
	{
		//If the tile is blue, enter the loop
		if(SensorValue[S1] == (int)colorBlue)
		{
			blue_tiles++; //Increment the blue tile count

			//Loops the two possible blue tile outcomes
			while(SensorValue[S1] == (int)colorBlue) 
			{
				if(SensorValue[S3] <= 40) //If GANON!!!!!!
				{
					motor[motorA] = motor [motorD] = GANON_SPEED; //Slow
					//While it is still a blue tile and less/equal than 40
					while(SensorValue[S1] == (int)colorBlue && 
						  SensorValue[S3] <= 40)
			  		{}
				}
				if(SensorValue[S3] > 40)
				{
					//Reset normal speed (OR continue) if no obstruction
					motor[motorA] = motor [motorD] = SPEED;
					//While it is still a blue tile and more than 40
					while(SensorValue[S1] == (int)colorBlue && 
						  SensorValue[S3] > 40)
			  		{}
				}
			}
			
			wait1Msec(50); //Debouncing
		}

		//If the tile is red
		if(SensorValue[S1] == (int)colorRed)
		{
			red_tiles++; //Increment red tile count
			nMotorEncoder[motorA] = 0; //Begin counting the length

			//Since red has no conditions, continue at (OR reset) speed
			motor[motorA] = motor [motorD] = SPEED;
			//Continue while red
			while(SensorValue[S1] == (int)colorRed)
			{}
			
			//While loop ended => new tile. Record red tile length
			red_length = (float)(nMotorEncoder[motorA]/180.0)*PI*2.75;
			//If this is greater than the tile length (default: 0)
			//No tile is 0
			if(red_length > largest_red_length)
				largest_red_length = red_length;
				
			wait1Msec(50); //Debouncing
		}
	}
	time = time1[T1]/1000.0; //Get time in seconds

	//Display messages: # of blue tiles, largest red tile and travel time
	displayTextLine(4, "# of Blue Tiles: %i", blue_tiles);
	displayTextLine(5, "Largest red tile length: %.2f"
	                , largest_red_length);
	displayTextLine(6, "Travel Time: %.2f", time);

	//Reset the gyro to curret position
	resetGyro(S2);
	//Spin "arcs" times until a full circle has been made
	for(int arcs = 1; arcs <= 360/45; arcs++)
	{
		//Speed for clockwise turn
		motor[motorA] = -SPEED;
		motor[motorD] = SPEED;

		//Continue turning until it finishes 45 degree portion
		while(getGyroDegrees(S2) < arcs*45)
		{}
		
		//Turn off motor and wait half a second
		motor[motorA] = motor [motorD] = 0;
		wait1Msec(500);
	}

	//Wait until enter button is pressed to end program
	while(!getButtonPress(buttonEnter))
	{}
	while(getButtonPress(buttonAny))
	{}
}


