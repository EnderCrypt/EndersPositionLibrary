package com.endercrypt.library.position;

import java.io.Serializable;

public class DownsideMotion extends Motion
{
	private static final long serialVersionUID = -1510348838797560540L;

	/**
	 *  this class basically just reverses all Y positions
	 */

	public DownsideMotion()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public DownsideMotion(double x, double y)
	{
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public DownsideMotion(Motion motion)
	{
		super(motion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMotion(double direction, double length)
	{
		double x = Math.cos(direction) * length;
		double y = -Math.sin(direction) * length;
		set(x, y);
	}

	@Override
	public void addMotion(double direction, double length)
	{
		double x = Math.cos(direction) * length;
		double y = -Math.sin(direction) * length;
		add(x, y);
	}

	@Override
	public double getDirection()
	{
		return Math.atan2(-y, x);
	}
}
