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

import java.util.LinkedList;

import stone.trainjame.stock.locomotive.Locomotive;
import stone.trainjame.util.CompressedDeque;
import stone.trainjame.util.Containers;
import stone.trainjame.util.PhysicsHelper;

/**
 * @author Stone
 *
 */
public class Train {

	private CompressedDeque<RollingStock> cars;
	private CompressedDeque<Locomotive> engines;
	private CompressedDeque<CargoStock> consists;

	private Containers capacity;


	public Train() {
		this.cars = new CompressedDeque<>(new LinkedList<>());
		this.engines = new CompressedDeque<>(new LinkedList<>());
		this.consists = new CompressedDeque<>(new LinkedList<>());
	}

	public void calculate() {
		double mass = cars.sum((car) ->
		{
			return car.getMass();
		});
		capacity = new Containers(consists.sumByKey((car) ->
		{
			return car.getType();
		}, (car) ->
		{
			return car.getCapacity();
		}));
		double staticTractiveEffort = engines.sum((engine) ->
		{
			return Math.min(PhysicsHelper.maxStiction(engine.getMass()),
					engine.getEngine().getStartingTractiveEffort());
		});
		double maxTractiveEffort = engines.sum((engine) ->
		{
			return Math.min(PhysicsHelper.maxStiction(engine.getMass()), engine.getEngine().getMaxTractiveEffort());
		});
		double power = engines.sum((engine) -> {
			return engine.getEngine().getMaxPower();
		});
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

}
