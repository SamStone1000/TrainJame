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
public class MutableLong extends Number implements Comparable<MutableLong> {

	private long value;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1221659948523016715L;

	public MutableLong(long value) {
		this.value = 0;
	}

	/**
	 * 
	 */
	public MutableLong() {
		this.value = 0;
	}

	public void increment() {
		value++;
	}

	public void decrement() {
		value--;
	}

	public void add(long value) {
		this.value += value;
	}

	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public int compareTo(MutableLong o) {
		return (int) (this.longValue() - o.longValue());
	}

}
