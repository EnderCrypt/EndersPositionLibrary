package com.endercrypt.library.position;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Position implements Serializable
{
	private static final long serialVersionUID = 3801407731694558524L;
	/**
	 * 
	 */
	public double x;
	public double y;

	public Position()
	{
		this(0.0, 0.0);
	}

	public Position(Point point)
	{
		this(point.x, point.y);
	}

	public Position(Point2D.Double point)
	{
		this(point.x, point.y);
	}

	public Position(Position position)
	{
		this(position.x, position.y);
	}

	public Position(double x, double y)
	{
		set(x, y);
	}

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Position getLocation()
	{
		return new Position(x, y);
	}

	public Point2D.Double getPoint2D()
	{
		return new Point2D.Double(x, y);
	}

	public double distance(Position other)
	{
		return distance(other.x, other.y);
	}

	public double distance(double x, double y)
	{
		double x_diff = this.x - x;
		double y_diff = this.y - y;
		return Math.sqrt(x_diff * x_diff + y_diff * y_diff);
	}

	public double direction(Position other)
	{
		return direction(other.x, other.y);
	}

	public double direction(double x, double y)
	{
		return Math.atan2((y - this.y), (x - this.x));
	}

	public Position lengthdir(double direction, double length)
	{
		Position position = new Position(x, y);
		position.add(direction, length);
		return position;
	}

	public void add(Motion motion)
	{
		x += motion.x;
		y += motion.y;
	}

	public void add(double direction, double length)
	{
		x += Math.cos(direction) * length;
		y += Math.sin(direction) * length;
	}

	public void translate(Position other)
	{
		translate(other.x, other.y);
	}

	public void translate(double x, double y)
	{
		this.x += x;
		this.y += y;
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "[x=" + x + ",y=" + y + "]";
	}

}
