import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator
import com.acmerobotics.roadrunner.path.heading.HeadingInterpolator
import com.acmerobotics.roadrunner.path.heading.SplineInterpolator
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints

object TrajectoryGen {
    private val constraints = DriveConstraints(45.0, 60.0, 0.0, 270.0.toRadians, 270.0.toRadians, 0.0)
    private val startPose = Pose2d(-22.0, -62.5, 180.0.toRadians)
    //private val startPose = Pose2d(48.0, -28.0, -90.0.toRadians)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(startPose, constraints)

        // dump routine
        /*builder1
            .setReversed(true)
            //.splineTo(Pose2d(-62.5, -39.5, 0.0.toRadians))// y = -39 is halfway between the skybridge and partner with 6" on either side, y = -42 gives 3" of room for other robot
            //.splineTo(Pose2d(48.0, -33.0, -90.0.toRadians))
            .lineTo(Vector2d(48.0, -36.0), ConstantInterpolator(-90.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 0.0.toRadians))
            .splineTo(Pose2d(-37.5, -35.0, 0.0.toRadians))
            //.lineTo(Vector2d(-44.5, -35.0), ConstantInterpolator(-90.0.toRadians))
        list.add(builder1.build())*/

        //weird reversed profiles
        builder1
            .setReversed(true)
            .lineTo(Vector2d(-44.5, -35.0), ConstantInterpolator(-90.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians))
            .splineTo(Pose2d(48.0, -33.0, -90.0.toRadians))
            .lineTo(Vector2d(48.0, -28.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(48.0, -36.0), ConstantInterpolator(-90.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 0.0.toRadians))
            .splineTo(Pose2d(-55.5, -35.0, 180.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians))
            .splineTo(Pose2d(48.0,.0, -90.0.toRadians))
            .splineTo(Pose2d(0.0, -42.0, 0.0.toRadians))

            .lineTo(Vector2d(-30.0, -42.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(-30.0, -35.0), ConstantInterpolator(180.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians))
            .splineTo(Pose2d(48.0, -33.0, -90.0.toRadians))
            .lineTo(Vector2d(48.0, -28.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(48.0, -36.0), ConstantInterpolator(-90.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 0.0.toRadians))
            .lineTo(Vector2d(-20.0, -42.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(-20.0, -35.0), ConstantInterpolator(180.0.toRadians))
            .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians))
            .splineTo(Pose2d(48.0, -33.0, -90.0.toRadians))
            .lineTo(Vector2d(48.0, -28.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(48.0, -36.0), ConstantInterpolator(-90.0.toRadians))
            .lineTo(Vector2d(48.0, -60.0), ConstantInterpolator(0.0.toRadians))
            .lineTo(Vector2d(28.0, -60.0), ConstantInterpolator(0.0.toRadians))
            .lineTo(Vector2d(28.0, -40.0), ConstantInterpolator(0.0.toRadians))
            .splineTo(Pose2d(0.0, -42.0, 0.0.toRadians))

        list.add(builder1.build())
        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians get() = (Math.toRadians(this))