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
import stone.trainjame.util.MutableLong;

/**
 * @author Stone
 *
 */
public class Train {

	private Deque<RollingStockEntry> cars = new LinkedList<>();
	/**
	 * The total mass of the train in kilograms
	 */
	private long weight;
	/**
	 * The total power of the train in watts
	 */
	private long power;
	private Map<Cargo, MutableLong> capacity = new HashMap<>();

	public Train() {
		this.weight = 0;
		this.power = 0;
	}

	private void handleCarStats(RollingStock car) {
		weight += car.getWeight();
	}

	private void handleLocomotiveStats(Locomotive engine) {
		power += engine.getPower();
	}

	private void handleCargoStats(CargoStock consist) {
		capacity.computeIfAbsent(consist.getType(), (cargo) ->
		{
			return new MutableLong();
		}).add(consist.getCapacity());
	}

	public void addCarFirst(RollingStock car) {
		cars.peekFirst().addCarFirst(car);
		handleCarStats(car);
	}

	public void addLocomotiveFirst(Locomotive engine) {
		addCarFirst(engine);
		handleLocomotiveStats(engine);
	}

	public void addCargoFirst(CargoStock consist) {
		addCarFirst(consist);
		handleCargoStats(consist);
	}

	public void addCarLast(RollingStock car) {
	}

	public void removeCarFirst() {
		cars.removeFirst();
	}

	public void removeCarLast() {
		cars.removeLast();
	}

	private class RollingStockEntry {

		private RollingStock type;
		private long count;

		public RollingStockEntry(RollingStock type) {
			this.type = type;
			this.count = 1;
		}

		public void addCarFirst(RollingStock car) {
			if (type.equals(car))
			{
				count++;
			}
			else
			{
				cars.addFirst(new RollingStockEntry(car));
			}
		}
	}
}
