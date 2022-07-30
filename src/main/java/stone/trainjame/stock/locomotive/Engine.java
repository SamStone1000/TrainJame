/**
 * This file is part of TrainJame. 
 * Copyright (c) 2022, Stone, All rights reserved.
 * 
 * TrainJame is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * TrainJame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with TrainJame. If not, see <https://www.gnu.org/licenses/>.
 */

package stone.trainjame.stock.locomotive;

/**
 * An engine, despite the name, also includes all the internals of a locomotive
 * that allows the wheels to turn. Because of this engines can and should have
 * more to them than just a power curve. An aspiring programmer could even
 * simulate an entire steam engine in here if they so desired, as long as it
 * implements the methods.
 *
 */
public abstract class Engine {

	protected long power;

	public long getMaxPower() {
		return power;
	}

	/**
	 * Gets the tractive effort this engine would output under the given conditions.
	 * The throttle should be between 0 and 1 inclusive.
	 * 
	 * @param speed    current speed of locomotive in m/s
	 * @param throttle current throttle position as a percent
	 * @return the tractive effort in newtons
	 */
	public abstract double getTractiveEffort(double speed, double throttle);

	/**
	 * Gets the tractive effort this engine can apply while stationary. Most likely
	 * the same as the max tractive effort
	 * 
	 * @return the starting tractive effort in newtons
	 */
	public abstract double getStartingTractiveEffort();

	/**
	 * Gets the maximum tractive effort this engine can apply. Most likely the same
	 * as starting tractive effort
	 * 
	 * @return the maximum tractive effort in newtons
	 */
	public abstract double getMaxtractiveEffort();
}
