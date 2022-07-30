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

package stone.trainjame.util;

/**
 * 
 */
public abstract class PhysicsHelper {

	/**
	 * The gravitational acceleration for an object on earth's surface
	 */
	public static final double g = 9.80665;
	/**
	 * The coefficient of rolling resistance for steel wheels on steel rails
	 */
	public static final double STEEL_STEEL_ROLLING = .001;
	/**
	 * The coefficient of static friction for steel wheels on steel rails
	 */
	public static final double STEEL_STEEL_STATIC = .05;

	/**
	 * Calculates the maximum static friction
	 * 
	 * @param d
	 * @param coefficent
	 * @return
	 */
	public static double maxStiction(double weight, double coefficient) {
		return weight * coefficient;
	}

	public static double maxStiction(long mass, double coefficent) {
		return maxStiction(g * mass, coefficent);
	}

	public static double maxStiction(long mass) {
		return maxStiction(mass, STEEL_STEEL_STATIC);
	}

	/**
	 * Calculates the rolling resistance with the given coefficient of rolling resistance
	 * 
	 * @param d
	 * @param coefficent
	 * @return
	 */
	public static double rollingResistance(double weight, double coefficient) {
		return weight * coefficient;
	}

	public static double rollingResistance(long mass, double coefficient) {
		return rollingResistance(g * mass, coefficient);
	}

	public static double rollingResistance(long mass) {
		return rollingResistance(mass, STEEL_STEEL_ROLLING);
	}
}
