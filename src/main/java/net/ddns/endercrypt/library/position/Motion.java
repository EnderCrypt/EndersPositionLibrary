package net.ddns.endercrypt.library.position;

import java.io.Serializable;

public class Motion implements Serializable
{
	private static final long serialVersionUID = -350024613528396037L;
	/**
	 * 
	 */
	public double x = 0;
	public double y = 0;

	// CONSTRUCTORS //

	public Motion()
	{
		this(0, 0);
	}

	public Motion(Motion motion)
	{
		set(motion);
	}

	public Motion(double x, double y)
	{
		set(x, y);
	}

	// SET //

	public void set(Motion motion)
	{
		set(motion.x, motion.y);
	}

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setDirection(double direction)
	{
		setMotion(direction, getLength());
	}

	public void setLength(double length)
	{
		setMotion(getDirection(), length);
	}

	public void setMotion(double direction, double length)
	{
		double x = Math.cos(direction) * length;
		double y = Math.sin(direction) * length;
		set(x, y);
	}

	// ADD //

	public void add(Motion motion)
	{
		add(motion.x, motion.y);
	}

	public void add(double x, double y)
	{
		set(this.x + x, this.y + y);
	}

	@Deprecated
	public void addDirection(double direction)
	{
		setMotion(getDirection() + direction, getLength());
	}

	public void addLength(double length)
	{
		setMotion(getDirection(), getLength() + length);
	}

	public void addMotion(double direction, double length)
	{
		double x = Math.cos(direction) * length;
		double y = Math.sin(direction) * length;
		add(x, y);
	}

	// GET //

	public double getDirection()
	{
		return Math.atan2(y, x);
	}

	public double getLength()
	{
		return Math.sqrt(x * x + y * y);
	}

	public Position getAsPosition()
	{
		return new Position(x, y);
	}

	public double getLengthByDirection(double direction)
	{
		double currentDirection = Math.atan2(y, -x);
		double currentLength = getLength();
		currentDirection -= direction;
		double x = Math.cos(currentDirection) * currentLength;
		return -x;
	}

	// ACTIONS //

	public void truncateLength(double max)
	{
		setLength(Math.min(max, getLength()));
	}

	/**
	 * multiplies the length of this vector by the value parameter
	 * 1.0 = no change
	 * 0.0 = length gets set to 0
	 */
	public void multiplyLength(double multiplier)
	{
		setLength(getLength() * multiplier);
	}

	@Override
	public String toString()
	{
		return getClass().getName() + "[x=" + x + ",y=" + y + " | dir=" + getDirection() + ",length=" + getLength() + "]";
	}
}
