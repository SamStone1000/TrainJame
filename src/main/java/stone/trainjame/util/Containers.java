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

import java.util.HashMap;
import java.util.Map;

import stone.trainjame.cargo.Cargo;

public class Containers {

	Map<Cargo, Container> containers = new HashMap<>();

	public Containers(Map<Cargo, Double> capacities) {
		capacities.forEach((Cargo key, Double value) ->
		{
			containers.put(key, new Container(value));
		});
	}

	private static class Container {

		/**
		 * The current amount of cargo in this container, in units
		 */
		private double amount;
		/**
		 * The maximum amount of cargo in this container, in units
		 */
		private double capacity;

		public Container(double capacity) {
			this.amount = 0;
			this.capacity = capacity;
		}

		/**
		 * @return the amount in units
		 */
		public double getAmount() {
			return amount;
		}

		/**
		 * @return the capacity in units
		 */
		public double getCapacity() {
			return capacity;
		}

		/**
		 * @return the fill as a percentage
		 */
		public double getFill() {
			return amount / capacity;
		}

		/**
		 * @param capacity The capacity to add to this container, in units
		 */
		public void addCapacity(double capacity) {
			this.capacity += capacity;
		}

		/**
		 * @param capacity The capacity to set this container to, in units
		 */
		public void setCapacity(double capacity) {
			this.capacity = capacity;
		}
	}
}