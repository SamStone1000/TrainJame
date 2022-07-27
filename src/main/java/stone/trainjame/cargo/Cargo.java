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

package stone.trainjame.cargo;

import stone.trainjame.util.Identifier;
import stone.trainjame.util.Registry;

/**
 * Represents cargo
 * 
 * Cargo has a certain weight per unit that needs to be defined, what a unit actually is up to the
 * implementer
 */
public class Cargo {

	/**
	 * The density of this cargo in terms of grams per unit
	 */
	private int density;
	private int hash;

	private Cargo(int density) {
		this.density = density;
	}

	public static Cargo create(int density, Identifier id) {
		Cargo temp = new Cargo(density);
		temp.setHash(id.hashCode());
		Registry.CARGO.register(id, temp);
		return temp;
	}

	public int getDensity() {
		return density;
	}

	public String getUnlocalizedName() {
		Identifier id = Registry.CARGO.getKey(this);
		return String.format("%s.cargo.%s", id.getNamespace(), id.getId());
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj; // identical cargo should be the same object internally
	}

	@Override
	public String toString() {
		return String.format("Density=%g g/u Hash=%d", density, hash);
	}

	private void setHash(int hash) {
		this.hash = hash;
	}
}
