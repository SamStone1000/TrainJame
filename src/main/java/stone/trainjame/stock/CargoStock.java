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

import stone.trainjame.cargo.Cargo;

/**
 * 
 */
public class CargoStock extends RollingStock {

	/**
	 * The car's capacity in units. Units can be any real world unit that should be specified in the
	 * actual cargo
	 */
	private int capacity;
	/**
	 * The type of cargo this rollingstock can carry
	 */
	private Cargo type;

	public CargoStock(int capacity, Cargo type) {
		this.capacity = capacity;
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public Cargo getType() {
		return type;
	}

}
