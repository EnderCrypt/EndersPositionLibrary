package com.endercrypt.library.position;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.Serializable;

public class DownsidePosition extends Position
{
	private static final long serialVersionUID = 1448197238813213458L;

	/**
	 * 
	 */

	public DownsidePosition()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public DownsidePosition(double x, double y)
	{
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public DownsidePosition(Double point)
	{
		super(point);
		// TODO Auto-generated constructor stub
	}

	public DownsidePosition(Point point)
	{
		super(point);
		// TODO Auto-generated constructor stub
	}

	public DownsidePosition(Position position)
	{
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double direction(double x, double y)
	{
		return Math.atan2((y - this.y), (x - this.x));
	}

	@Override
	public void add(double direction, double length)
	{
		x += Math.cos(direction) * length;
		y += -Math.sin(direction) * length;
	}
}
