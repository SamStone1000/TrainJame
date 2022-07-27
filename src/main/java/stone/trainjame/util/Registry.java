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

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import stone.trainjame.cargo.Cargo;

/**
 * @param <T>
 *
 */
public class Registry<T> {

	BiMap<Identifier, T> register = HashBiMap.create();
	BiMap<T, Identifier> inverted = register.inverse();

	public void register(Identifier id, T value) {
		register.put(id, value);
	}

	public void unRegister(Identifier id) {
		register.remove(id);
	}

	public T getValue(Identifier id) {
		return register.get(id);
	}

	public Identifier getKey(T value) {
		return inverted.get(value);
	}

	public static Registry<Cargo> CARGO = new Registry<>();

}
