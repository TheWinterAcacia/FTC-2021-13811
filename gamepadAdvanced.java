package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="gamepadAdvanced", group="Linear Opmode")
//@Disabled
public class gamepadAdvanced extends LinearOpMode {

    //Initial creation of objects for motors and servos. They are assigned to their ports below.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftBackDrive, rightBackDrive, rightFrontDrive, leftFrontDrive, craneExtend, cranePitch, craneElevate, fakeMotor;
    private Servo craneGrab, trayGrab, craneGrabAttitude, flipperLeft, flipperRight;

    public void runOpMode() {
        
//******************************************************************************

        //Initial setup
        //Assign the objects created above to their ports. Hub 1 is the left one.
        leftBackDrive  = hardwareMap.get(DcMotor.class, "left_back_drive"); //port 0, hub1
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive"); //port 1, hub1
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive"); //port 2, hub1
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive"); //port 3, hub1
        craneExtend = hardwareMap.get(DcMotor.class, "craneExtend"); //port 0, hub2
        cranePitch = hardwareMap.get(DcMotor.class, "cranePitch"); //port 1, hub2
        craneElevate = hardwareMap.get(DcMotor.class, "craneElevate"); //port 2, hub2
        fakeMotor = hardwareMap.get(DcMotor.class, "fakeMotor"); //port 2, hub3
        craneGrab = hardwareMap.get(Servo.class, "craneGrab"); //port 0, servo
        craneGrabAttitude = hardwareMap.get(Servo.class, "craneGrabAttitude"); //port 2, servo
        trayGrab = hardwareMap.get(Servo.class, "trayGrab"); //port 1, servo
        flipperLeft = hardwareMap.get(Servo.class, "flipperLeft"); //port 3. servo
        flipperRight = hardwareMap.get(Servo.class, "flipperRight"); //port 4, servo
        
        //Resets encoders used for the crane. This is an artifact from last year, and we used it for easier testing; in autonomous the
        //crane was "deployed" before it went under the bridge as it had to be tucked into the robot to fit length restrictions.
        craneElevate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        cranePitch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        //Sets motors to run to [pulses] encoder pulses
        craneElevate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        cranePitch.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        //Assigns the motors to a forward direction. Positive values in the .setPower() are forwards.
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);

        //Variable declaration
        driveX = 0; //Used for diagonal control, positive is forward
        driveZ = 0; //Used for diagonal control, positive is right
      
        telemetry.addData("Status", "Initialized");
        telemetry.update(); //Done initalizing

        //Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
//******************************************************************************

            //Drive controls
            
            
//******************************************************************************

            //Crane controls
            
            
//******************************************************************************
            
            //Servo controls
            

//******************************************************************************

            //Telemetry display
            telemetry.addData("Run Time:", "" + runtime.toString());
            telemetry.addData("Motor Power", "L (%.2f), R (%.2f)", gamepad1.left_stick_y, gamepad1.right_stick_y);
            telemetry.addData("Crane Setting", "" + craneSetting);
            telemetry.update();
        }
    }
}