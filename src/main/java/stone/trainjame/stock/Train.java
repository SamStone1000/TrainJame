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

package stone.trainjame.stock;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import stone.trainjame.cargo.Cargo;
import stone.trainjame.stock.locomotive.Locomotive;
import stone.trainjame.util.CompressedDeque;

/**
 * @author Stone
 *
 */
public class Train {

	private Deque<RollingStock> cars = new CompressedDeque<>(new LinkedList<>());
	private Deque<Locomotive> engines = new CompressedDeque<>(new LinkedList<>());
	private Deque<CargoStock> consists = new CompressedDeque<>(new LinkedList<>());
	/**
	 * The total mass of the train in kilograms
	 */
	private long weight;
	private Map<Cargo, Container> capacity = new HashMap<>();

	public Train() {
		this.weight = 0;
	}

	public void addCarFirst(RollingStock car) {
		cars.addFirst(car);
	}

	public void addLocomotiveFirst(Locomotive engine) {
		addCarFirst(engine);
		engines.addFirst(engine);
	}

	public void addCargoFirst(CargoStock consist) {
		addCarFirst(consist);
		consists.addFirst(consist);
	}

	public void addCarLast(RollingStock car) {
		cars.addLast(car);
	}

	public void removeCarFirst() {
		cars.removeFirst();
	}

	public void removeCarLast() {
		cars.removeLast();
	}

	private class Container {

		/**
		 * The current amount of cargo in this container, in units
		 */
		private double amount;
		/**
		 * The maximum amount of cargo in this container, in units
		 */
		private double capacity;

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
