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
 * A class representing a unique id in a unique namespace (just like Minecraft's id system)
 */
public class Identifier {

	private String namespace;
	private String id;
	private int hash;

	public Identifier(String namespace, String id) {
		this(namespace, id, 31 * namespace.hashCode() + id.hashCode());
	}

	private Identifier(String namespace, String id, int hash) {
		this.namespace = namespace;
		this.id = id;
		this.hash = hash;
	}

	/**
	 * Automatically uses the base namespace. Only to be used for identifiers in Train Jame's base
	 * 
	 * @param id the id to use
	 */
	public Identifier(String id) {
		this("base", id);
	}

	public String getNamespace() {
		return namespace;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		Identifier other = (Identifier) obj;
		return this.namespace.equals(other.getNamespace()) && this.id.equals(other.getId());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Identifier(this.namespace, this.id, this.hash);
	}

	@Override
	public String toString() {
		return namespace + ":" + id;
	}
}