package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.hardware.lynx.LynxDigitalChannelController;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.hardware.configuration.DeviceConfiguration;
import com.qualcomm.robotcore.hardware.configuration.ServoHubConfiguration;

import java.nio.channels.Channel;

@TeleOp (name = "Basic Servo Test")
public class Basic_Servo_Test extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        //Servo Claw;
        double ServoPos;
        double Servo1Pos;

        // 0.32 grab
        // 0.69 transfer
        Servo Servo;
        Servo Servo1;


        //Servo Elbow;

        //Claw = hardwareMap.get(Servo.class, "Thing 1");
        Servo = hardwareMap.get(Servo.class, "Claw Elbow");
        Servo1 = hardwareMap.get(Servo.class, "Elbow");
        //Elbow = hardwareMap.get(Servo.class, "Elbow");

        waitForStart();

        //Claw.setPosition(0);
        //Wrist.setPosition(0.44);
        // Down
        // Elbow: 0.174
        // Claw Elbow: 0.25
        // Up
        // Elbow: 0.65
        // Claw: 0.783
        ServoPos = 0;
        Servo1Pos = 0;

        // Claw Elbow down
        // Claw Elbow == 0.22
        // Elbow == 0.09

        // Claw Elbow up
        // Claw Elbow == 0.63
        // Elbow == 0.53

        // Claw Elbow Slides extended && down
        // Claw Elbow == 0.09
        // Elbow == 0.13

        while(opModeIsActive()){

            //ServoPos = -this.gamepad1.left_stick_y;
            //Servo1Pos = -this.gamepad1.right_stick_y;


            if(gamepad1.a)
            {
                ServoPos += 0.001;
            }
            if(gamepad1.y)
            {
                ServoPos -= 0.001;
            }

            if(gamepad1.x)
            {
                Servo1Pos += 0.001;
            }
            if(gamepad1.b)
            {
                Servo1Pos -= 0.001;
            }


            if(!opModeIsActive())
            {
                Servo.resetDeviceConfigurationForOpMode();


                Servo.getController().pwmDisable();
                Servo.getController().close();


//                Servo.commitSuicide();
//
//                ServoHubConfig config = new ServoHubConfig();
//                config.channel0.pulseRange(500, 1500, 2500);
//                config.disableBehavior(ServoChannelConfig.BehaviorWhenDisabled.kSupplyPower);
            }

            Servo.setPosition(ServoPos);
            Servo1.setPosition(Servo1Pos);

//            if(gamepad1.x)
//            {
//                // Closed
//                Claw.setPosition(1);
//            }
//            else if(gamepad1.b)
//            {
//                //Open
//                Claw.setPosition(0);
//            }

//            if(gamepad1.a)
//            {
//                //Sample Horizontal
//                Wrist.setPosition(0);
//            }
//            else if(gamepad1.y)
//            {
//                //Sample Vertical
//                Wrist.setPosition(0.28);
//            }
//
//            if (gamepad1.dpad_right)
//            {
//                //Elbow up
//                Elbow.setPosition(0.8);
//            }
//            else if(gamepad1.dpad_left)
//            {
//                //Elbow down
//                Elbow.setPosition(0.1);
//            }

            //telemetry.addData("Elbow", Elbow.getPosition());
            //telemetry.addData("Claw Pos", Claw.getPosition());
            telemetry.addData("Claw Elbow pos", Servo.getPosition());
            telemetry.addData("Elbow Pos", Servo1.getPosition());

            telemetry.update();

        }

    }
}
