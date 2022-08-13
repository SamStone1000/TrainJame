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
 * A simple engine utilizing an equation to approximate a tractive effort curve.
 * Uses the equation P=(TV)/N where P is power in W, T is tractive effort in N,
 * V is velocity in m/s, and N is efficency of power to force
 */
public class SimpleEngine extends Engine {

	/**
	 * The efficiency of this engine in converting power into tractive effort
	 */
	private double efficency;
	/**
	 * The starting tractive effort of this engine in N
	 */
	private double starting;

	public SimpleEngine(double power, double efficency, double starting) {
		this.power = power;
		this.efficency = efficency;
		this.starting = starting;
	}
	@Override
	public double getTractiveEffort(double speed, double throttle) {
		double theory = (efficency * power) / speed; // uses equation (NP)/V
		return Math.min(theory, starting);
	}

	@Override
	public double getStartingTractiveEffort() {
		return starting;
	}

	@Override
	public double getMaxTractiveEffort() {
		return starting;
	}

}
